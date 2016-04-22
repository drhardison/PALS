#UV & IR Sensor for Portable Light Sensor

import SI1145.SI1145 as uv

sensor = uv.SI1145()

visible = sensor.readVisible()
infrared = sensor.readIR()
ultraviolet = sensor.readUV()

UVIndex = ultraviolet/100

print "Visible:", visible
print "Infrared:", infrared
print "UV:", ultraviolet
print "UV Index:", UVIndex

