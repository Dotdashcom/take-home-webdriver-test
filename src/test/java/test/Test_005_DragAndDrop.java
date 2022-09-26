package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_005_DragAndDrop extends CommonMethods {

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/drag_and_drop");
    }

    @Test
    public void TC001_DragAndDropTesting() {
        Actions action = new Actions(getDriver());
        action.dragAndDrop(dd.getBoxA(), dd.getBoxB()).perform();
        if (dd.getBoxA().getAttribute("header").equals("B")) {
            System.out.println("Successfully Drag and Drop");
            Reporter.log("Passed!");
        } else {
            System.out.println("Failed Drag and Drop");
            Reporter.log("Failed!");
        }
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }
}
