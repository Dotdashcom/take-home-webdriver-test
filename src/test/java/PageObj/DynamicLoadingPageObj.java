package PageObj;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPageObj extends CommonMethods {

    public DynamicLoadingPageObj(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//button")
    private WebElement btn;

    @FindBy(xpath = "//*[@id='finish']/h4")
    private WebElement text;

    public WebElement startBtn(){
        return btn;
    }

    public WebElement dispText(){
        return text;
    }
}
