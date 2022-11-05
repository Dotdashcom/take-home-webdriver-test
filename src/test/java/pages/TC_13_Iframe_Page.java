package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_13_Iframe_Page {
    public TC_13_Iframe_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText ="Frames")
    public WebElement iframeLink;

    @FindBy(partialLinkText ="iFrame")
    public WebElement iframeText;

    @FindBy(xpath = "(//button[@type='button'])[16]")
    public WebElement closeBtn;

    @FindBy(xpath = "//iframe[@id='mce_0_ifr']")
    public WebElement iframe;

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement textBox;
}
