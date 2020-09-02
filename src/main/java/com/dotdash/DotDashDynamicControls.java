package com.dotdash;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.dotdash.DotDashWebElements.*;

/**
 * Created by Denys on 9/1/20
 **/
public class DotDashDynamicControls extends BaseAPI {

    @FindBy(how = How.XPATH, using = enableButtonXp)
    public WebElement enableButton;
    @FindBy(how = How.XPATH, using = removeButtonXp)
    public WebElement removeButton;
    @FindBy(how = How.XPATH, using = textBoxXp)
    public WebElement textBox;
    @FindBy(how = How.XPATH, using = addButtonXp)
    public WebElement addButton;

    // Page Factory
    static DotDashDynamicControls controls;

    public static void initPage() {
        controls = PageFactory.initElements(driver, DotDashDynamicControls.class);
    }

    public static void clickRemove() {
        initPage();
        click(controls.removeButton);
    }

    public static void clickEnable() {
        initPage();
        click(controls.enableButton);
    }

    public static void assertRemoveControl() {
        initPage();
        clickRemove();
        assertDynamicControlVisibility(controls.addButton);
    }

    public static void assertTextBoxEnabled() {
        initPage();
        clickEnable();
        assertDynamicControlClickable(controls.textBox);
    }

    public static void assertDynamicControlVisibility(WebElement elementToBeVisible) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(elementToBeVisible));
        Assert.assertTrue(elementToBeVisible.isDisplayed());
    }

    public static void assertDynamicControlClickable(WebElement elementToBeClickable) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(elementToBeClickable));
        Assert.assertTrue(elementToBeClickable.isEnabled());
    }

    public static void navigateToDynamicControls() {
        driver.get(baseURL + "dynamic_controls");
    }

}
