package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;

public class DynamicControlsPage extends BaseClass {

    public DynamicControlsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h4[text()='Dynamic Controls']")
    public WebElement dynamicControlsPageHeader;

    @FindBy(id = "checkbox")
    public WebElement checkbox;

    @FindBy(xpath = "//form[@id='checkbox-example']/button[text()='Add']")
    public WebElement addButton;

    @FindBy(xpath = "//form[@id='checkbox-example']/button[text()='Remove']")
    public WebElement removeButton;

    @FindBy(xpath = "//form[@id='input-example']/button[text()='Enable']")
    public WebElement enableButton;

    @FindBy(xpath = "//form[@id='input-example']/button[text()='Disable']")
    public WebElement disableButton;

    @FindBy(xpath = "//form[@id='input-example']/input[@type='text']")
    public WebElement inputTextBox;
}
