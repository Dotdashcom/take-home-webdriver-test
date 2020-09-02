package com.dotdash;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.dotdash.DotDashWebElements.*;

/**
 * Created by Denys on 9/1/20
 **/
public class DotDashIFrame extends BaseAPI {

    @FindBy(how = How.CSS, using = iFrameCss)
    public WebElement iFrame;

    @FindBy(how = How.CSS, using = iFrameTxtFieldCss)
    public WebElement iFrameTxtField;

    static DotDashIFrame frame;

    public static void initPage() {
        frame = PageFactory.initElements(driver, DotDashIFrame.class);
    }

    public static void switchToTinyMCEIFrame() {
        initPage();
        driver.switchTo().frame(frame.iFrame);
    }

    public static void switchToParent() {
        initPage();
        driver.switchTo().parentFrame();
    }

    public static void enterText() {
        initPage();
        frame.iFrameTxtField.sendKeys("Test 1 2 3 ...");
    }

    public static void navigateToIFramePage() {
        driver.get(baseURL + "iframe");

    }

}
