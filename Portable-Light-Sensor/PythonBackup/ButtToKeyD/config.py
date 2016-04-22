# This is the conf file for the Button-To-Key Daemon.
# Follow the syntax (Don't add extra spaces...)

import uinput as ui

# SECTION ONE
# This section should only contain 2 variables.

# Default Values:
#	Max_Event_Wait_Time = 0.3 (seconds)
#	Event_Wait_Sleep_Time = 0.1 (seconds)

# Change these variable from the default if you must,
# but DON'T leave them blank!

Max_Event_Wait_Time = 0.2
Event_Wait_Sleep_Time = 0.1

# SECTION TWO
# This section can contain n pairs.
# Each pair defines a pin(s) that are mapped to key(s)

# Consult https://github.com/tuomasjjrasanen/python-uinput
# for syntax assistance.

# The format is "Pin# = ui.KEY_X", where X is the key you want.

Key_Map = {
	13: ui.KEY_Q,
	16: ui.KEY_UP,
	19: ui.KEY_DOWN,
	20: ui.KEY_Q,
	21: ui.KEY_ENTER,
	26: ui.KEY_ENTER,
}

