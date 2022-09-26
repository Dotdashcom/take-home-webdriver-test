package PageObj;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePageObj extends CommonMethods {

    public IframePageObj(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "(//button[@type='button'])[16]")
    private WebElement close;

    @FindBy(xpath = "//*[@id='tinymce']")
    private WebElement textField;

    @FindBy(id = "mce_0_ifr")
    private WebElement frame;

    public WebElement getFrame(){
        return frame;
    }
    public WebElement closeBtn(){
        return close;
    }

    public WebElement getTextField(){
        return textField;
    }
}
