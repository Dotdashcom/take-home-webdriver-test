package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_004_ContextMenu extends CommonMethods {

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/context_menu");
    }

    @Test
    public void TC001_contextMenuTesting() {
        rightClick(cm.getBox());
        Alert alert = getDriver().switchTo().alert();
        String alertText = alert.getText();
        Assert.assertTrue(alertText.contains("context menu"));
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }
}
