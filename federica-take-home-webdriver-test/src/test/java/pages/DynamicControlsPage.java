package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class DynamicControlsPage {
    public DynamicControlsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#checkbox-example>button")
    public WebElement removeButton;

    @FindBy(css = "#checkbox-example>#message")
    public WebElement checkBoxMessage;

    @FindBy(css = "#input-example>button")
    public WebElement enableButton;

    @FindBy(css = "#input-example>input")
    public WebElement textBox;

    @FindBy(css = "#input-example>#message")
    public WebElement textBoxMessage;

}
