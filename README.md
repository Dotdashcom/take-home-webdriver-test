# Webdriver Tests
## Prerequisites
  * Docker
  + Git
  - Java
  * Webdriver
  + ChromeDriver
  * IDE such as IntelliJ

## Steps
1. Pull Docker image for the-internet app:
  
    `docker pull gprestes/the-internet`
  
2. Run the following command: 

    `docker run -d -p 7080:5000 gprestes/the-internet`
  
3. Execute command:

   `mvn clean test -Dsurefire.suiteXmlFiles=runner.xml`
  