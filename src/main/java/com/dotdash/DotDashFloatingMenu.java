package com.dotdash;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.dotdash.DotDashWebElements.*;

/**
 * Created by Denys on 9/1/20
 **/
public class DotDashFloatingMenu extends BaseAPI {

    @FindBy(how = How.LINK_TEXT, using = newsLT)
    public WebElement news;
    @FindBy(how = How.LINK_TEXT, using = contactLT)
    public WebElement contact;
    @FindBy(how = How.LINK_TEXT, using = aboutLT)
    public WebElement about;
    @FindBy(how = How.LINK_TEXT, using = homeLT)
    public WebElement home;


    static DotDashFloatingMenu floatingMenu;

    public static void initPage() {
        floatingMenu = PageFactory.initElements(driver, DotDashFloatingMenu.class);
    }

    public static void scrollDownPage() {
        scrollDownPx("400");
    }


    public static void clickNewsMenuButton() {
        initPage();
        click(floatingMenu.news);
    }

    public static void clickContactMenuButton() {
        initPage();
        click(floatingMenu.contact);
    }

    public static void clickAboutMenuButton() {
        initPage();
        click(floatingMenu.about);
    }

    public static void clickHomeMenuButton() {
        initPage();
        click(floatingMenu.home);
    }

    public static void assertNewsMenuButton() {
        assertURLContains("news");
    }

    public static void assertContactMenuButton() {
        assertURLContains("contact");
    }

    public static void assertHomeMenuButton() {
        assertURLContains("home");
    }

    public static void assertAboutMenuButton() {
        assertURLContains("about");
    }

    public static void navigateToFloatingMenuPage() {
        driver.get(baseURL + "floating_menu");
    }


}
