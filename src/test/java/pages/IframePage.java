package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class IframePage {

    public IframePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(tagName = "//h3")
    public WebElement header;

    @FindBy(xpath = "//div[@aria-label='Close']")
    public WebElement closeAlertBtn;

    @FindBy(id = "mce_0_ifr")
    public WebElement frame;

    @FindBy(xpath = "//body[@id='tinymce']/p")
    public WebElement inputText;

}
