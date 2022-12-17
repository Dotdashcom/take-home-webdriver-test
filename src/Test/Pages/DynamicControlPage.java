package Pages;

import Utils.Driver;
import Utils.HelpfulMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlPage {
    public DynamicControlPage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }

    @FindBy(id = "checkbox")
    private WebElement checkBox;

    @FindBy(xpath = "//button[.='Remove']")
    private WebElement removeButton;

    @FindBy(id = "message")
    private WebElement message;

    @FindBy(xpath = "//button[.='Add']")
    private WebElement addButton;

    @FindBy(xpath = "//button[.='Enable']")
    private WebElement enableButton;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement textBox;

    @FindBy(xpath = "//button[.='Disable']")
    private WebElement disableButton;


    public void ClickRemove(){
        checkBox.click();
        HelpfulMethods.clickWithWait(removeButton);
    }
    public void ClickAdd(){
        HelpfulMethods.clickWithWait(addButton);
    }
    public void ClickEnable(){
        HelpfulMethods.clickWithWait(enableButton);
    }
    public void SendTextAndDisable(String text){
        textBox.sendKeys(text);
        disableButton.click();
    }
    public String Message(){
        return message.getText();
    }
}
