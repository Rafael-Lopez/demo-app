#!/bin/sh

##directory where jar file is located
dir=target

##jar file name
jar_name=demo-app-1.0-SNAPSHOT-jar-with-dependencies.jar

## Perform validation on input arguments
if [ -z "$1" ] && [ -z "$2" ]; then
        echo "Missing arguments, exiting.."
        echo "Usage : export.sh [-v] /path/to/xml"
        exit 1
fi

if [ $1 = "-v" ]; then
      "C:\Program Files (x86)\Java\jdk1.8.0_281\bin\java" -DfilePath=$2 -DprintKeys -jar $dir/$jar_name
else
      "C:\Program Files (x86)\Java\jdk1.8.0_281\bin\java" -DfilePath=$1 -jar $dir/$jar_name
fi

# To see application output - can be removed
sleep 10