package com.theInternet.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DynamicContentPage {
WebDriver driver;

@FindBy(xpath = "//img")
public List<WebElement> url_Images;

@FindBy(xpath = "//*[@class='large-10 columns']")
public List<WebElement> text_Contents;

public DynamicContentPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
}
public void verifyDynamicContentOnRefresh(){
	String img1_url = url_Images.get(1).getAttribute("src");
	 String text_Content1 = text_Contents.get(1).getText();
	driver.navigate().refresh();
	Assert.assertTrue(!url_Images.get(1).getAttribute("src").equalsIgnoreCase(img1_url) && 
			     !text_Contents.get(1).getText().equalsIgnoreCase(text_Content1),"Content not changed on refresh");
    }




}



