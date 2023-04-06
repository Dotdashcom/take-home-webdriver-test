package com.homewebdriver.webpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class NotificationMessagePage {
    WebDriver driver;

    private static String NOTIFICATION_URL="http://localhost:7080/notification_message_rendered";

    @FindBy(xpath = "//a[contains(text(),'Click here')]")
    public WebElement clickHereLink;

    @FindBy(xpath = "//div[@id='flash']")
    public WebElement flashMessage;

    public NotificationMessagePage(WebDriver driver){
        this.driver=driver;
        driver.get(NOTIFICATION_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public String getNotification(){
        clickHereLink.click();
        return flashMessage.getText();
    }
}
