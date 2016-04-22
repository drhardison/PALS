from time import sleep

def getFrequency():
	f = open('/home/pi/CurrentTest/output.csv', 'r')

	dev = 0.262

	numberOfSamples = 0
	times = []
	values = []

	for line in f:
		numberOfSamples += 1
		data = line.split(",")
		timestamp = float(data[0])
		value = float(data[1])
		times.append(timestamp)
		values.append(value)

	f.close()

	max = 0.0
	min = 5.0


	for x in values:
		if x > max:
			max = x
		if x < min:
			min = x

	index = 0
	Peak1 = False
	Low1 = False
	Peak2 = False
	high = max - (dev*(max-min))
	low = min + (dev*(max-min))
	t1 = 0.0
	t2 = 0.0
	t3 = 0.0
	v1 = 0.0
	v2 = 0.0
	v3 = 0.0

	approxFreqs = []

	for x in values:
		if ( high <= x <= max and not Peak1 ):
			Peak1 = True
			t1 = times[index]
			v1 = x
		elif ( min <= x <= low and Peak1 and not Low1 ):
			Low1 = True
			t2 = times[index]
			v2 = x
		elif (high <= x <= max and Low1 and not Peak2 ):
			Peak2 = True
			t3 = times[index]
			v3 = x
			approxFreqs.append(1/(t3-t1))
			Low1 = False
			Peak2 = False
			t1 = t3

		index += 1

	total = 0.0
	count = 0

	for freq in approxFreqs:
		count += 1
		total += freq

	frequency1 = total/count

	index = 0
	Low1 = False
	Peak1 = False
	Low2 = False
	high = max - (dev*(max-min))
	low = min + (dev*(max-min))
	t1 = 0.0
	t2 = 0.0
	t3 = 0.0
	v1 = 0.0
	v2 = 0.0
	v3 = 0.0

	approxFreqs = []

	for x in values:
			if ( min <= x <= low and not Low1 ):
					Low1 = True
					t1 = times[index]
					v1 = x
			elif ( high <= x <= max and Low1 and not Peak1 ):
					Peak1 = True
					t2 = times[index]
					v2 = x
			elif ( min <= x <= low and Peak1 and not Low2 ):
					Low2 = True
					t3 = times[index]
					v3 = x
					approxFreqs.append(1/(t3-t1))
					Peak1 = False
					Low2 = False
					t1 = t3

			index += 1

	total = 0.0
	count = 0

	for freq in approxFreqs:
			count += 1
			total += freq

	frequency2 = total/count

	frequency1 = round(frequency1,2)
	frequency2 = round(frequency2,2)


	#print "Frequency #1 = %.2f\n" % frequency1
	#print "Frequency #2 = %.2f\n" % frequency2

	frequency = round((frequency1 + frequency2)/2,0)
	frequency = int(frequency)

	#print "Averaged Frequency = %.2f\n" % frequency
	
	return frequency
