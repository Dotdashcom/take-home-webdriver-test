### How to run tests:
- make sure that Java(version 8+) and Maven are is installed 
- download the project
- in accordance with your OS and Chrome browser version, download corresponding Chromedriver from  https://chromedriver.chromium.org/downloads and unzip it into "webdriver" dir in the project root dir
- make sure that http://localhost:7080/ is up and running
- go to project root dir and run via CLI: mvn test
- find the test reports in target/surefire-reports dir 

### A note regarding tests execution time.
Tests were implemented in accordance with "All tests should provide a setup and tear down mechanism that closes the browser." requirement, i.e. web browser is opened for each test and then closed.
However, the total execution time could be significantly reduced (from about 60s to 26s) if to open the browser only once (before the test set execution), and to close after the test set execution.
