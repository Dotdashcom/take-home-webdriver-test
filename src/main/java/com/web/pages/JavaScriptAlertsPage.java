package com.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.base.TestBase;

public class JavaScriptAlertsPage extends TestBase {

    @FindBy(xpath="//*[@id='content']/div/ul/li[1]/button")
    WebElement jsAlertBtn;

    @FindBy(xpath="//*[@id='content']/div/ul/li[2]/button")
    WebElement jsConfirmBtn;

    @FindBy(xpath="//*[@id='content']/div/ul/li[3]/button")
    WebElement jsPromptBtn;

    @FindBy(id="result")
    WebElement jsPromptText;


    public JavaScriptAlertsPage(){

        PageFactory.initElements(driver, this);
    }

    public void jsAlertButtonClick(){
        jsAlertBtn.click();
    }
    public void jsConfirmButtonClick(){
        jsConfirmBtn.click();
    }
    public void jsPromptButtonClick(){
        jsPromptBtn.click();
    }

    public String getJsPromptText(){
        return jsPromptText.getText();
    }

}
