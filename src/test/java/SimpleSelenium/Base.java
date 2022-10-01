package SimpleSelenium;

import Util.ConfigurationReader;
import Util.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class Base {
    String baseUrl = ConfigurationReader.getProperty("envBase");
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    @BeforeTest
    public void setup(){

    }
    @AfterClass
    public void teardown() {
        Driver.getDriver().quit();
    }

}
