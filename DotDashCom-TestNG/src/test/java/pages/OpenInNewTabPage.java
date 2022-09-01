package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OpenInNewTabPage {
    public OpenInNewTabPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Click Here")
    public WebElement clickHere;

    @FindBy(xpath = "//*[@class='example']//h3")
    public WebElement text;
}
