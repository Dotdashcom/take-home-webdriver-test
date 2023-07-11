package com.takehome.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecureAreaPage extends AbstractPageObject{

    @FindBy(css = ".flash.success")
    private WebElement flashMessagesBanner;

    @Step
    public boolean isLoginSuccessBannerDisplayed(){
        return isElementDisplayed(flashMessagesBanner);
    }
}
