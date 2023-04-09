package com.internet.stepdefinitions;

import com.internet.utilities.ConfigurationReader;
import com.internet.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Setup {

    @Before
    public void setup(Scenario scenario) {
        System.out.println("Test Setup for: " +scenario.getName()+"\n"+"Good Luck!");
        System.out.println("Using browser size: "+Driver.getDriver(ConfigurationReader.getProperty("browser")).manage().window().getSize());

    }

    @After()
    public void teardown(Scenario scenario){
        if(scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) Driver.getDriver(ConfigurationReader.getProperty("browser"))).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());
        }
        else{
            System.out.println("Your Lucky Day, It passed!");
        }
        System.out.println("Test Clean Up");
        Driver.closeDriver();
        System.out.println(":::(^_^) End of test execution (*_*)::::");

    }

}
