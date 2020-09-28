package pageobject;

import base.EndPointPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WaitUtilities;

public class DynamicControlsPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(), 'Remove')]")
    private WebElement removeBtn;
    private By checkbox = By.id("checkbox");

    @FindBy(xpath = "//button[contains(text(), 'Add')]")
    private WebElement addBtn;

    @FindBy(xpath = "//button[contains(text(), 'Enable')]")
    private WebElement enableBtn;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement textbox;

    @FindBy(xpath = "//button[contains(text(), 'Disable')]")
    private WebElement disableBtn;

    public DynamicControlsPage(WebDriver driver) {
        super(driver, EndPointPath.DYNAMIC_CONTROLS);

    }

    public boolean verifyRemoveButton() {
        removeBtn.click();
        return WaitUtilities.explicitWaitByElementToBeDisappear(driver, checkbox);
    }

    public WebElement verifyAddButton() {
        addBtn.click();
        return WaitUtilities.explicitWaitByWebElementvisibilityOfElementLocated(driver, checkbox);
    }

    public WebElement verifyEnableButton() {
        enableBtn.click();
        return WaitUtilities.explicitWaitByElementToBeClickable(driver, textbox);
    }

    public boolean verifyDisableButton() {
        disableBtn.click();
        return WaitUtilities.explicitWaitByElementNotToBeClickable(driver, textbox);
    }


}
