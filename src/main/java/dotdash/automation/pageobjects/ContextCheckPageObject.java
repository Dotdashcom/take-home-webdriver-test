package dotdash.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextCheckPageObject {
    private WebDriver driver;
    private By context = By.id("hot-spot");
    private Actions action;

    public ContextCheckPageObject(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
    }

    public ContextCheckPageObject rightClickContext() {
        action.contextClick(driver.findElement(this.context)).perform();
        return this;
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

}
