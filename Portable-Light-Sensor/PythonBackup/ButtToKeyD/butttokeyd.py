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

Keyboard = None

def setPins():

	global Key_Map
	
	GPIO.setmode(GPIO.BCM)
	
	pins = Key_Map.keys()
	for pin in pins:
		GPIO.setup(pin, GPIO.IN, pull_up_down=GPIO.PUD_UP)
		GPIO.add_event_detect(pin, GPIO.FALLING)
	
	return 0	

def setup():
	global Key_Map
	global Keyboard
			
	Keyboard = ui.Device(Key_Map.values())
	
	setPins()
	return 0

def type(pin):
	global Key_Map
	global Keyboard
	key = Key_Map[pin]
	Keyboard.emit_click(key)

def Event_Detected():
	for pin in Key_Map.keys():
		if GPIO.event_detected(pin):
			return True

def main():
	global Max_Event_Wait_Time
	global Event_Wait_Sleep_Time
	global Key_Map
	global Keyboard
	setup()
	pins = Key_Map.keys()
	print pins
	while True:
		start = time.time()
		while (time.time() - start) < Max_Event_Wait_Time:
			time.sleep(Event_Wait_Sleep_Time)
		for pin in pins:
			if GPIO.event_detected(pin):
				type(pin)
		
	return 1	


if __name__ == "__main__":
	main()
