package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverPage {
	public WebDriver driver;


	public MouseHoverPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// paageObjectModel using selenium pagefactory

	}
	@FindBy(xpath = "//div[@class='example']//div[1]//img[1]")
	WebElement UserName1;



	/* @FindBy(xpath = "//div[@class='example']//div[1]//img[2]\"")
	    WebElement UserName2;

	 @FindBy(xpath = "//div[@class='example']//div[1]//img[3]\"")
	    WebElement UserName3;
	 */

	@FindBy(xpath = "//div[@class='example']//div[1]//img[1]")
	WebElement clickUser1;


	public void PerformMouseHover() {
		Actions ac;

		ac = new Actions(driver);
		ac.moveToElement(UserName1).moveToElement(clickUser1).click().build().perform();
		/*
     ac = new Actions(driver);
     ac.moveToElement(UserName2).moveToElement(clickUser1).build().perform()

     ac = new Actions(driver);
     ac.moveToElement(UserName2).moveToElement(clickUser3).build().perform();
		 */
	}
}
