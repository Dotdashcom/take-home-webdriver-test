package pages;

import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ContextMenu {
    public ContextMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id=\"hot-spot\"]")
    WebElement box;

    public void rightClick(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(box).contextClick().build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

    }

    public String getAlertMessage(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void alertClick(WebDriver driver) {

        Alert alert = driver.switchTo().alert();
        alert.getText();
        alert.accept();
    }
}
