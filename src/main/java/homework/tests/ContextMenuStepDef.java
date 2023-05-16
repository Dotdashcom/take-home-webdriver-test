package homework.tests;

import homework.pages.ManuPage;
import homework.test.TestBase;
import homework.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuStepDef extends TestBase {

    ManuPage manuPage=new ManuPage();
    String expectedText="You selected a context menu";


    @Test
    public void verifyRightClick(){

        Driver.getDriver().get("http://localhost:7080/context_menu");
        Actions actions=new Actions(Driver.getDriver());

        actions.contextClick(manuPage.box).perform();

        Alert alert=Driver.getDriver().switchTo().alert();
        String shownText=alert.getText();

        alert.dismiss();

        Assert.assertEquals(shownText, expectedText);



    }
}
