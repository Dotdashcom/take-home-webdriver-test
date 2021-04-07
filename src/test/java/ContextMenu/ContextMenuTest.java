package ContextMenu;

import Pages.ContextMenuPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class ContextMenuTest extends TestBase {

    @BeforeClass
    public void loginUrl(){
        driver.get(TestBase.BASEURL.concat("/context_menu "));
    }


    @Test
    public void contentMenuTest() {
        ContextMenuPage con=new ContextMenuPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(con.emptybox).perform();
        Alert alert = Driver.getDriver().switchTo().alert();
        Assert.assertTrue(alert.getText().contains("You selected a context menu"));
    }
}
