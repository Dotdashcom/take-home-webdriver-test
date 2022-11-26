package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class WindowsPage extends PageObjectBase {

    @FindBy(xpath = "//a[contains(text(),'Click Here')]")
    WebElement newWindowLink;

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    public String getNewWindowMessage() {
        String message = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
        return message;
    }
	
	public WindowsPage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/windows");
        return this;
    }

    public WindowsPage switchToNewTab() {
        String oldTab = driver.getWindowHandle();
        newWindowLink.click();
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        tabs.remove(oldTab);
        driver.switchTo().window(tabs.get(0).toString());
        return this;
    }

}

