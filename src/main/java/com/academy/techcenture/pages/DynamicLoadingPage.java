package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class DynamicLoadingPage extends BasePage{
    public DynamicLoadingPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(xpath = "//div[@id='finish']")
    private WebElement helloMessage;

    @FindBy(xpath = "//div[@id='start']//button")
    private WebElement startBtn;

    @FindBy (xpath = "//div[@id='loading']")
    private WebElement loadingBar;

    public void verifyDynamicLoading(){
        btnClick(startBtn);
        verifyWebElementIsGone(loadingBar);
        softAssert.assertEquals(helloMessage.getText().trim(),"Hello World!", "The message is not match");
    }

}
