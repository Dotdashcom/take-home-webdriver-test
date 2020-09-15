package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

public class DynamicControlsPages extends PageBase {

    @FindBy(xpath = "//*[@onclick='swapCheckbox()']")
    protected WebElement removeButton;

    @FindBy(xpath = "//*[@type='checkbox']")
    protected WebElement checkBox;

    @FindBy(xpath = "//*[@id='message']")
    protected WebElement checkBoxMessage;

    @FindBy(xpath = "//*[@type='text']")
    protected WebElement textWindow;

    @FindBy(xpath = "//*[@onclick='swapInput()']")
    protected WebElement enableButton;

    @FindBy(xpath = "//p[@id='message']")
    protected WebElement enableMessage;

    public void checkBoxChecking(){
        Assert.assertEquals(true,checkBox.isDisplayed());
        removeButton.click();
        BrowserUtils.waitForVisibility(checkBoxMessage,10);
        String expectedDisappearsMessage = "It's gone!";
        Assert.assertEquals(expectedDisappearsMessage,checkBoxMessage.getText());
        removeButton.click();
        BrowserUtils.waitForVisibility(checkBox,10);
        Assert.assertEquals(true,checkBox.isDisplayed());
        String expectedAppearsMessage = "It's back!";
        Assert.assertEquals(expectedAppearsMessage,checkBoxMessage.getText());
    }
    public void checkEnabledButton(){
        Assert.assertTrue(!textWindow.isEnabled());
        enableButton.click();
        BrowserUtils.waitForVisibility(enableMessage,5);
        String expMessageEnabl = "It's enabled!";
        Assert.assertEquals(expMessageEnabl,enableMessage.getText());
        enableButton.click();
        BrowserUtils.waitForVisibility(enableMessage,5);
        String expMessageDisabled = "It's disabled!";
        Assert.assertEquals(expMessageDisabled,enableMessage.getText());
    }

}
