package com.pages;

import com.testbase.BaseClass;
import com.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewTabPage extends BaseClass {

    public NewTabPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using =  "//a[text()='Click Here']")
    public WebElement _clickHereButton;

    @FindBy(how = How.XPATH, using =  "//h3[text()='New Window']")
    public WebElement _newWindowText;


    public void ClickClickHereButton(){
        _clickHereButton.click();
        CommonMethods.Switch_New_Tab();
    }

    public boolean NewWindowMessageValidation(){
        return _newWindowText.isDisplayed();
    }




}
