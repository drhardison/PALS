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

def main():
	init()
	input = bus.read_i2c_block_data(0x29, 0)
	blue = input[7] << 8 | input[6]
	print "Blue:", blue

	
if __name__ == "__main__":
    main()	
