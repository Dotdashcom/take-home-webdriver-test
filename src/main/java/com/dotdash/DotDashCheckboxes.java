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
public class DotDashCheckboxes extends BaseAPI {

    @FindBy(how = How.XPATH, using = checkBox1Xp)
    public WebElement checkBox1;
    @FindBy(how = How.XPATH, using = checkBox2Xp)
    public WebElement checkBox2;

    // Page Factory
    static DotDashCheckboxes checkbox;

    public static void initPage() {
        checkbox = PageFactory.initElements(driver, DotDashCheckboxes.class);
    }

    // Check Checkbox 1
    public static void clickCheckBox1() {
        initPage();
        implicitWait(3000);
        click(checkbox.checkBox1);
    }

    // Check Checkbox 2
    public static void clickCheckBox2() {
        initPage();
        implicitWait(3000);
        click(checkbox.checkBox2);
    }

    public static void navigateToCheckboxesPage() {
        driver.get(baseURL + "checkboxes");

    }

}
