package Main;

import Utilities.DriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlPage {

    @FindBy(xpath = "//button[.='Remove']")
    public WebElement removeButton;

    @FindBy(xpath = "(//input)[1]")
    public WebElement checkBoxButton;

    @FindBy(xpath="//button[.='Add']")
    public WebElement addButton;

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableButton;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement enableText;

    @FindBy(xpath = "//button[.='Disable']")
    public WebElement disableButton;

    public DynamicControlPage(){
        PageFactory.initElements(DriverHelper.getDriver(),this);
    }




}
