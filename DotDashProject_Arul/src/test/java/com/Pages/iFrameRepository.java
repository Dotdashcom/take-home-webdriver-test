package com.Pages;

import com.BaseTest.TestEngine;
import com.CommonMethods.SeleniumCommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class iFrameRepository extends TestEngine {

    //parameterized constructor
    public iFrameRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using ="mce_0_ifr")
    public WebElement _iFrameLocator;

    @FindBy(how = How.XPATH, using ="//body[@id='tinymce']//p")
    public WebElement _contentBoxLocator;

    public static String text = "Testing if focus is changed to iframe and able to type in";

    public void SwitchToiFrame(){
        SeleniumCommonMethods.SwitchToiFrameByWebElement(_iFrameLocator);
    }

    public void EnterText(String text){
        SeleniumCommonMethods.TextFieldClear(_contentBoxLocator);
        _contentBoxLocator.sendKeys(text);
    }
}
