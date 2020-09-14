package webdrivertestpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessage {
    WebDriver driver;
    @FindBy(xpath = "//a[contains(text(),'Click here')]")
    WebElement element;
    @FindBy(xpath = "//div[@id='flash']")
    WebElement click;
    String message = "";

    public NotificationMessage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void notificationMessage(){
        element.click();
        message = click.getText();
    }

    public String getMessage(){
        return message;
    }
}
