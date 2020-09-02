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
public class DotDashDynamicContent extends BaseAPI {

    @FindBy(how = How.CSS, using = contentID)
    public WebElement content;

    // Page Factory
    static DotDashDynamicContent contentPage;

    public static void initPage() {

        contentPage = PageFactory.initElements(driver, DotDashDynamicContent.class);
    }

    public static String getCurrentContent() {
        initPage();
        implicitWait(3000);
        String content = contentPage.content.getText();
        return content;
    }

    public static void assertContentRefresh() {
        implicitWait(3000);
        String originalContent = getCurrentContent();
        refreshThePage();
        String newContent = getCurrentContent();
        Assert.assertNotEquals(originalContent, newContent);
        System.out.println("> Original: " + originalContent);
        System.out.println("> After refresh: " + newContent);
    }

    public static void navigateToDynamicContentPage() {
        driver.get(baseURL + "dynamic_content");
    }

}
