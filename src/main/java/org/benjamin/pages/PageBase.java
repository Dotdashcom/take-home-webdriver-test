package org.benjamin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class PageBase {
    WebDriver driver;

    public void init(String page){
        driver = new ChromeDriver();
        driver.get(page);
    }

    public void destroy() {
        driver.close();
    }
}
