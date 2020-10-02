package com.Pages;

import com.BaseTest.TestEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptErrorRepository extends TestEngine {

    public JavaScriptErrorRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using ="//body[@onload='loadError()']/p")
    public WebElement _jsErrorLocator;

    public boolean IsJavascriptErrorDisplayed(){
        return _jsErrorLocator.isDisplayed();
    }

    public String GetErrorMsg(){
        return _jsErrorLocator.getText().trim();
    }
}