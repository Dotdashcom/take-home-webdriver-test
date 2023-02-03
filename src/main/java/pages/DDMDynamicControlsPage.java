package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DDMDynamicControlsPage extends DDMBasePage  {
    @FindBy(css = "form#checkbox-example > button")
    protected WebElement addRemoveButton;

    @FindBy(id = "checkbox")
    protected WebElement dynamicCheckBox;

    @FindBy(id = "message")
    protected WebElement message;

    @FindBy(css = "form#input-example > button")
    protected WebElement enableDisableButton;

    @FindBy(css = "form#input-example > input")
    protected WebElement inputText;

    public DDMDynamicControlsPage(WebDriver driver)  {
        super(driver);
    }

    public void removeCheckBox()  {
        addRemoveButton.click();
        waitForInvisibilityOfElement(dynamicCheckBox);
    }
    public String getMessage()  {
        waitForElementToBeVisibleCSS("#message");
        return message.getText();
    }
    public boolean addCheckBox()  {
        addRemoveButton.click();
        waitForVisibilityOfElement(dynamicCheckBox);
        return dynamicCheckBox.isDisplayed();
    }
    public boolean enableButtonClick()  {
        waitForElementToBeClickableCSS("form#input-example > button");
        enableDisableButton.click();
        waitForElementToBeClickableCSS("form#input-example > input");
        return inputText.isEnabled();
    }
    public boolean disableButtonClick()  {
        waitForElementToBeClickableCSS("form#input-example > button");
        enableDisableButton.click();
        return inputText.isEnabled();
    }
}