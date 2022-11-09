package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.ConfigurationProp;
import utilities.DriverManager;
import utilities.UtilitiesManager;

import java.time.Duration;

public class NotificationMessagePage {
    private final By header = By.xpath("//h3[text()='Notification Message']");
    private final By clickHere = By.xpath("//*[@id='content']/div/p/a");
    private final By flashMessage = By.xpath("//*[@id='flash']");

    public NotificationMessagePage navigateToPage() {
        DriverManager.getDriver().navigate().to(ConfigurationProp.getProp().getProperty("url") + "/notification_message_rendered");
        return this;
    }

    public boolean VerifyHeader() {
        return UtilitiesManager.FindElement(header).isDisplayed();
    }

    public void notificationMessageTest() {

        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        for (int i = 0; i <= 2; i++) {
            UtilitiesManager.FindElement(clickHere).click();
            String getText = UtilitiesManager.FindElement(flashMessage).getText();
            Assert.assertTrue(getText.contains("Action successful") || getText.contains("Action unsuccesful, please try again"), "No messages is displaying");
        }
    }
}
