package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage extends BasicPage {
    WebDriver driver;
    Actions action;

    @FindBy(xpath = "//*[@id=\"hot-spot\"]")
    WebElement contextMenu;

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/context_menu");
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void rightClickContextMenu() {
        this.action.contextClick(this.contextMenu).perform();
    }

    public void assertAlertText(String alertText) {
        try {
            Alert alert = this.driver.switchTo().alert();
            Assert.assertEquals(alert.getText(), alertText);
            alert.dismiss();
            this.wait(1);
            this.action.sendKeys(Keys.ESCAPE).perform();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

