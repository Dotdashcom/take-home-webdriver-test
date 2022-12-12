package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MouseHoverPage extends BasePage {

    @FindBy(xpath = "//a[@href='/hovers']")
    WebElement link;

    @FindBy(xpath = "(//img[@alt='User Avatar'])[1]")
    WebElement user1;

    @FindBy(xpath = "(//div[@class='figcaption']/h5)[1]")
    WebElement text;

    @FindBy(xpath = "(//img[@alt='User Avatar'])[2]")
    WebElement user2;

    @FindBy(xpath = "(//div[@class='figcaption']/h5)[2]")
    WebElement text2;

    @FindBy(xpath = "(//img[@alt='User Avatar'])[3]")
    WebElement user3;

    @FindBy(xpath = "(//div[@class='figcaption']/h5)[3]")
    WebElement text3;

    public void clickOnLink() {
        link.click();
    }

    public void hoverMouse() {
        Actions actions = new Actions(driver);
        actions.moveToElement(user1).perform();
        Assert.assertTrue(text.isDisplayed());

        actions.moveToElement(user2).perform();
        Assert.assertTrue(text2.isDisplayed());

        actions.moveToElement(user3).perform();
        Assert.assertTrue(text3.isDisplayed());

    }
}
