package PageObj;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JavaScriptAlertsPageObj extends CommonMethods {

    public JavaScriptAlertsPageObj(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//ul/child::li/button")
    private List<WebElement> btn;

    @FindBy(xpath = "//p[@id='result']")
    private WebElement result;

    public List<WebElement> button(){
        return btn;
    }

    public WebElement getResult(){
        return result;
    }


}
