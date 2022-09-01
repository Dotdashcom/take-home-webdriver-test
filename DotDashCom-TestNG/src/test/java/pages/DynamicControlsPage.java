package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DynamicControlsPage {
    public DynamicControlsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()='Remove']")
    public WebElement removeButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBox;

    @FindBy(id = "message")
    public WebElement goneMessage;

    @FindBy(xpath = "//p[contains(text(),'This')]")
    public WebElement checkboxGone;

    @FindBy(xpath ="//*[@id='checkbox-example']/button")
    public WebElement addButton;

    @FindBy(id = "message")
    public WebElement backMessage;

    @FindBy(xpath ="(//button)[2]")
    public WebElement enableDisableButton;

    @FindBy(id = "message")
    public WebElement enableMessage;

    @FindBy(id = "message")
    public WebElement disableMessage;
}
