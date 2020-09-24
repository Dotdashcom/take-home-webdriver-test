package MarionelaTirsina.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMessage extends BasePage {
    @FindBy(linkText = "Click here")
    public WebElement clickHereButton;

    @FindBy(xpath = "//div[@class='flash notice']")
            public WebElement notification;
}
