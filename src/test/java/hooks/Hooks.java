package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;

public class Hooks {
    @Before
    public void setUpScenario(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }

    @After
    public void tearDownScenario(Scenario scenario){
        if(scenario.isFailed()){
            byte[]screenShot= ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot,"image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
