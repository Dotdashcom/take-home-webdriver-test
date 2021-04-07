package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DynamicControlsPge {
    public DynamicControlsPge() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#checkbox-example>button")
    public WebElement removebutton;

    @FindBy(css = "#checkbox-example>#message")
    public WebElement checkBoxMessage;

    @FindBy(id = "checkbox")
    public WebElement checkbnox;

    @FindBy(xpath ="//button[contains(text(),'Add')]")
    public WebElement addbutton;

    @FindBy(css = "#input-example>button")
    public WebElement enableButton;

    @FindBy(css ="#input-example>input")
    public WebElement textbox;

    @FindBy(css ="#input-example>#message")
    public WebElement textMessage;

}


