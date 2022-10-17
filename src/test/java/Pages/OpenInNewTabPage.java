package Pages;

import Assignment.OpenInNewTab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenInNewTabPage {

    public OpenInNewTabPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//h3")
    public WebElement pageHeader;

    @FindBy(xpath = "//a[.='Click Here']")
    public WebElement openNewWindowLink;
}
