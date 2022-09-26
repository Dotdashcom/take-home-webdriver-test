package PageObj;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContentPageObj extends CommonMethods {

    public ContentPageObj(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='row']/child::div[@class='large-10 columns'])[1]")
    private WebElement contentText;

    public WebElement getContentText(){
        return contentText;
    }
}
