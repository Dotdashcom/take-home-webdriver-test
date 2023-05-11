package task.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import task.pages.JavaScriptAlertsPage;
import task.utilities.Driver;

public class JavaScriptAlerts {

    JavaScriptAlertsPage jsPage = new JavaScriptAlertsPage();
    Alert alert;
    @BeforeEach
    public void setUp(){
        Driver.getDriver().get("http://localhost:7080/javascript_alerts");
    }



    @Test
    public void testJSalerts(){

        jsPage.jsAlert.click();
        alert  = Driver.getDriver().switchTo().alert();
        alert.dismiss();

        String expectedMessage = "You successfuly clicked an alert";
        String actualMessage = jsPage.result.getText();
        Assertions.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void testJSconfirm(){

        jsPage.jsConfirm.click();
        alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        String expectedMessage = "You clicked: Ok";
        String actualMessage = jsPage.result.getText();
        Assertions.assertEquals(expectedMessage, actualMessage);


    }

    @Test
    public void testJSprompt(){

        jsPage.jsPrompt.click();
        alert  = Driver.getDriver().switchTo().alert();
        alert.sendKeys("The message!");
        alert.accept();

        String expectedText = "The message!";
        String actualText = jsPage.result.getText();
        System.out.println("actualText = " + actualText);
        System.out.println("expectedText = " + expectedText);

        Assertions.assertTrue(actualText.contains(expectedText) );

    }


    @AfterEach
    public void tearDown() {
        Driver.closeDriver();
    }

}
