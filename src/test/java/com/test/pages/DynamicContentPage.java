package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.util.Config;

public class DynamicContentPage {

    private WebDriver driver;
    private By content = By.cssSelector("#content > div:nth-of-type(1) > div > div > div > div:nth-of-type(2)");

    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
        driver.get(Config.getUrl("dynamiccontent"));
    }

    public String getContent() {
        return driver.findElement(content).getText();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

}
