package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class DynamicControlsPage extends TestBase {
    WebDriver driver = TestBase.getInstance().getDriver();
    @FindBy(id = "checkbox")
    WebElement checkBox;
    @FindBy(xpath = "//*[@id='checkbox-example']/button")
    WebElement addRemoveButton;
    @FindBy(xpath = "//input[@type='text']")
    WebElement inputField;
    @FindBy(xpath = "//*[@id='input-example']/button")
    WebElement enableDisableButton;
    @FindBy(xpath = "//p[@id='message']")
    WebElement disabledText;

    public DynamicControlsPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnRemoveBtn() {
        addRemoveButton.click();
        utils.invisibleElementWait(checkBox);
    }

    public void clickOnAddBtn() {
        addRemoveButton.click();
        utils.visibleElementWait(checkBox);
    }

    public void clickOnEnableBtn() {
        enableDisableButton.click();
        utils.enableElementWait(inputField);
    }

    public void clickOnDisableBtn() {
        enableDisableButton.click();
        utils.visibleElementWait(disabledText);

    }

    public WebElement checkBoxVisibility() {
        return checkBox;
    }

    public WebElement inputField() {
        return inputField;
    }


}
