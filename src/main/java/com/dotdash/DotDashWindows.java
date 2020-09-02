package com.dotdash;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static com.dotdash.DotDashWebElements.clickHereLT;

/**
 * Created by Denys on 9/1/20
 **/
public class DotDashWindows extends BaseAPI {

    @FindBy(how = How.LINK_TEXT, using = clickHereLT)
    public WebElement clickHere;

    static DotDashWindows tab;

    public static void initPage() {
        tab = PageFactory.initElements(driver, DotDashWindows.class);
    }

    public static void openNewTab() {
        initPage();
        click(tab.clickHere);
        //get window handles as list
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(browserTabs.get(1));
    }

    public static void assertNewTabIsOpen() {
        assertURLContains("new");
    }

    public static void navigateToNewWindowTestPage() {
        driver.get(baseURL + "windows");
    }

}
