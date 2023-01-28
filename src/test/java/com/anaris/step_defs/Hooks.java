package com.anaris.step_defs;

import com.anaris.utilities.ConfigurationReader;
import com.anaris.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //@Before
    public void setUp(){

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @After
    public void tearDownScenario(Scenario scenario){
        //  We will implement taking screenshot in this method

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }


}
