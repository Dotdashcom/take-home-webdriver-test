package com.dotdash.pages;

import com.dotdash.utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage {

    @FindBy(xpath = "//a[text()='click here']")
    public WebElement clickHere;

    @FindBy(xpath = "//button[text()='Start']")
    public WebElement startButton;

    @FindBy(xpath = "//*[@id='loading']")
    public WebElement loading;

    @FindBy(xpath = "//div/*[text()='Hello World!']")
    public WebElement helloWorld;

    public DynamicContentPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }

    public WebElement locator(int i){
        return BrowserFactory.getDriver().findElement(By.xpath("//div[@id='content']//div[@class='row']["+i+"]//div[@class='large-10 columns']"));
    }
}
