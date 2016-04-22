#imports
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)

# GPIO Pin Setup
GPIO.setup(7,GPIO.OUT)		#output for RGB
GPIO.setup(8,GPIO.OUT)		#output for 490-Blue sensor

# Setting all Pins to LOW and Pin Assignments
GPIO.output(7,1)
GPIO.output(8,0)
