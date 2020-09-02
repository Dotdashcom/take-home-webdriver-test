package com.dotdash;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.dotdash.DotDashWebElements.*;

/**
 * Created by Denys on 9/1/20
 **/
public class DotDashMouseHover extends BaseAPI {

    @FindBy(how = How.XPATH, using = user1TextXp)
    public WebElement user1Text;
    @FindBy(how = How.XPATH, using = user2TextXp)
    public WebElement user2Text;
    @FindBy(how = How.XPATH, using = user3TextXp)
    public WebElement user3Text;
    @FindBy(how = How.XPATH, using = user1Xp)
    public WebElement user1;
    @FindBy(how = How.XPATH, using = user2Xp)
    public WebElement user2;
    @FindBy(how = How.XPATH, using = user3Xp)
    public WebElement user3;

    static DotDashMouseHover hover;

    public static void initPage() {
        hover = PageFactory.initElements(driver, DotDashMouseHover.class);
    }

    public static void hoverOverUser1() {
        initPage();
        hoverOverElement(hover.user1);
    }

    public static void hoverOverUser2() {
        initPage();
        hoverOverElement(hover.user2);
    }

    public static void hoverOverUser3() {
        initPage();
        hoverOverElement(hover.user3);
    }

    public static void navigateToMouseHoverPage() {
        driver.get(baseURL + "hovers");
    }

    public static void assertUser1InfoDisplayed() {
        initPage();
        Assert.assertTrue(hover.user1Text.isDisplayed());
        System.out.println("User 1 Displayed");
    }

    public static void assertUser2InfoDisplayed() {
        initPage();
        Assert.assertTrue(hover.user2Text.isDisplayed());
        System.out.println("User 2 Displayed");
    }

    public static void assertUser3InfoDisplayed() {
        initPage();
        Assert.assertTrue(hover.user3Text.isDisplayed());
        System.out.println("User 3 Displayed");
    }

}
