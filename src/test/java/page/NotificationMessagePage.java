package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NotificationMessagePage extends PageObject {
    public NotificationMessagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.LINK_TEXT, using = "Click here")
    private WebElement clickHere;

    public void displayNewMessage() {
        clickHere.click();
    }

    public String getFlashMessage() {
        WebElement flash = driver.findElement(By.id("flash"));
        return flash.getText();
    }
}
