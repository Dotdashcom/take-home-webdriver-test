package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicControlsPage extends BasePage {

    @FindBy(css = "form#checkbox-example > button")
    protected WebElement removeButton;
    @FindBy(id = "checkbox")
    protected WebElement dynamicCheckBox;
    @FindBy(id = "message")
    protected WebElement message;
    @FindBy(css = "form#checkbox-example > button")
    protected WebElement addButton;
    @FindBy(css = "form#input-example > button")
    protected WebElement enableButton;
    @FindBy(css = "form#input-example > input")
    protected WebElement inputText;
    @FindBy(css = "form#input-example > button")
    protected WebElement disableButton;

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public void removeCheckBox(){
        removeButton.click();
        waitForInvibilityOfElement(dynamicCheckBox);
    }
    public String getMessage(){
        waitForElementToBeVisible("#message");
        return message.getText();
    }
    public boolean addCheckBox(){
        addButton.click();
        waitForVisibilityOfElement(dynamicCheckBox);
        return dynamicCheckBox.isDisplayed();
    }
    public boolean enableButtonClick(){
        waitForElementToBeClickable("form#input-example > button");
        enableButton.click();
        waitForElementToBeClickable("form#input-example > input");
        return inputText.isEnabled();
    }
    public boolean disableButtonClick(){
        waitForElementToBeClickable("form#input-example > button");
        disableButton.click();
        pauseInSeconds(3);
        return inputText.isEnabled();
    }
}
