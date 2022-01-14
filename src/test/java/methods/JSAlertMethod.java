package methods;

import model.JSAlertPage;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

public class JSAlertMethod extends GeneralTestMethod{
    private final String jsAlertURL = "http://localhost:7080/javascript_alerts";
    JSAlertPage jsAlertPage;

    public void startJSAlertTest() {
        driver.get(jsAlertURL);
        jsAlertPage = new JSAlertPage(driver);
        WebElement alertButton = jsAlertPage.alertComponent();
        clickOn(alertButton);
        assertEquals(getAlertMSG(),"I am a JS Alert");
        closeAlert();

        WebElement confirmButton = jsAlertPage.confirmComponent();
        clickOn(confirmButton);
        assertEquals(getAlertMSG(),"I am a JS Confirm");
        closeAlert();

        WebElement promptButton = jsAlertPage.promptComponent();
        clickOn(promptButton);
        typeIn("Hello");
        closeAlert();
        assertEquals(getResultMSG(), "You entered: Hello");

    }

    public void clickOn(WebElement button) {
        button.click();
    }

    public String getAlertMSG() {
        return driver.switchTo().alert().getText();
    }

    public void closeAlert() {
        driver.switchTo().alert().accept();
    }

    public void typeIn(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public String getResultMSG() {
        return jsAlertPage.resultComponent().getText();
    }

}
