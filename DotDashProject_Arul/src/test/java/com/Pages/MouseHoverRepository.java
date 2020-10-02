package com.Pages;

import com.BaseTest.TestEngine;
import com.CommonMethods.SeleniumCommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverRepository extends TestEngine {

    public MouseHoverRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using ="(//div[@class='figure']//img[@alt='User Avatar'])[1]")
    public WebElement _firstImageLocator;

    @FindBy(how = How.XPATH, using ="(//div[@class='figure']//img[@alt='User Avatar'])[2]")
    public WebElement _secondImageLocator;

    @FindBy(how = How.XPATH, using ="(//div[@class='figure']//img[@alt='User Avatar'])[3]")
    public WebElement _thirdImageLocator;

    @FindBy(how = How.XPATH, using ="//div[@class='figcaption']//a[text()='View profile']")
    public WebElement _viewProfileOption;

    @FindBy(how = How.XPATH, using ="//h2[contains(text(),'Sinatra doesn’t know this ditty')]")
    public WebElement _profileNavigation;

    @FindBy(how = How.XPATH, using ="//h3[text()='Hovers']")
    public WebElement _pageTitle;

    public static void MouseHoverOnFirstImage(WebElement _firstImageLocator){
        SeleniumCommonMethods.MouseHoverFunctionality(_firstImageLocator);
    }

    public static void MouseHoverOnSecondImage(WebElement _secondImageLocator){
        SeleniumCommonMethods.MouseHoverFunctionality(_secondImageLocator);
    }

    public static void MouseHoverOnThirdImage(WebElement _thirdImageLocator){
        SeleniumCommonMethods.MouseHoverFunctionality(_thirdImageLocator);
    }

    public void ClickOnViewProfile(){
        _viewProfileOption.click();
    }

    public boolean IsViewProfileOptionDisplayed(){
        return _viewProfileOption.isDisplayed();
    }

    public boolean IsProfileNavigated(){
        return _profileNavigation.isDisplayed();
    }

    public static void BrowserBack(){
        SeleniumCommonMethods.BrowserBack();
    }

    public void WaitMechanism(){
        SeleniumCommonMethods.WaitUntilElementAppears(_pageTitle);
    }
}