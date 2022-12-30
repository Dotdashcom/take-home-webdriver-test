package com.takehome.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverPage {
	
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"content\"]/div/div")
	List<WebElement> images;
	
	
	public MouseHoverPage(WebDriver driver, String baseurl) {
		this.driver = driver;
		String url = baseurl + "/" + "hovers";
		driver.get(url);
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getImages()
	{
		return images;
	}
	

}
