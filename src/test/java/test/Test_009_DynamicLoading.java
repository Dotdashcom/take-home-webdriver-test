package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_009_DynamicLoading extends CommonMethods {

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/dynamic_loading/2 ");
    }

    @Test
    public void TC001_DynamicLoadingTest() {
        dl.startBtn().click();
        visibleOfElements(dl.dispText());
        String displayText = dl.dispText().getText();
        Assert.assertTrue(displayText.contains("Hello World"));
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }
}
