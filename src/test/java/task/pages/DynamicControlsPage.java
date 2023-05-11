package task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.utilities.Driver;

public class DynamicControlsPage {

    public DynamicControlsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css = "button[onclick='swapCheckbox()']")
    public WebElement removeButton;


    @FindBy(css = "button[onclick='swapCheckbox()']")
    public WebElement addButton;

    @FindBy(css = "button[onclick='swapInput()']")
    public WebElement enableButton;


    @FindBy(css = "input[type='text']")
    public WebElement inputField;

}
