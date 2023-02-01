package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class SecurePage extends BasePage {

    public SecurePage(WebDriver driver, SoftAssert softAssert){
        super(driver, softAssert);
    }

    @FindBy (xpath = "//div[@id='flash-messages']")
    private WebElement loginMsg;

    @FindBy (xpath = "//i[contains(text(),'Logout')]")
    private WebElement logoutBtn;

    @FindBy (tagName = "h4")
    private WebElement welcomeMsg;

    public void verifySecurePage(){
        softAssert.assertEquals(driver.getTitle(),"The Internet", "Title of secure page is not match");
        softAssert.assertTrue(loginMsg.getText().contains("You logged into a secure area!"),"Login message is not match");
        softAssert.assertEquals(welcomeMsg.getText(),"Welcome to the Secure Area. When you are done click logout below.",
                "Welcome message is not match");
        softAssert.assertTrue(logoutBtn.isEnabled());
    }

    protected void logout(){
        logoutBtn.click();
    }

}
