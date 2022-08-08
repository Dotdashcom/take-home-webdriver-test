package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFramePage extends PageObjectBase {

    private String defaultText;
    private WebElement iframeContentArea;

    public IFramePage(WebDriver driver) {
        super(driver);
    }

    public IFramePage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/iframe");
        return this;
    }

    public String getDefaultText() {
        return defaultText;
    }

    public IFramePage switchToIframe() {
        driver.switchTo().frame("mce_0_ifr");
        iframeContentArea = driver.findElement(By.xpath("//body[@id='tinymce']/p"));
        defaultText = iframeContentArea.getText();
        return this;
    }

    public IFramePage removeDefaultText() {
        iframeContentArea.clear();
        return this;
    }

    public IFramePage sendText(String text) {
        iframeContentArea.sendKeys(text);
        return this;
    }

    public String getText() throws InterruptedException {
        Thread.sleep(3000);
        return iframeContentArea.getText();
    }

}
