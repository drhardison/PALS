#!/bin/bash

echo -e "My Battery is Low.\n I Will Now Shut Down." | xmessage -button OK -center -default OK -file -

shutdown -h now

