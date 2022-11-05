package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_04_ContextMenu_Page {
    public TC_04_ContextMenu_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(partialLinkText =  "Context Menu")
    public WebElement contextMenuLink;

    @FindBy(xpath = "//div[@id='hot-spot']")
    public WebElement insideBox;

    @FindBy(xpath = "(//script)[7]")
    public WebElement alertMessage;
}
