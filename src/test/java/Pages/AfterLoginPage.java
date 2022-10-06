package Pages;
import Util.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AfterLoginPage {
    @FindBy (tagName = "h4")
    public WebElement welcomeSign;
    @FindBy (id = "flash")
    public WebElement errorFlash;
    public AfterLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
