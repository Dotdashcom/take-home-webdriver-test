package com.takehome.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DynamanicContent {
	
	
	WebDriver driver;
	
	
	@FindBy(id = "content")WebElement content;
	
	
	
	
	
	public DynamanicContent(WebDriver driver, String baseurl) {
		this.driver = driver;
		String url = baseurl + "/" +"dynamic_content";
		driver.get(url);
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	public WebElement getContentElement()
	{

		return content;
	
	}
	
	public List<WebElement> getDynamicContentElements ()
	{
		List<WebElement> divList = (List<WebElement>) content.findElements(By.xpath("//*[@id=\"content\"]/div/div[2]"));
		System.out.println("Dize: " + divList.size());
		
		return divList;
		
	}
} 
