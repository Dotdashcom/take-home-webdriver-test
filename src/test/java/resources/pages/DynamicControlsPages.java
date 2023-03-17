package resources.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.utilities.BaseClass;

public class DynamicControlsPages extends BaseClass {

    public DynamicControlsPages() {

        PageFactory.initElements(driver,this);
    }

    @FindBy(css="form#checkbox-example>button")
    WebElement removeButton;

    @FindBy(css="div#checkbox")
    WebElement checkBox;

    @FindBy(css="form#checkbox-example>button")
    WebElement AddButton;

    @FindBy(css="input#checkbox")
    WebElement checkBox2;

    @FindBy(css="form#input-example>button")
    WebElement EnableButton;

    @FindBy(css="form#input-example>input")
    WebElement TextBox;

    @FindBy(css="form#input-example>button")
    WebElement DisableButton;

    public void userClickRemoveButton() {
        removeButton.click();
    }

    public boolean userCheckBoxNotFound() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        boolean status=wait.until(ExpectedConditions.invisibilityOf(checkBox));
        return status;

    }
    public void userClickAddButton() {
        AddButton.click();
    }
    public boolean userCheckBoxPresent() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(checkBox2));
        boolean checkBoxDisplayed= checkBox2.isDisplayed();
        return checkBoxDisplayed;
    }
    public void userClickEnableButton() {
        EnableButton.click();
    }

    public boolean userCheckTextBoxEnabled() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(DisableButton, "Disable"));
        boolean status=TextBox.isEnabled();
        return status;

    }
    public void userClickDisableButton() {
        DisableButton.click();
    }
    public boolean userTextBoxDisabled() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(DisableButton, "Enable"));
        boolean status=TextBox.isEnabled();
        return status;
    }
}
