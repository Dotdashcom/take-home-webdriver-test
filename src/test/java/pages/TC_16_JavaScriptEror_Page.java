package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_16_JavaScriptEror_Page {
    public TC_16_JavaScriptEror_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText =  "JavaScript onload event error")
    public WebElement JavaScriptErorLink;
    @FindBy(xpath = "//p")
    public WebElement text;
}
