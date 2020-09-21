package testsJunit;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utils.Driver;

public class JavaScriptAlerts extends BaseClass {
    //I am on the JavaScript Alerts  page
    //I click on JS Alert Button
    //I verify alert message
    //I click on JS confirm Button and click ok on alert
    //I verify the alert message
    //I click on JS Prompt Button and type a message on prompt
    //I verify that the alert message contains the typed message

    @Test
    public void i_am_on_the_JavaScript_Alerts_page() throws InterruptedException {

        Driver.getDriver().get("http://localhost:7080/javascript_alerts");
        Driver.getDriver().findElement(By.xpath("//button[text()='Click for JS Alert' ]")).click();
        String expected1= "I am a JS Alert";
        Alert alert = Driver.getDriver().switchTo().alert();
        String textOnAlert = alert.getText();


        Assert.assertTrue(textOnAlert.contains(expected1));
        System.out.println("The alert message is " + textOnAlert);
        alert.accept();

        Driver.getDriver().findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        textOnAlert = alert.getText();
        String expected = "I am a JS Confirm";

        Assert.assertTrue(textOnAlert.contains(expected));
        System.out.println("The alert message of JS confirm Button is " + textOnAlert);
        alert.accept();

        Driver.getDriver().findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        String expected2 = "Hello!";
        Thread.sleep(2000);
        alert.sendKeys("Hola");
       // Assert.assertTrue(textOnAlert.contains(expected2));
        alert.accept();

    }

}
