#!/bin/bash

echo Hello!!!
echo Loading Portable Light Sensor


if [ -z "$(pgrep lxterminal)" ]
 then
 	echo Loading GUI...

 else
	startx

fi
	

