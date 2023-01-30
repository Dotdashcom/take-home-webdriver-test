## Instructions
### To run from command line
* Download, extract and add the /bin to the PATH environment variable. https://maven.apache.org/download.cgi
* To run the test suite cd to the project root (where pom.xml is) and type:
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/suites/test_suite.xml
* Depending on your shell you might need to add quotes like:
mvn clean test "-Dsurefire.suiteXmlFiles=src/test/resources/suites/test_suite.xml"