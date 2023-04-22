import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DynamicControlsPage extends BasePage {
    private String path = "/dynamic_controls";

    private By removeButtonBy = By.xpath("//button[contains(text(), 'Remove')]");
    private By addButtonBy = By.xpath("//button[contains(text(), 'Add')]");
    private By disableButtonBy = By.xpath("//button[contains(text(), 'Disable')]");
    private By enableButtonBy = By.xpath("//button[contains(text(), 'Enable')]");
    private By textInputBy = By.xpath("//input[@type='text']");
    private By checkboxBy = By.xpath("//input[@type='checkbox']");

    DynamicControlsPage(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        String url = getBaseUrl() + path;
        return url;
    }

    public void clickRemoveButton() {
        driver.findElement(removeButtonBy).click();
    }

    public void clickAddButton() {
        driver.findElement(addButtonBy).click();
    }

    public void clickDisableButton() {
        driver.findElement(disableButtonBy).click();
    }

    public void clickEnableButton() {
        driver.findElement(enableButtonBy).click();
    }

    public boolean isTextboxEnabled() {
        WebElement textbox = driver.findElement(textInputBy);
        return textbox.isEnabled();
    }

    public WebElement getCheckbox() {
        return driver.findElement(checkboxBy);
    }

    public int numOfCheckbox() {
        List<WebElement> checkboxList = driver.findElements(checkboxBy);
        return checkboxList.size();
    }

    public boolean checkboxExists() {
        return (numOfCheckbox() > 0);
    }

    public void waitForCheckboxRemoval(int timeoutSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
        int currCheckboxNum = numOfCheckbox();

        wait.until(ExpectedConditions.numberOfElementsToBe(checkboxBy, currCheckboxNum-1));
    }

    public void waitForCheckboxAdd(int timeoutSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
        int currCheckboxNum = numOfCheckbox();

        wait.until(ExpectedConditions.numberOfElementsToBe(checkboxBy, currCheckboxNum+1));
    }

    public boolean textboxEnabled() {
        WebElement textbox = driver.findElement(textInputBy);
        return textbox.isEnabled();
    }

    public void waitForEnable(int timeoutSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSec);

        wait.until(ExpectedConditions.elementToBeClickable(textInputBy));
    }

    public void waitForDisable(int timeoutSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSec);

        wait.until(ExpectedConditions.attributeContains(textInputBy, "disabled", "true"));
    }
}
