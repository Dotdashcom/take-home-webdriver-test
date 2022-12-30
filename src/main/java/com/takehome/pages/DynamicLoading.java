package com.takehome.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoading {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"start\"]/button") WebElement startButton;
	@FindBy(id="loading") WebElement loadingDiv;
	@FindBy(id="finish") WebElement finishDiv;
	
	public DynamicLoading(WebDriver driver, String baseurl) {
		this.driver = driver;
		String url = baseurl + "/" +"dynamic_loading/2";
		driver.get(url);
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getStartButton()
	{
		return startButton;
	}
	
	public WebElement getLoadingDiv()
	{
		return loadingDiv;
	}
	
	public WebElement getFinishDiv()
	{
		return finishDiv;
	}

}
