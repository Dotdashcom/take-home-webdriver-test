package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navigation extends BasePage{
    public Navigation() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@href='/login'][contains(.,'Form Authentication')]")
    public WebElement loginPageLink;
    @FindBy(xpath = "//a[@href='/checkboxes'][contains(.,'Checkboxes')]")
    public WebElement checkboxPageLink;
    @FindBy(xpath = "//a[@href='/context_menu'][contains(.,'Context Menu')]")
    public WebElement contextMenuPageLink;
    public Boolean navigateToLoginPage(){
        loginPageLink.click();
        return true;
    }
    public Boolean navigateToCheckBoxPage(){
        checkboxPageLink.click();
        return true;
    }
    public Boolean navigateToContextMenuPage(){
        contextMenuPageLink.click();
        return true;
    }
}
