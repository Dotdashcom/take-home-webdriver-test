package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;

public class IFramePage extends BaseClass {

    public IFramePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='example']/h3")
    public WebElement iFramePageHeader;

    @FindBy(id = "tinymce")
    public WebElement iFrameContentBody;
}
