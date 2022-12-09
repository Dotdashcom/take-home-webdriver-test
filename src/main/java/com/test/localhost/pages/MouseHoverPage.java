package com.test.localhost.pages;

import com.test.localhost.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MouseHoverPage {

    public MouseHoverPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Hovers")
    WebElement hoverButton;

    @FindBy(tagName = "h5")
    List<WebElement> text;

    @FindBy(xpath = "//div[@class='figure']//img")
    List<WebElement> allUsers;


    public void clickHoverButton() {
        hoverButton.click();
    }

    public void hoverOverElements(WebDriver driver) throws InterruptedException {
        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = Arrays.asList("name: user1", "name: user2", "name: user3");
        Actions actions = new Actions(driver);
        for (int i = 0; i < allUsers.size(); i++) {
            Thread.sleep(3000);
            actions.moveToElement(allUsers.get(i)).perform();
            actualNames.add(BrowserUtils.getText(text.get(i)));
            System.out.println(BrowserUtils.getText(text.get(i)));
        }
        Assert.assertEquals(actualNames, expectedNames);
    }
}

