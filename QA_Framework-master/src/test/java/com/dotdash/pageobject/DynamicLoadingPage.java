package com.dotdash.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoadingPage extends BasePageObject {
    private final int WAIT_TIME = 10;

    private By start_btn = By.xpath("//*[@id='start']/button");
    private By hello_text = By.xpath("//*[@id='finish']/h4");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        open_page("dynamic_loading/2");
    }

    public DynamicLoadingPage click_on_start_btn() {
        driver.findElement(start_btn).click();
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(hello_text));
        return this;
    }

    public void verify_hello_world_displayed() {
        String expected_displayed_text = "Hello World!";
        String actual_displayed_text = driver.findElement(hello_text).getText();
        Assert.assertEquals(actual_displayed_text, expected_displayed_text, "[ERR] The text is not displayed!");
    }

}
