package regression.ui.model;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class JavascriptAlertsPage extends WebObject {
    public JavascriptAlertsPage(WebDriver driver) throws Exception {
        super(driver);
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public static JavascriptAlertsPage navigateToJavascriptAlertsPage(WebDriver driver, String baseUrl) throws Exception {
        String url = String.format("%s/javascript_alerts", baseUrl);
        driver.get(url);
        return new JavascriptAlertsPage(driver);
    }

    public String getPageTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public void clickJsAlert() {
        WebElement jsAlertButton = driver.findElement(By.xpath(this.xpathForJsAlert()));
        jsAlertButton.click();
    }

    public void clickJsConfirm() {
        WebElement jsConfirmButton = driver.findElement(By.xpath(this.xpathForJsConfirm()));
        jsConfirmButton.click();
    }

    public void clickJsPrompt() {
        WebElement jsPromptButton = driver.findElement(By.xpath(this.xpathForJsPrompt()));
        jsPromptButton.click();
    }

    public void enterAlertText(String message) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(message);
    }

    public String getAlertMessage() {
        Alert jsConfirmDialog = driver.switchTo().alert();
        String alertMessage = jsConfirmDialog.getText();
        jsConfirmDialog.accept();
        return alertMessage;
    }

    public String getResultMessage() {
        return driver.findElement(By.xpath(this.xpathForResult())).getText();
    }

    private String xpathForPageTitle() {
        return "//h3";
    }

    private String xpathForJsAlert() {
        return "//button[text()= \"Click for JS Alert\"]";
    }

    private String xpathForJsConfirm() {
        return "//button[text()= \"Click for JS Confirm\"]";
    }

    private String xpathForJsPrompt() {
        return "//button[text()= \"Click for JS Prompt\"]";
    }

    private String xpathForResult() {
        return "//*[@id=\"result\"]";
    }
}
