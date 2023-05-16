package homework.pages;

import homework.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {

    public DynamicControlsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//button[@onclick='swapCheckbox()']")
    public WebElement removeButton;

    @FindBy(xpath = "(//button[@autocomplete='off'])[1]")
    public WebElement addButton;

    @FindBy(css = "button[onclick='swapInput()']")
    public WebElement enableButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBoxAfterAddbutton;

    @FindBy(xpath = "//p[.=\"It's enabled!\"]")
    public WebElement enabledMessage;


    @FindBy(xpath = "//button[.=\"Disable\"]")
    public WebElement disableButton;


    @FindBy(xpath = "//p[.=\"It's disabled!\"]")
    public WebElement disableMessage;






}
