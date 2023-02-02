package com.academy.techcenture.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class FloatingMenuPage extends BasePage {
    public FloatingMenuPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy (xpath = "//a[text()='Home']")
    private WebElement homeBtn;

    @FindBy (xpath = "//a[text()='News']")
    private WebElement newsBtn;

    @FindBy (xpath = "//a[text()='Contact']")
    private WebElement contactBtn;

    @FindBy (xpath = "//a[text()='About']")
    private WebElement aboutBtn;

    public void verifyFloatingMenu(){
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
            checkAllTheBtn();
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            checkAllTheBtn();
    }

    private void checkAllTheBtn(){
        softAssert.assertTrue(homeBtn.isEnabled(),"Home button is not enabled");
        softAssert.assertTrue(newsBtn.isEnabled(),"News button is not enabled");
        softAssert.assertTrue(contactBtn.isEnabled(),"Contact button is not enabled");
        softAssert.assertTrue(aboutBtn.isEnabled(),"About button is not enabled");
        softAssert.assertTrue(homeBtn.isDisplayed(),"Home button is not displayed");
        softAssert.assertTrue(newsBtn.isDisplayed(),"News button is not displayed");
        softAssert.assertTrue(contactBtn.isDisplayed(),"Contact button is not displayed");
        softAssert.assertTrue(aboutBtn.isDisplayed(),"About button is not displayed");
    }

}
