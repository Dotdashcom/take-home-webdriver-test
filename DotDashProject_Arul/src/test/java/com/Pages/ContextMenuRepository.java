package com.Pages;

import com.BaseTest.TestEngine;
import com.CommonMethods.SeleniumCommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuRepository extends TestEngine {

    //parameterized constructor
    public ContextMenuRepository (WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public static String _alertMsgExpected = "You selected a context menu";

    @FindBy(how = How.ID, using = "hot-spot")
    public WebElement _box;

    public void RightClickBox(){
        SeleniumCommonMethods.ContextClick(_box);
    }

    public String GetAlertMsgActual(){
        String _alertMsgActual = SeleniumCommonMethods.GetJSAlertText();
        return  _alertMsgActual;
    }

    public void CloseContextAlert(){
        SeleniumCommonMethods.JSAlertAccept();
    }

}