package com.dotdash;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.dotdash.DotDashWebElements.*;

/**
 * Created by Denys on 9/1/20
 **/
public class DotDashContextMenu extends BaseAPI {


    @FindBy(how = How.CSS, using = fieldMenuID)
    public WebElement fieldMenu;

    // Page Factory
    static DotDashContextMenu context;

    public static void initPage() {
        context = PageFactory.initElements(driver, DotDashContextMenu.class);
    }

    // Open Context Menu
    public static void rightClickMenu() {
        initPage();
        rightClickElement(context.fieldMenu);
    }

    public static void navigateToContextMenuPage() {
        driver.get(baseURL + "context_menu");
    }

}
