package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_07_DynamicContent_Page {
    public TC_07_DynamicContent_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText =  "Dynamic Content")
    public WebElement dynamicContentLink;

    @FindBy(partialLinkText =  "click here")
    public WebElement clickHereText;

    @FindBy(xpath = "(//div[@class='large-10 columns'])[3]")
    public WebElement dynamicContent;





}
