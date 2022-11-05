package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_12_FloatingMenu_Page {
    public TC_12_FloatingMenu_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText =  "Floating Menu")
    public WebElement floatingMenuLink;

    @FindBy(xpath = "//h3")
    public WebElement floatingMenu;
}
