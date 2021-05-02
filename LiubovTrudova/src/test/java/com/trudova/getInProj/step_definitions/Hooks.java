package com.trudova.getInProj.step_definitions;

import com.trudova.getInProj.utilities.ConfigurationReader;
import com.trudova.getInProj.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void i_am_on_the_base_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("environment"));
    }

    @After()
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}