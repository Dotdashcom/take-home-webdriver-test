package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage extends BaseClass {

    public DynamicContentPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = "//div[@id='content']/div[1]/div[2]")
    public  WebElement _dynamicContent1;
    @FindBy(how = How.XPATH, using = "//div[@id='content']/div[2]/div[2]")
    public  WebElement _dynamicContent2;
    @FindBy(how = How.XPATH, using = "//div[@id='content']/div[3]/div[2]")
    public WebElement _dynamicContent3;
    @FindBy(how = How.XPATH, using =  "//a[text()='click here']")
    public WebElement _clickHereButton;

    public static String _dynamicContent1text ;
    public static String _dynamicContent2text ;
    public static String _dynamicContent3text ;

    public void ClickClickHereButton(){
        _clickHereButton.click();
    }

    public void StoreDynamicText(){
        _dynamicContent1text = _dynamicContent1.getText().trim();
        _dynamicContent2text = _dynamicContent2.getText().trim();
        _dynamicContent3text = _dynamicContent3.getText().trim();
    }


}
