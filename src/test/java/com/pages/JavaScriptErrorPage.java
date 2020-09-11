package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptErrorPage extends BaseClass {

    public JavaScriptErrorPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = "//body[@onload='loadError()']/p")
    public WebElement _javascriptError;

    public static String _javascriptErrorMessage = "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.";


    public String GetJavascriptErrorMessage(){
       return _javascriptError.getText().trim();
    }
}
