package com.takehome.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavascriptAlertsPage {
	
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"content\"]/div/ul/li/button")
	List<WebElement> jsButtons;
	
	@FindBy(xpath  = "//*[@id=\"content\"]/div/ul/li[1]/button")WebElement js1;
	@FindBy(xpath  = "//*[@id=\"content\"]/div/ul/li[2]/button")WebElement js2;
	@FindBy(xpath  = "//*[@id=\"content\"]/div/ul/li[3]/button")WebElement js3;
	
	
	@FindBy(id = "result")
	WebElement result;
	
	public JavascriptAlertsPage(WebDriver driver, String baseurl) {
		this.driver = driver;
		String url = baseurl + "/" + "javascript_alerts";
		driver.get(url);
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getJSButtons()
	{
		return jsButtons;
	}
	
	public WebElement getResult()
	{
		return result;
	}

	public WebElement getJS1()
	{
		return js1;
		
	}
	public WebElement getJS2()
	{
		return js2;
		
	}
	public WebElement getJS3()
	{
		return js3;
		
	}
}
