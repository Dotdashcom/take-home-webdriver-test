package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlPage extends BasePage {

    @FindBy(id="checkbox")
    WebElement checkbox;

    @FindBy(css="#checkbox-example button")
    WebElement removeAddButton;

    @FindBy(css="#input-example input")
    WebElement textInput;

    @FindBy(css="#input-example button")
    WebElement enabledDisabledButton;

    public DynamicControlPage(WebDriver driver) {
        super(driver);
    }

    public void clickRemoveAddCheckbox(){
        removeAddButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(elementTimeout));
        wait.until(ExpectedConditions.elementToBeClickable(removeAddButton));
    }

    public boolean isCheckboxPresent(){
        try {
            return checkbox.isDisplayed();
        } catch (Throwable t){
            return false;
        }
    }

    public void clickEnableDisableTextInput(){
        enabledDisabledButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(elementTimeout));
        wait.until(ExpectedConditions.elementToBeClickable(enabledDisabledButton));
    }

    public boolean isTextInputEnabled(){
        return textInput.isEnabled();
    }

}
