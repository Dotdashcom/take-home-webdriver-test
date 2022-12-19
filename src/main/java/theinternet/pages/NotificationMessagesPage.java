package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagesPage extends BasePage{
    public NotificationMessagesPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h3[contains(.,'Notification Message')]")
    public WebElement notificationMessagesPageHeader;
    @FindBy(xpath = "//a[contains(.,'Click here')]")
    public WebElement notificationMessagesGenerator;
    @FindBy(xpath = "//div[@class='flash notice']")
    public WebElement notificationMessagesBanner;

    public Boolean validatePageLanding(){
        notificationMessagesPageHeader.isDisplayed();
        notificationMessagesGenerator.isDisplayed();
        notificationMessagesBanner.isDisplayed();
        return true;
    }

    public void generateNotification() throws InterruptedException {
        notificationMessagesGenerator.click();
        Thread.sleep(2000);
    }

    public String getNotificationMessage(){
        return notificationMessagesBanner.getText();
    }
}
