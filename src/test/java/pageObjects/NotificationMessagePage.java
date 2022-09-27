package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;

public class NotificationMessagePage extends BaseClass {

    public NotificationMessagePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='example']/h3")
    public WebElement notificationMessagePageHeader;

    @FindBy(xpath = "//div[@class='example']/p/a")
    public WebElement clickHereLink;

    @FindBy(xpath = "//div[@class='flash notice']")
    public WebElement flashMessage;
}
