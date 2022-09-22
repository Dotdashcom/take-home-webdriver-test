package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class FloatingMenuPage extends BasePage {

    private final By floatingMenu_xpath = By.xpath("//*[@id='menu']/ul");

    public FloatingMenuPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        getDriver().get(PropertyFileReader.getInstance().getProperty("floating_menu_url"));
    }

    public void testFloatingElement(){

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Assert.assertEquals( isElementPresent(floatingMenu_xpath), true);

    }
}
