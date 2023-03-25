package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicControlsPage extends BasePage {
    private By checkBox = By.id("checkbox");
    private By inputField = By.xpath("//input[@type='text']");
    private By removeAddButton = By.xpath("//*[@id=\"checkbox-example\"]/button");
    private By enableDisableButton = By.xpath("//*[@id=\"input-example\"]/button");
    private By message =  By.id("message");

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public String getMessage(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(message));
        return getMessage(message);
    }

    public void clickRemoveAddButton(){
        wait.until(ExpectedConditions.elementToBeClickable(removeAddButton));
        getElement(removeAddButton).click();
    }

    public void clickEnableDisableButton(){
        wait.until(ExpectedConditions.elementToBeClickable(enableDisableButton));
        getElement(enableDisableButton).click();
    }

    public boolean isCheckboxEnabled() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        return driver.findElement(checkBox).isEnabled();
    }

    public boolean isInputFieldEnabled() {
        return driver.findElement(inputField).isEnabled();
    }

}
