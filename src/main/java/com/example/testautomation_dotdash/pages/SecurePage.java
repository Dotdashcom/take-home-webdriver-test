package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import com.example.testautomation_dotdash.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecurePage extends BasePage {

    public SecurePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "flash")
    private WebElement banner;
    @FindBy(css = ".icon-2x.icon-signout")
    private WebElement logoutBtn;


    public void verifyLogoutBtnIsEnabled(){
        Assert.assertTrue(logoutBtn.isEnabled());
    }

    public void verifyBannerSuccessfullMessage(String message){
        Assert.assertEquals(message, banner.getText());
    }

}
