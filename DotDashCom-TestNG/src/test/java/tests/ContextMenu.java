package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class ContextMenu {

    ContextMenuPage contextMenuPage = new ContextMenuPage();
    @Test()
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl")+"context_menu"); //Go to "http://localhost:7080/context_menu" URL
        ReusableMethods.waitForPageToLoad(3); //Page load waiting for 3 seconds

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(contextMenuPage.hotSpot).build();
        action.contextClick(contextMenuPage.hotSpot).perform();

        System.out.println(("Right Click on Hotspot"));

        String message = Driver.getDriver().switchTo().alert().getText();
        System.out.println(("AlertMessage is Appeared"));

        Assert.assertEquals(message,"You selected a context menu");
        Driver.getDriver().switchTo().alert().accept();

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}