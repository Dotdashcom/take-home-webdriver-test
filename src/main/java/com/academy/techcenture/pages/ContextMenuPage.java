package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;


public class ContextMenuPage extends BasePage {

    public ContextMenuPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy (xpath = "//div[@id='hot-spot']")
    private WebElement contextBox;

    public void verifyAlert(){
        Actions actions = new Actions(driver);
        actions.contextClick(contextBox).perform();
        softAssert.assertTrue(driver.switchTo().alert().getText().trim().contains("You selected a context menu"), "Message iof context menu us not match");
    }

}
