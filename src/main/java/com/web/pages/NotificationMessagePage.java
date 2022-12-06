package com.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.base.TestBase;

public class NotificationMessagePage extends TestBase{

    @FindBy(xpath="//*/a[contains(text(),'here')]")
    WebElement getLink;

    @FindBy(xpath="//*[@id='flash']")
    WebElement flashElement;


    public NotificationMessagePage(){

        PageFactory.initElements(driver, this);
    }

    public void linkTextClick(){
         getLink.click();
    }

    public String getFlashElementText(){
        return flashElement.getText();
    }


}
