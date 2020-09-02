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
public class DotDashDropDown extends BaseAPI {

    @FindBy(how = How.CSS, using = dropDownID)
    public WebElement dropDownMenu;

    // Page Factory
    static DotDashDropDown dropDown;

    public static void initPage() {
        dropDown = PageFactory.initElements(driver, DotDashDropDown.class);
    }

    public static void selectFromMenu(String option) {
        initPage();
        selectFromDropdown(dropDown.dropDownMenu, option);
        System.out.println("Option " + option + " is selected");
    }

    public static void navigateToDropDownPage() {
        driver.get(baseURL + "dropdown");
    }
}
