package com.test.localhost.pages;

import com.test.localhost.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage {

    public FloatingMenuPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Floating Menu")
    WebElement floatingMenuButton;

    @FindBy(linkText = "Elemental Selenium")
    WebElement scrollButton;

    @FindBy(linkText = "Home")
    WebElement homeButton;

    public void clickFloatingMenu(){
        floatingMenuButton.click();
    }
    public void clickScrollButton(WebDriver driver){
        BrowserUtils.scrollWithJs(driver,scrollButton);

    }
    public boolean isDisplayedHome(){
        return homeButton.isDisplayed();
    }
}
