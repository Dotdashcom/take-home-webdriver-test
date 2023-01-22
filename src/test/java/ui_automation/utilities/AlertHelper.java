package ui_automation.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHelper {

    WebDriver driver;

    public AlertHelper() {
        driver = Driver.getDriver();
    }
    public static Alert getAlert() {
        return Driver.getDriver().switchTo().alert();
    }

    public static void AcceptAlert() {
        getAlert().accept();
    }

    public static void DismissAlert() {
        getAlert().dismiss();
    }

    public static String getAlertText() {
        String text = getAlert().getText();
        return text;
    }


    public static void sendKeysAlert(String message){
        Alert alert = getAlert();
        alert.sendKeys(message);
        alert.accept();
    }


}
