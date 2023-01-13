package pageObjects;

import baseClasses.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowsPage extends Base {
    WebDriver driver;

    By hereLink = By.xpath(readValue("windowsPage.clickHereLinkXp"));
    By text = By.xpath(readValue("windowsPage.textXp"));

    public void clickHereLink() {
        driver.findElement(hereLink).click();
    }

    public String isNewTabOpened() {
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1));
            return driver.findElement(text).getText();
        }
        return "Only 1 tab is open";
    }

    public WindowsPage(WebDriver driver) {
        this.driver = driver;
    }
}
