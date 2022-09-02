package Tests;

import Pages.JSAlertPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSAlertTest {
    String baseURL="http://localhost:7080";
    @Test
    public void jsAlertsTest(){
        JSAlertPage jsAlertPage=new JSAlertPage();
        Driver.getDriver().get(baseURL+"/javascript_alerts");
        jsAlertPage.JSAlertButton.click();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=Driver.getDriver().switchTo().alert();
        String text=alert.getText();
        assertEquals("I am a JS Alert", text);
    }
}
