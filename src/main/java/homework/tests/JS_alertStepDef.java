package homework.tests;

import homework.pages.JS_AlertPage;
import homework.test.TestBase;
import homework.utilities.Driver;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JS_alertStepDef extends TestBase {


    JS_AlertPage js_alertPage=new JS_AlertPage();
    Alert alert;


    @Test
    public void verifyJSalertButton(){

        Driver.getDriver().get("http://localhost:7080/javascript_alerts");

        js_alertPage.alertButton.click();

        alert= Driver.getDriver().switchTo().alert();
        alert.accept();

        String expectedMessage = "You successfuly clicked an alert";
        String actualMessage = js_alertPage.shownMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyConfirmButton(){

        Driver.getDriver().get("http://localhost:7080/javascript_alerts");

        js_alertPage.confirmButton.click();

        alert=Driver.getDriver().switchTo().alert();

        alert.accept();

        String expected="You clicked: Ok";
        String actual=js_alertPage.shownMessage.getText();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void verifyPromptButton(){

        Driver.getDriver().get("http://localhost:7080/javascript_alerts");
        js_alertPage.promptButton.click();

        alert=Driver.getDriver().switchTo().alert();
        alert.sendKeys("Jelena");
        alert.accept();

        String expectedText = "Jelena";
        String actualText = js_alertPage.shownMessage.getText();
        System.out.println("actualText = " + actualText);
        System.out.println("expectedText = " + expectedText);

        Assert.assertTrue(actualText.contains(expectedText) );


    }
}
