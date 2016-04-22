import sys
import smbus
import time
bus = smbus.SMBus(1)

def init():
	# I2C address 0x29
	# Register 0x12 has device ver. 
	# Register addresses must be OR'ed with 0x80
	bus.write_byte(0x29,0x80|0x12)
	ver = bus.read_byte(0x29)
	if ver == 0x44:
		# version # should be 0x44
		bus.write_byte(0x29, 0x80|0x00) # 0x00 = ENABLE register
		bus.write_byte(0x29, 0x01|0x02) # 0x01 = Power on, 0x02 RGB sensors enabled
		bus.write_byte(0x29, 0x80|0x14) # Reading results start register 14, LSB then MSB
	else: 
		print "Device not found\n"
		sys.exit(1)

def getData():
	input = bus.read_i2c_block_data(0x29, 0)
	clear = clear = input[1] << 8 | input[0]
	red = input[3] << 8 | input[2]
	green = input[5] << 8 | input[4]
	blue = input[7] << 8 | input[6]
	dict = {}
	dict['r'] = red
	dict['g'] = green
	dict['b'] = blue
	dict['c'] = clear
	return dict
	

#Static Utility Methods
def calculateColorTemperature(rgb):
	"Converts the raw R/G/B values to color temperature in degrees Kelvin"

	if not isinstance(rgb, dict):
		raise ValueError('calculateColorTemperature expects dict as parameter')

	# 1. Map RGB values to their XYZ counterparts.
	# Based on 6500K fluorescent, 3000K fluorescent
	# and 60W incandescent values for a wide range.
	# Note: Y = Illuminance or lux
	X = (-0.14282 * rgb['r']) + (1.54924 * rgb['g']) + (-0.95641 * rgb['b'])
	Y = (-0.32466 * rgb['r']) + (1.57837 * rgb['g']) + (-0.73191 * rgb['b'])
	Z = (-0.68202 * rgb['r']) + (0.77073 * rgb['g']) + ( 0.56332 * rgb['b'])

	# Check for divide by 0 (total darkness) and return None.
	if (X + Y + Z) == 0:
		return -1

	# 2. Calculate the chromaticity co-ordinates
	xc = (X) / (X + Y + Z)
	yc = (Y) / (X + Y + Z)

	# Check for divide by 0 again and return None.
	if (0.1858 - yc) == 0:
		return -1

	# 3. Use McCamy's formula to determine the CCT
	n = (xc - 0.3320) / (0.1858 - yc)

	# Calculate the final CCT
	cct = (449.0 * (n ** 3.0)) + (3525.0 *(n ** 2.0)) + (6823.3 * n) + 5520.33

	return int(cct)

def calculateLux(rgb):
	"Converts the raw R/G/B values to color temperature in degrees Kelvin"

	if not isinstance(rgb, dict):
		raise ValueError('calculateLux expects dict as parameter')

	illuminance = (-0.32466 * rgb['r']) + (1.57837 * rgb['g']) + (-0.73191 * rgb['b'])

	return int(illuminance)

def main():
	init()
	data = getData()
	red = data['r']
	green = data['g']
	blue = data['b']
	clear = data['c']
	temp = calculateColorTemperature(data)
	lux = calculateLux(data)
	
	print "Red:", red
	print "Green:", green
	print "Blue:", blue
	print "Clear:", clear
	print "Temp:", temp
	print "Lux:", lux
	
if __name__ == "__main__":
    main()	
