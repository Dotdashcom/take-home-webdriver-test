package Test;

import Utilities.DriverHelper;
import Main.ContextPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckContextTest {

    ContextPage contextPage =new ContextPage();


    @Test
    public void Context_Test(){

        DriverHelper.getDriver().get("http://localhost:7080/context_menu");

        DriverHelper.getDriver().manage().window().maximize();

        Actions actions =new Actions(DriverHelper.getDriver());

        actions.contextClick(contextPage.Context).perform();

        Alert alert =DriverHelper.getDriver().switchTo().alert();

        System.out.println(alert.getText());

        Assert.assertEquals(alert.getText(),"You selected a context menu");

        DriverHelper.closeDriver();


    }
}