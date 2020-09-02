package com.dotdash;

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
public class DotDashDynamicLoading extends BaseAPI {

    @FindBy(how = How.XPATH, using = startButtonXp)
    public WebElement startButton;
    @FindBy(how = How.CSS, using = helloWorldMessageCss)
    public WebElement helloWorldMessage;

    // Page Factory
    static DotDashDynamicLoading loading;

    public static void initPage() {
        loading = PageFactory.initElements(driver, DotDashDynamicLoading.class);
    }

    public static void clickStartButton() {
        initPage();
        click(loading.startButton);
    }

    public static void assertPageLoadedSuccessfully() {
        initPage();
        Assert.assertTrue(loading.helloWorldMessage.isDisplayed());
        System.out.println("Dynamic Page loaded successfully, message displayed: " + loading.helloWorldMessage.getText());
    }

    public static void waitHelloWorldToBeDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loading.helloWorldMessage));
    }

    public static void navigateToDynamicLoading() {
        driver.get(baseURL + "dynamic_loading/2 ");
    }
}
