# Author: Joseph Hagan
# Purpose: A Python Daemon that is designed to run on a Raspberry Pi and convert push button input (through GPIO) to key press events.
# Libraries: I used the uinput module to achieve this. The Github repo is shown below.
# References: I used code from the following repositories to put this together:
	# Source1: https://github.com/adafruit/Adafruit_Python_MPR121/blob/master/examples/keyboard.py
	# Source2: https://github.com/tuomasjjrasanen/python-uinput


#-----------Imports-----------# 

import sys
import time
import RPi.GPIO as GPIO
import uinput as ui
from config import *

count = 0

Keyboard = None

def type(pin):
	global Key_Map
	global Keyboard
	key = Key_Map[pin]
	Keyboard.emit_click(key)

def setPins():

	global Key_Map
	
	GPIO.setmode(GPIO.BCM)
	
	pins = Key_Map.keys()
	for pin in pins:
		GPIO.setup(pin, GPIO.IN, pull_up_down=GPIO.PUD_UP)

	return 0	

def setup():
	global Key_Map
	global Keyboard
	
	
				
	Keyboard = ui.Device(Key_Map.values())
	
	setPins()
	return 0

def main():
	global Key_Map
	setup()
	pins = Key_Map.keys()
	count = 0
	while True:
		for pin in pins:
			if GPIO.input(pin) == 0:
				type(pin)
				time.sleep(0.33) 							
	return 1	

if __name__ == "__main__":
	main()
