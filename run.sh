#!/bin/sh
# Run
echo "Start containers"
docker run -d -p 4445:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome
docker run -d -p 7080:5000 gprestes/the-internet
wait
echo "Run the suite"
mvn test -DsuiteXmlFile=testng.xml
# On the grid
# mvn test -DsuiteXmlFile=testng-selenium-grid.xml
wait
# Stop containers
docker stop "$(docker ps -q --filter ancestor=gprestes/the-internet)"
docker stop "$(docker ps -q --filter ancestor=selenium/standalone-chrome)"