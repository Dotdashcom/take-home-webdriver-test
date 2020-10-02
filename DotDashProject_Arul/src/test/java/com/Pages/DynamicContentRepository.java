package com.Pages;

import com.BaseTest.TestEngine;
import com.CommonMethods.SeleniumCommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentRepository extends TestEngine {

    //parameterized constructor
    public DynamicContentRepository (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "(//div[@id='content']//following::div[@class='large-10 columns'])[1]")
    public  WebElement _dynamicContent1;

    @FindBy(how = How.XPATH, using = "(//div[@id='content']//following::div[@class='large-10 columns'])[2]")
    public  WebElement _dynamicContent2;

    @FindBy(how = How.XPATH, using = "(//div[@id='content']//following::div[@class='large-10 columns'])[3]")
    public  WebElement _dynamicContent3;

    @FindBy(how = How.XPATH, using = "//a[text()='click here']")
    public WebElement _staticClickBtn;

    public static String _paragraph1Text;
    public static String _paragraph2Text;
    public static String _paragraph3Text;

    public void RefreshBrowser(){
        SeleniumCommonMethods.BrowserRefresh();
    }

    public void GetParagraph1Text(){
         _paragraph1Text = _dynamicContent1.getText().trim();
    }

    public void GetParagraph2Text(){
         _paragraph2Text =  _dynamicContent2.getText().trim();
    }

    public void GetParagraph3Text(){
         _paragraph3Text =  _dynamicContent3.getText().trim();
    }

    public void GetallParagraphText(){
        GetParagraph1Text();
        GetParagraph2Text();
        GetParagraph3Text();
    }

    public void ClickStaticButton(){
        _staticClickBtn.click();
    }
}