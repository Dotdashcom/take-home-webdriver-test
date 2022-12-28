package com.test.localhost.pages;

import com.test.localhost.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Set;

public class NewTabPage {

    public  NewTabPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Multiple Windows")
    WebElement multipleWindowsButton;

    @FindBy(xpath = "//a[.='Click Here']")
    WebElement clickHere;

    @FindBy(tagName = "h3")
    WebElement header;

    public void clickButtons(){
        multipleWindowsButton.click();
        clickHere.click();
    }
    public String validateNewHeader(WebDriver driver){
        return BrowserUtils.switchByTitle(driver,"New Window");







    }
}
