#!/usr/bin/python

from getFreq import getFrequency as getFreq
from datetime import datetime as date
from os import makedirs as mkdir
from os.path import exists
from os.path import dirname
from os import rename as move

# Have a Current Test Directory That Always has Current Test...
# When This Runs, create new Directory for this report and raw data.
# Generate Report in Current Test Directory
# Move Report and All Raw Files to New Directory

cwd = "/home/pi/CurrentTest/"
archivesDirectory = "/home/pi/ArchivedTests/"

def readRedValues():
	red = []
	filename = cwd + "RGB.txt"
	f = open(filename, 'r')
	for line in f:
		data = line.split("\t")
		red.append(data[0])
	f.close()
	red.pop(0)
	return map(int, red)

def readGreenValues():
	green = []
	filename = cwd + "RGB.txt"
	f = open(filename, 'r')
	for line in f:
		data = line.split("\t")
		green.append(data[1])
	f.close()
	green.pop(0)
	return map(int, green)

def readBlueValues():
	blue = []
	filename = cwd + "RGB.txt"
	f = open(filename, 'r')
	for line in f:
		data = line.split("\t")
		blue.append(data[2])
	f.close()
	blue.pop(0)
	return map(int, blue)

def readClearValues():
	clear = []
	filename = cwd + "RGB.txt"
	f = open(filename, 'r')
	for line in f:
		data = line.split("\t")
		clear.append(data[3])
	f.close()
	clear.pop(0)
	return map(int, clear)

def readTempValues():
	temp = []
	filename = cwd + "RGB.txt"
	f = open(filename, 'r')
	for line in f:
		data = line.split("\t")
		temp.append(data[4])
	f.close()
	temp.pop(0)
	return map(int, temp)

def readLuxValues():
	lux = []
	filename = cwd + "RGB.txt"
	f = open(filename, 'r')
	for line in f:
		data = line.split("\t")
		lux.append(data[5])
	f.close()
	lux.pop(0)
	return map(int, lux)

def readBlue2Values():
	blue2 = []
	filename = cwd + "Blue.txt"
	f = open(filename, 'r')
	for line in f:
		data = line.split("\n")
		blue2.append(data[0])
	f.close()
	blue2.pop(0)
	return map(int, blue2)	

def readIRValues():
	ir = []
	filename = cwd + "UV+IR.txt"
	f = open(filename, 'r')
	for line in f:
		data = line.split("\t")
		ir.append(data[1])
	f.close()
	ir.pop(0)
	return map(int, ir)
	
def readUVValues():
	uv = []
	filename = cwd + "UV+IR.txt"
	f = open(filename, 'r')
	for line in f:
		data = line.split("\t")
		uv.append(data[2])
	f.close()
	uv.pop(0)
	return map(int, uv)

def readUVIndexes():
	indexes = []
	filename = cwd + "UV+IR.txt"
	f = open(filename, 'r')
	for line in f:
		data = line.split("\t")
		indexes.append(data[3])
	f.close()
	indexes.pop(0)
	return map(int, indexes)
	
def getAverage(list):
	total = 0.0
	count = 0.0
	for x in list:
		total += x
		count += 1
	return (total/float(count))
	
def relocate(timestamp):
	dateStamp = date.now()
	year = str(dateStamp.year)
	month = str(dateStamp.month)
	day = str(dateStamp.day)
	
	newDir = (archivesDirectory + year + "/" + month + "/" + day + "/" + timestamp + "/")
	
	dir = dirname(newDir)
	
	if not exists(dir):
		mkdir(dir)
	
	src = cwd + "*"
	dst = newDir + "*"
	move(src, dst)

def main():
	red =int(getAverage(readRedValues()))
	green = int(getAverage(readGreenValues()))
	blue = int(getAverage(readBlueValues()))
	blue2 = int(getAverage(readBlue2Values()))
	temp = int(getAverage(readTempValues()))
	lux = int(getAverage(readLuxValues()))
	uv = int(getAverage(readUVValues()))
	ir = int(getAverage(readIRValues()))
	index = int(getAverage(readUVIndexes()))
	flicker = getFreq()
	
	time = date.now()
	
	hour = str(time.hour)
	min = str(time.minute)
	sec = str(time.second)
	
	timestamp = (hour + "_" + min + "_" + sec)
	filepath = cwd + timestamp + ".rep"
	
	print (timestamp + ".rep")

	f = open(filepath, 'w')
		
	f.write(("Red = " + str(red) + "\n"))
	f.write(("Green = " + str(green) + "\n"))
	f.write(("Blue = " + str(blue) + "\n"))
	f.write(("480 nm = " + str(blue2) + "\n"))
	f.write(("UV = " + str(uv) + "\n"))
	f.write(("IR = " + str(ir) + "\n"))
	f.write(("Flicker = " + str(flicker) + " Hz\n"))
	f.write(("Color Temp = " + str(temp) + " K \n"))
	f.write(("Lux = " + str(lux) + " K \n"))
	f.write(("UV Index = " + str(index) + "\n"))
	
	f.close()
	
	#relocate(timestamp)
	
	
#============ Main Method Referral ============#
if __name__ == "__main__":
    main()

