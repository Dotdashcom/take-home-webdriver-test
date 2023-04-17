package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:7080/dynamic_content
public class DynamicContentPage {

    @FindBy(xpath = "//a[contains(@href, 'with')]")
    public WebElement linkClickHere;

    @FindBy(css = "html > body > div:nth-of-type(2) > div > div > div > div > div:nth-of-type(1) > div:nth-of-type(1) > img")
    public WebElement image1;
    
    @FindBy(css = "html > body > div:nth-of-type(2) > div > div > div > div > div:nth-of-type(2) > div:nth-of-type(1) > img")
    public WebElement image2;

    @FindBy(css = "html > body > div:nth-of-type(2) > div > div > div > div > div:nth-of-type(3) > div:nth-of-type(1) > img")
    public WebElement image3;

    @FindBy(css = "html > body > div:nth-of-type(2) > div > div > div > div > div:nth-of-type(1) > div:nth-of-type(2)")
    public WebElement text1;

    @FindBy(css = "html > body > div:nth-of-type(2) > div > div > div > div > div:nth-of-type(2) > div:nth-of-type(2)")
    public WebElement text2;

    @FindBy(css = "html > body > div:nth-of-type(2) > div > div > div > div > div:nth-of-type(3) > div:nth-of-type(2)")
    public WebElement text3;

    
    

    
    
    



    


    public DynamicContentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
