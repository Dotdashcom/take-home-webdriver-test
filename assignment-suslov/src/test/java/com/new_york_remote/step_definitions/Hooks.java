package com.new_york_remote.step_definitions;

import com.new_york_remote.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUpScenario(){
        System.out.println("----------Setting up browser with further details...");
        driver = Driver.getDriver();
    }




    @After
    public void tearDownScenario(Scenario scenario){
        if(scenario.isFailed()){
            byte[]screenShot= ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot,"image/png", scenario.getName());
        }
//        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
//        wait.until(driver1 -> String
//                .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
//                .equals("complete"));
        Driver.closeDriver();
    }

    @BeforeStep
    public void runBeforeStep(){
        System.out.println("--------------Running Before Each STEP------------------");
    }
    @AfterStep
    public void runAfterStep(){
        System.out.println("-----------------Running After Each STEP");
    }
}
