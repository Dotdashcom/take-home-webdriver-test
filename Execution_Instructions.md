# Automation Framework 
## Author: Nazmus Saquib
### Develop Premises
1. OS = Windows
2. IDE = IntelliJ
3. Project Structure = Maven

### Pre-requisites
1. Update the project external libs using `pom.xml`.
2. Include `ashot` jar in the project (if Maven fails to download the dependency jar ). `ashot` is available in `ExternalLibs` folder.
3. Install `allure` commandline. Please follow the instructions given in [Allure 2.1](https://docs.qameta.io/allure/)
4. Verify `allure` is installed properly (Hint Windows OS: `where allure` to show path. `<path> --version` displays the `allure version`)
5. Add the path to the `chromedriver` in the `config.properties` file under `Configs` folder based on the Chrome Version.

### Test Execution
1. Execute `mvn test` to run the tests.
2. Execute `allure serve allure-results` for test result.
3. All the tests are categorized based on `Features By Stories`/`Behaviors`.

