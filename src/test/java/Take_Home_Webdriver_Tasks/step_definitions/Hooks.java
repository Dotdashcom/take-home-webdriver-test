package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.utilities.ConfigurationReader;
import Take_Home_Webdriver_Tasks.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("page.url"));
        System.out.println("-->SETUP SUCCESSFULLY");
    }


    @After
    public void tearDown(Scenario scenario){
        System.out.println("-->SUCCESSFULLY TEAR DOWN");

        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
