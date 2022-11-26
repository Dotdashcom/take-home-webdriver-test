package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HoversPage extends PageObjectBase {
    @FindBy(xpath = "//*[@id='content']/div/div[@class='figure']")
    List<WebElement> figuresList;

    private List<String> userNamesList;

    public HoversPage(WebDriver driver) {
        super(driver);
    }

    public HoversPage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/hovers");
        return this;
    }

    public HoversPage hoverOnAllImages() {
        Actions action = new Actions(driver);
        userNamesList = new ArrayList<String>();
        WebElement userNameInfoElement;
        for (WebElement figure : figuresList) {
            action.moveToElement(figure).perform();
            userNameInfoElement = figure.findElement(By.xpath("descendant::h5"));
            if (userNameInfoElement.isDisplayed()) {
                userNamesList.add(userNameInfoElement.getText());
            }
        }
        return this;
    }

    public List<String> getAllHoveredUsersList() {
        return userNamesList;
    }
}
