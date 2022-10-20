#!/bin/sh
# Setup
echo "First, follow the instructions in the README.md file."
echo "Then, proceed here."
wait
docker pull selenium/standalone-chrome
docker pull gprestes/the-internet
mvn clean install -f pom.xml -DskipTests
wait
chmod +x run.sh