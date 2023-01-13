package pageObjects;

import baseClasses.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextPage extends Base {
    WebDriver driver;

    By box = By.xpath(readValue("contextPage.boxXp"));

    public void rightClickBox() {
        Actions ac = new Actions(driver);
        WebElement elem = driver.findElement(box);
        ac.contextClick(elem).perform();
    }

    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    public void clickOKAlert() {
        driver.switchTo().alert().accept();
    }

    public ContextPage(WebDriver driver) {
        this.driver = driver;
    }
}
