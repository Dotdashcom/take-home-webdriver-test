package com.dotdash.mkb.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HoversPage extends BasePage {

    @FindBy(css = "#content > div > div")
    private List<WebElement> usersList;


    public HoversPage(WebDriver driver) {
        super(driver);

    }

    public String getUserName(int index) {
        WebElement profileName = usersList.get(index).findElement(By.cssSelector("div.figcaption > h5"));

        return profileName.getText();
    }

    public String getProfileLink(int index) {
        WebElement profileLink = usersList.get(index).findElement(By.cssSelector("div.figcaption > a"));

        return profileLink.getAttribute("href");
    }

    public void hoverOnUser(int index) {
        Actions actions = new Actions(driver);
        actions.moveToElement(usersList.get(index)).build().perform();
    }
}
