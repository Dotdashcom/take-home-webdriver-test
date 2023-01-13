package pageObjects;

import baseClasses.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FloatingMenuPage extends Base {
    WebDriver driver;

    By menu = By.xpath(readValue("floatingMenuPage.menuXp"));

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    public boolean isFloatingMenuDisplayed() {
        List<WebElement> menuList = driver.findElements(menu);
        boolean displayed = true;
        //Check if every element in the menu is displayed
        //if at least one element is not displayed, the function will return false
        for (WebElement elem : menuList) {
            if (elem.isDisplayed() && displayed) {
                displayed = elem.isDisplayed();
            }
        }
        return displayed;
    }

    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
    }
}
