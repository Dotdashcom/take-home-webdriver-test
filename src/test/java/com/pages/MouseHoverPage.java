package com.pages;

import com.testbase.BaseClass;
import com.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverPage extends BaseClass {

    public MouseHoverPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(how = How.XPATH, using =  "//a[@href='/users/1']/preceding::img[1]")
    public WebElement _user1Img;
    @FindBy(how = How.XPATH, using =  "//a[@href='/users/2']/preceding::img[1]")
    public WebElement _user2Img;
    @FindBy(how = How.XPATH, using =  "//a[@href='/users/3']/preceding::img[1]")
    public WebElement _user3Img;
    @FindBy(how = How.XPATH, using =  "//a[@href='/users/1']")
    public WebElement _user1ViewProfile;
    @FindBy(how = How.XPATH, using =  "//a[@href='/users/2']")
    public WebElement _user2ViewProfile;
    @FindBy(how = How.XPATH, using =  "//a[@href='/users/3']")
    public WebElement _user3ViewProfile;

    @FindBy(how = How.XPATH, using =  "//h2[text()='Sinatra doesn’t know this ditty.']")
    public WebElement _nextPageHeader;



    public void HoverOverImage1ClickViewProfile() throws InterruptedException {
        CommonMethods.HoverOverElement(_user1Img);
        _user1ViewProfile.click();
     //   CommonMethods.Wait_ajax();
    }
    public void HoverOverImage2ClickViewProfile() throws InterruptedException {
        CommonMethods.HoverOverElement(_user2Img);
        _user2ViewProfile.click();
       // CommonMethods.Wait_ajax();
    }
    public void HoverOverImage3ClickViewProfile() throws InterruptedException {
        CommonMethods.HoverOverElement(_user3Img);
        _user3ViewProfile.click();
     //   CommonMethods.Wait_ajax();
    }

    public boolean NextPageHeaderValidation(){
       return _nextPageHeader.isDisplayed();
    }


}
