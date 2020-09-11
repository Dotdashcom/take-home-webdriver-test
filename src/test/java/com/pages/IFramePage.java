package com.pages;

import com.testbase.BaseClass;
import com.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IFramePage extends BaseClass {

    public IFramePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using =  "tinymce")
    public WebElement _textBoxiniFrame;

    @FindBy(how = How.ID, using =  "mce_0_ifr")
    public WebElement _iFrameElement;

    public void SwitchtoiFrame(){

        CommonMethods.SwitchToiFrameByWebElement(_iFrameElement);


    }

    public void  TextBoxType(String _text){
        _textBoxiniFrame.clear();
        _textBoxiniFrame.sendKeys(_text);
    }


}
