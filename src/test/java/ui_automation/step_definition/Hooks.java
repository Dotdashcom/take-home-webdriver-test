package ui_automation.step_definition;

import io.cucumber.core.api.Scenario;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    WebDriver driver;

    @Before
    public void setUp(){
        driver = Driver.getDriver();
        String logInURL = (ConfigurationReder.getProperties("ui-config.properties", "LogInURL"));
        driver.get(logInURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @After
    public void tearDown(){

        Driver.closeDriver();
    }
}
