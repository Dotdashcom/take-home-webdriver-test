package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class NotificationMessagePage extends BasicPage {
    WebDriver driver;
    WebElement notification;
    String[] messages = {"Action successful", "Action unsuccesful, please try again", "Action unsuccesful"};

    @FindBy(xpath = "//*[@id=\"content\"]/div/p/a")
    WebElement notificationLink;

    public NotificationMessagePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/notification_message_rendered");
        PageFactory.initElements(this.driver, this);
    }

    public void clickNotificationLink() {
        this.notificationLink.click();
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        this.notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flash\"]")));
    }

    public void assertNotificationContent() {
        String content = this.notification.getText().split("\n")[0];
        List<String> messageList = Arrays.asList(this.messages);
        Assert.assertTrue(messageList.contains(content));
    }
}
