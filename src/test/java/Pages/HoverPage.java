package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HoverPage {
    public HoverPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//img[@src='/img/avatar-blank.jpg']")
    public WebElement firstWindow;

    @FindBy(xpath = "//*[.='name: user1']")
    public WebElement message;
}
