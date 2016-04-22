import RPi.GPIO as GPIO
from time import sleep
from os import system

PinNumber = 17

GPIO.setmode(GPIO.BCM)

GPIO.setup(PinNumber, GPIO.IN, pull_up_down = GPIO.PUD_DOWN)

if (GPIO.input(17) != 1):
	system("sudo shutdown -h now")
	GPIO.cleanup()
	exit()

def lowBatteryHandler(channel):
	system("sudo killall java")
	system("sudo /home/pi/lowBattery.sh")
	GPIO.cleanup()
	exit()

GPIO.add_event_detect(PinNumber, GPIO.FALLING, callback=lowBatteryHandler)

while True:
	sleep(1)

