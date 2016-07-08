#!/bin/bash
POS_HOME=/opt/public-opinion-shell

echo starting ...
if [ "$JAVA_HOME" = "" ]; then
  echo "Error: JAVA_HOME is not set."
  exit 1
fi

$JAVA_HOME/bin/java -jar $POS_HOME/public-opinion-shell-0.0.1-SNAPSHOT.jar
