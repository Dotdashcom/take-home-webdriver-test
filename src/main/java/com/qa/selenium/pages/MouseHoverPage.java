package com.qa.selenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.base.TestBase;

public class MouseHoverPage extends TestBase{

	List<WebElement> Img = driver.findElements(By.cssSelector("div[class='figure']>img"));
	
	
	List<WebElement> ImgText = driver.findElements(By.cssSelector("div[class='figcaption']>h5"));
	
	
	public MouseHoverPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement FirstImg() {
		return Img.get(0);
	}
	public WebElement secondImg() {
		return Img.get(1);
	}
	public WebElement ThirdImg() {
		return Img.get(2);
	}
	
	public String FirstText() {
		return ImgText.get(0).getText();
	}
	public String secondText() {
		return ImgText.get(1).getText();
	}
	public String ThirdText() {
		return ImgText.get(2).getText();
	}
	
	public void Img1display() throws InterruptedException {
		
		Actions ac = new Actions(driver);
		Thread.sleep(1000);
		ac.moveToElement(FirstImg()).click().build().perform();
		Thread.sleep(1000);
	}

	public void Img2display() throws InterruptedException {
		
		Actions ac = new Actions(driver);
		Thread.sleep(2000);
		ac.moveToElement(secondImg()).click().build().perform();
		Thread.sleep(1000);

		
	}
	public void Img3display() throws InterruptedException {
		
		Actions ac = new Actions(driver);
		Thread.sleep(2000);
		ac.moveToElement(ThirdImg()).click().build().perform();
		Thread.sleep(1000);

		
	}
	

}
