package com.dotdash.tests;

import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @Before()
    public void setUp() {
          Driver.getDriver().get(ConfigurationReader.getProperty("baseUrl"));

    }

    @After ()
    public void teardown(Scenario scenario){

        if (scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }
}
