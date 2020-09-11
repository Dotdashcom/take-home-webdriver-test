package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsPage extends BaseClass {

    public JavaScriptAlertsPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(how = How.XPATH, using =  "//button[@onclick='jsAlert()']")
    public WebElement _jSAlertbutton;


    @FindBy(how = How.XPATH, using = "//button[@onclick='jsConfirm()']")
    public WebElement _jSConfirmbutton;


    @FindBy(how = How.XPATH, using = "//button[@onclick='jsPrompt()']")
    public WebElement _jSPromptbutton;

    @FindBy(how = How.XPATH, using = "//p[@id='result']")
    public WebElement _resultText;

    public void ClickJSAlertButton(){
        _jSAlertbutton.click();
    }
    public void ClickJSConfirmButton(){
        _jSConfirmbutton.click();
    }
    public void ClickJSpromptButton(){
        _jSPromptbutton.click();
    }

    public String GetResultText(){
        return _resultText.getText().trim();
    }
}
