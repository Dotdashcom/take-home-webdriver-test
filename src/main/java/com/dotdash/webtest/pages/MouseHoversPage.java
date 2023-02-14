package com.dotdash.webtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MouseHoversPage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(25) > a")
    protected WebElement hoverButton;

    @FindBy(tagName = "h5")
    protected List<WebElement> userNamesText;

    @FindBy(css = "div.example > div.figure")
    protected List<WebElement> allUsers;

    public MouseHoversPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToMouseHoversPage() {
        hoverButton.click();
    }

    public boolean allUsersPresent() {
        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = Arrays.asList("name: user1", "name: user2", "name: user3");
        Actions actions = new Actions(driver);
        for (int i = 0; i < allUsers.size(); i++) {
            actions.moveToElement(allUsers.get(i)).perform();
            actualNames.add(userNamesText.get(i).getText());
            System.out.println(userNamesText.get(i).getText());
        }
        return actualNames.equals(expectedNames);
    }
}
