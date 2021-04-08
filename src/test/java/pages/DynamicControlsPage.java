package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class DynamicControlsPage {
    public DynamicControlsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Remove']")
    public WebElement removeBtn;

    @FindBy(id = "message")
    public WebElement message1;

    @FindBy(id = "checkbox")
    public WebElement checkBox;

    @FindBy(xpath = "//*[text()='Add']")
    public WebElement addBtn;

    @FindBy(xpath = "//*[text()='Enable']")
    public WebElement enableBtn;

    @FindBy(id = "message")
    public WebElement message2;

    @FindBy(xpath = "//*[text()='Disable']")
    public WebElement disableBtn;

}
