# imports
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)

# GPIO Pin Setup
GPIO.setup(7,GPIO.OUT)		#output for RGB
GPIO.setup(8,GPIO.OUT)		#output for 490-Blue sensor

# Setting BLUE pin
GPIO.output(7,0)     
GPIO.output(8,1)        
