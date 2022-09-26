package PageObj;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenInNewTabPageObj extends CommonMethods {

    public OpenInNewTabPageObj(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(linkText = "Click Here")
    private WebElement linkText;

    @FindBy(xpath = "//h3")
    private WebElement header;

    public WebElement getLinkText(){
        return linkText;
    }

    public WebElement getHeader() {
        return header;
    }
}
