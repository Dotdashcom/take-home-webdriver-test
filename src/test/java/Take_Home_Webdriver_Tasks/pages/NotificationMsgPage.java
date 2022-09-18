package Take_Home_Webdriver_Tasks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMsgPage extends BasePage{
    @FindBy(xpath = "//div[@id=\"content\"]/div/p/a")
    public WebElement clickHereLink;

    @FindBy (id = "flash")
    public WebElement actionMsg;
}
