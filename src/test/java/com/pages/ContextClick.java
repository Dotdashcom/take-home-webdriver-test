package com.pages;

import com.testbase.BaseClass;
import com.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContextClick extends BaseClass {

    public ContextClick (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using =  "//div[@id='hot-spot']")
    public WebElement _rightClickBox;

    public void RightclickOnBox(){
        CommonMethods.Context_Click(_rightClickBox);
    }


}
