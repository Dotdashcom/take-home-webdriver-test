package com.Pages;

import com.BaseTest.TestEngine;
import com.CommonMethods.SeleniumCommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsRepository extends TestEngine {

    public JavaScriptAlertsRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using =  "//button[@onclick='jsAlert()']")
    public WebElement _javaScriptAlertbtn;

    @FindBy(how = How.XPATH, using = "//button[@onclick='jsConfirm()']")
    public WebElement _javaScriptConfirmbtn;

    @FindBy(how = How.XPATH, using = "//button[@onclick='jsPrompt()']")
    public WebElement _javaScriptPromptbtn;

    @FindBy(how = How.XPATH, using = "//p[@id='result']")
    public WebElement _resultText;

    public void ClickJSAlertBtn_And_AcceptAlert(){
        _javaScriptAlertbtn.click();
        SeleniumCommonMethods.JSAlertAccept();
    }
    public void ClickJSConfirmBtn_And_ClickOK(){
        _javaScriptConfirmbtn.click();
        SeleniumCommonMethods.JSAlertAccept();
    }

    public void ClickJSConfirmBtn_And_ClickCancel(){
        _javaScriptConfirmbtn.click();
        SeleniumCommonMethods.JSAlertCancel();
    }

    public void ClickJSPromptBtn_And_Type_And_ClickOK(String Text){
        _javaScriptPromptbtn.click();
        SeleniumCommonMethods.TypeJSAlertText(Text);
    }

    public void ClickJSPromptBtn_And_ClickCancel(){
        _javaScriptPromptbtn.click();
        SeleniumCommonMethods.JSAlertCancel();
    }

    public String ResultText(){
        return _resultText.getText().trim();
    }

    public boolean VerifyJSAlertIsClickedSuccessfully_Msg(){
        return ResultText().trim().equalsIgnoreCase("You successfully clicked an alert");
    }

    public boolean VerifyOKBtnIsClicked_Msg(){
        return ResultText().trim().equalsIgnoreCase("You clicked: Ok");
    }

    public boolean VerifyCancelBtnIsClicked_Msg(){
        return ResultText().trim().equalsIgnoreCase("You clicked: Cancel");
    }

    public boolean VerifyPromptValue_Msg_OnClickingOK(){
        return ResultText().trim().equalsIgnoreCase("JavascriptAlertTest");
    }

    public boolean VerifyPromptValue_Msg_OnClickingCancel(){
        return ResultText().trim().equalsIgnoreCase("You entered: null");
    }
}