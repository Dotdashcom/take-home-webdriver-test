package com.dotdash.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicContentPage extends BasePage {
    @FindBy(css="div[id=\"content\"] div[class=\"row\"]:first-child img")
    WebElement firstRowAvatar;

    @FindBy(css="div[id=\"content\"] div[class=\"row\"]:first-child div[class*=large-10]")
    WebElement firstRowText;

    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstRowAvatar(){
        return firstRowAvatar.getAttribute("src");
    }

    public String getFirstRowText(){
        return firstRowText.getText();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }


}
