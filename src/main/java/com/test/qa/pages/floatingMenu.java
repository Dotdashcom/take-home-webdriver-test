package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class floatingMenu extends TestBase {


    @FindBy(xpath = "//a[@href='#home']")
    WebElement homeMenu;

    @FindBy(xpath = "//a[@href='#news']")
    WebElement newsMenu;

    @FindBy(xpath = "//a[@href='#contact']")
    WebElement contactMenu;


    public floatingMenu() {
        PageFactory.initElements(driver, this);

    }

    public void floatMenu() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1400)", "");
        Assert.assertEquals((homeMenu).isDisplayed(), true);
        Assert.assertEquals((newsMenu).isDisplayed(), true);
        Assert.assertEquals((contactMenu).isDisplayed(), true);
    }
}
