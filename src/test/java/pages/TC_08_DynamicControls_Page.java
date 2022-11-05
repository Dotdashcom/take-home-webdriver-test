package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_08_DynamicControls_Page {
    public TC_08_DynamicControls_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText =  "Dynamic Controls")
    public WebElement dynamicControlLink;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement removeAddButton;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement enableDisableButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBox;

    @FindBy(xpath = "//p[@id='message']")
    public WebElement itIsEnabledDisabledMessage;
}
