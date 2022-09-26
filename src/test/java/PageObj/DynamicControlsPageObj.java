package PageObj;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPageObj extends CommonMethods {

    public DynamicControlsPageObj(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "(//button)[1]")
    private WebElement topBtn;

    @FindBy(xpath = "//*[@id='message']")
    private WebElement resText;

    @FindBy(xpath = "//*[@id='checkbox']")
    private WebElement checkBox;

    @FindBy(xpath = "(//button)[2]")
    private WebElement dwBtn;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement textBox;

    public WebElement addRemoveBtn(){
        return topBtn;
    }

    public WebElement respondText(){
        return resText;
    }

    public WebElement getCheckBox(){
        return checkBox;
    }

    public WebElement enableDisableBtn(){
        return dwBtn;
    }

    public WebElement getTextBox(){
        return textBox;
    }
}
