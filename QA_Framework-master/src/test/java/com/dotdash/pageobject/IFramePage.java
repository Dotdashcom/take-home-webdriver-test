package com.dotdash.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class IFramePage extends BasePageObject {

    private By iframe = By.id("mce_0_ifr");
    private By iframe_body = By.id("tinymce");
    private String text_input_in_iframe = "";

    public IFramePage(WebDriver driver) {
        this.driver = driver;
        open_page("iframe");
    }

    public IFramePage input_text_in_Iframe(String text) {
        text_input_in_iframe = text;
        driver.switchTo().frame(driver.findElement(iframe));
        WebElement iframe_body_elem = driver.findElement(iframe_body);
        iframe_body_elem.clear();
        iframe_body_elem.sendKeys(text);
        driver.switchTo().defaultContent();
        return this;
    }

    public void verify_input_text() {
        driver.switchTo().frame(driver.findElement(iframe));
        String actual_text_in_iframe = driver.findElement(iframe_body).getText();
        driver.switchTo().defaultContent();
        Assert.assertEquals(text_input_in_iframe, actual_text_in_iframe, "[ERR] Wrong text after input!");
    }
}
