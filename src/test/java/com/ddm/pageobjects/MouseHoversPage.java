package com.ddm.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class MouseHoversPage extends WebPage {

    @FindBy(css = "div.example > div.figure")
    protected List<WebElement> userProfiles;

    public MouseHoversPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    public void hoverOnProfile(int index) {
        if(index >= 0 && index < 3) {
            mouseAndKeyBoardActions.moveToElement(userProfiles.get(index)).build().perform();
            //browserPause(1);
            waitUntilLoadedByCss("div.figcaption > h5");
        }
    }

    public String getProfileName(int index) {
        WebElement elm;
        if(index>= 0 && index < 3) {
            elm = userProfiles.get(index).findElement(By.cssSelector("div.figcaption > h5"));
            return elm.getText();
        }
        return null;
    }

    public String getProfileLink(int index) {
        WebElement elm;
        if(index>= 0 && index < 3) {
            elm = userProfiles.get(index).findElement(By.cssSelector("div.figcaption > a"));
            return elm.getAttribute("href");
        }
        return null;
    }
}