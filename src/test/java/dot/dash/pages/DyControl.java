package dot.dash.pages;

import dot.dash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DyControl {

    public DyControl() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Remove']")
    public WebElement removeBtn;


    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkbox;


    @FindBy(xpath = "//input[@type='text']")
    public WebElement textBox;


    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableBtn;


    @FindBy(id = "loading")
    public WebElement loadBar;


    @FindBy(xpath = "//button[.='Add']")
    public WebElement addCheckboxBtn;


    @FindBy(id = "message")
    public WebElement checkboxGoneMessage;


    @FindBy(xpath = "//button[.='Disable']")
    public WebElement disableBtn;


}
