package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage extends BaseClass {

    public DynamicLoadingPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using =  "//div[@id='start']/button")
    public WebElement _startButton;


    @FindBy(how = How.XPATH, using =  "//div[@id='finish']/h4")
    public WebElement _message;


    public static String _expectedMessage = "Hello World!";

    public void ClickStartButton(){
        _startButton.click();
    }


}
