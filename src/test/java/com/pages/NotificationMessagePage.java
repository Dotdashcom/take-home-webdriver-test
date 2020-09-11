package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage extends BaseClass {

    public NotificationMessagePage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(how = How.XPATH, using =  "//a[text()='Click here']")
    public WebElement _clickHereButton;

    @FindBy(how = How.XPATH, using =  "//div[@id='flash']")
    public WebElement _flashMessage;




    public void ClickClickHereButton(){
        _clickHereButton.click();
    }

    public Boolean IsFlashAlertPresent(){
        return _flashMessage.isDisplayed();
    }

    public String GetflashMessage(){
        return _flashMessage.getText().trim();
    }




}
