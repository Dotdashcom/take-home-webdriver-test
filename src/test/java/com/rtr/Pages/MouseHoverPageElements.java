package com.rtr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rtr.utils.CommonMethods;

public class MouseHoverPageElements extends CommonMethods {
	
	@FindBy(xpath = "//div[@class='example']//div[1]//img[1]")
	public static WebElement photoone;
	
	@FindBy(xpath = "//div[@class='example']//div[2]//img[1]")
	public static WebElement phototwo;
	
	@FindBy(xpath = "//div[@class='example']//div[3]//img[1]")
	public static WebElement photothree;
	
	@FindBy(xpath = "//div[@id=\"content\"]/div/div[1]/div/h5")
	public static WebElement user1;
	
	@FindBy(xpath = "//div[@id=\"content\"]/div/div[2]/div/h5")
	public static WebElement user2;
	
	@FindBy(xpath = "//div[@id=\"content\"]/div/div[3]/div/h5")
	public static WebElement user3;
	
	

	public MouseHoverPageElements() {
		PageFactory.initElements(driver, this);
	}

}
