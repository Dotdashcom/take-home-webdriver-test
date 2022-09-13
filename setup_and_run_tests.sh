#!/bin/sh
# Start the docker container that the tests will run against
docker run -d -p 7080:5000 gprestes/the-internet
# Run the e2e tests
mvn test
# Wait for the test run to complete
wait
# Stop docker container
docker stop "$(docker ps -q --filter ancestor=gprestes/the-internet)"