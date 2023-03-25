package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JavaScriptAlertsPage extends BasePage {

    private By jsAlertButton = By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button");
    private By jsConfirmButton = By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button");
    private By jsPromptButton = By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button");
    private By alertMessage = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    public void clickJsAlertButton() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jsAlertButton));
        getElement(jsAlertButton).click();
    }

    public void clickJsConfirmButton() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jsConfirmButton));
        getElement(jsConfirmButton).click();
    }

    public void clickJsPromptButton() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jsPromptButton));
        getElement(jsPromptButton).click();
    }

    public void typeMessageOnPrompt(String message) {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(message);
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public String getMessage() {
        return getMessage(alertMessage);
    }
}
