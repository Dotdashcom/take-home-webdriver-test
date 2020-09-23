package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DynamicControlsPage extends BasePage {

    @FindBy (xpath = "//button[.='Remove']")
    public WebElement removeButton;

    @FindBy (xpath = "//input[@type='checkbox']")
    public WebElement checkbox;

    @FindBy (tagName = "input")
    List<WebElement> checkingInputs;

    @FindBy (xpath = "//button[.='Add']")
    public WebElement addButton;

    @FindBy (xpath = "//button[.='Enable']")
    public WebElement enableButton;

    @FindBy (xpath = "//button[.='Disable']")
    public WebElement disableButton;


    @FindBy (xpath = "//p[contains(text(),\"It's gone!\")]")
    public WebElement itsGoneMess;

    @FindBy (xpath = "//p[contains(text(),\"It's enabled!\")]")
    public WebElement itsEnabledMess;

    @FindBy (xpath = "//p[contains(text(),\"It's back!\")]")
    public WebElement itsBackMess;

    @FindBy (xpath = "//p[contains(text(),\"It's disabled!\")]")
    public WebElement itsDisabledMess;
}
