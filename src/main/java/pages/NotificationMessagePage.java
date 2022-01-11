package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NotificationMessagePage {
    WebDriver driver;
    String messageUrl = "http://localhost:7080/notification_message_rendered";
    String clickHereXPath = "//a[@href='/notification_message']";
    String messageXpath = "//div[@id='flash']";


    public NotificationMessagePage(WebDriver webDriver) {
        this.driver = webDriver;
        this.driver.get(messageUrl);
    }

    public void clickText() {
        WebElement textElement = driver.findElement(By.xpath(clickHereXPath));
        textElement.click();
    }

    public String getMessage() {
        WebElement messageElement = driver.findElement(By.xpath(messageXpath));
        return messageElement.getText();
    }
}

