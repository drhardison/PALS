#!/usr/bin/python
from Adafruit_ADS1x15 import ADS1x15
import time

StartTime = 0

def getDeltaTime():
	return (time.time() - StartTime)
	
ADS1115 = 0x01	# 16-bit ADC

# Initialise the ADC using the default mode (use default I2C address)
# Set this to ADS1015 or ADS1115 depending on the ADC you are using!
adc = ADS1x15(ic=ADS1115)

#Initialize File For Storage
f = open('/home/pi/CurrentTest/output.csv', 'w')

# Set Exit Control to False
exit = False

# Define Length of Runtime (in seconds)
Runtime = 10

# Now Start Continuous Differential Reading of Channels 2 and 3
adc.startContinuousDifferentialConversion(2,3,6144,860)/1000

StartTime = time.time()

while not exit:
	delta = getDeltaTime()
	volts = (adc.getLastConversionResults()/1000)
	f.write(str(delta))
	f.write(",")
	f.write(str(volts))
	f.write("\n")
	print "%.3f\n" % delta
	print "%.3f\n" % volts
	if (getDeltaTime() >= Runtime):
		exit = True
		
adc.stopContinuousConversion()
f.close()
