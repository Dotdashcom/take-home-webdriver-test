package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class OpenNewTabPage extends BasePage {

    // PAGE INITIALIZATION:
    public OpenNewTabPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By CLICK_HERE = By.xpath("//a[contains(text(),'Click Here')]");

    // WEB ELEMENTS:
    private WebElement getClickHere() {
        wait.until(ExpectedConditions.elementToBeClickable(CLICK_HERE));
        return driver.findElement(CLICK_HERE);
    }

    // METHODS:
    public void clickOnTheLink() {
        log.info("User clicks on the 'Click Here' link for opening new window. ");
        getClickHere().click();
    }

    public boolean openNewTab(String pageTitle) {
        String parent = driver.getWindowHandle();
        System.out.println("Parent windows id is " + parent);
        Set<String> allWindows = driver.getWindowHandles();

        int count = allWindows.size();
        System.out.println("Total windows is " + count);

        for (String child : allWindows) {
            if (!parent.equalsIgnoreCase(child)) {
                driver.switchTo().window(child);
                String childTabTile = driver.getTitle();
                System.out.println("Child window title is ===> " + childTabTile + " <=== ");
                return childTabTile.equalsIgnoreCase(pageTitle);
            }
        }
        return false;
    }
}


