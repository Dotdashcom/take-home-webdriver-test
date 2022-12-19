package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage extends BasePage{
    public IframePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h3[contains(.,'An iFrame containing the TinyMCE WYSIWYG Editor')]")
    public WebElement iframePageHeader;

    @FindBy(xpath = "//iframe[@id='mce_0_ifr']")
    public WebElement iframe;
    @FindBy(tagName = "p")
    public WebElement iframeTextBox;

    public Boolean validatePageLanding(){
        iframePageHeader.isDisplayed();
        iframe.isDisplayed();
        return true;
    }

    public void typeIntoIframe(String text){
        driver.switchTo().frame(iframe);
        iframeTextBox.sendKeys(text);
    }

    public String getTextFromIframe(){
        return iframeTextBox.getText();
    }
}
