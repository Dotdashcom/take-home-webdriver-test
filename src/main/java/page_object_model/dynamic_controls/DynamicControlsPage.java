package page_object_model.dynamic_controls;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage extends Base {
    public DynamicControlsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Remove']")
    private WebElement removeButton;

    @FindBy(xpath = "//button[text()='Add']")
    private WebElement addButton;

    @FindBy(xpath = "//button[text()='Enable']")
    private WebElement enableButton;

    @FindBy(xpath = "//button[text()='Disable']")
    private WebElement disableButton;

    @FindBy(id = "checkbox")
    public static WebElement checkbox;
    @FindBy(xpath = "//p[contains(text(), \"It's gone!\")]")
    public static WebElement itGoneMessage;
    @FindBy(xpath = "//p[contains(text(), \"It's disabled!\")]")
    public static WebElement disableMessage;

    @FindBy(xpath = "//p[contains(text(), \"It's enabled!\")]")
    public static WebElement enableMessage;

    public void clickRemoveButton() {
        clickOnElement(removeButton);
    }

    public void clickAddButton() {
        clickOnElement(addButton);
    }

    public void clickEnableButton() {
        clickOnElement(enableButton);
    }

    public void clickDisableButton() {
        clickOnElement(disableButton);
    }

}
