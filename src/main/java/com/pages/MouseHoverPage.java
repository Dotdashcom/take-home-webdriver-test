package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class MouseHoverPage extends Base{
	Actions act= new Actions(driver);
	@FindBy(xpath="(//div[@class='figure']/img)[1]")
	WebElement image_1;
	
	@FindBy(xpath="(//div[@class='figure']/img)[2]")
	WebElement image_2;
	
	@FindBy(xpath="(//div[@class='figure']/img)[3]")
	WebElement image_3;
	
	@FindBy(xpath="(//h5)[1]")
	WebElement image_1_name;
	
	@FindBy(xpath="(//h5)[2]")
	WebElement image_2_name;
	
	@FindBy(xpath="(//h5)[3]")
	WebElement image_3_name;
	
	@FindBy(xpath="(//a)[2]")
	WebElement image_1_viewProfileLink;
	
	@FindBy(xpath="(//a)[3]")
	WebElement image_2_viewProfileLink;
	
	@FindBy(xpath="(//a)[4]")
	WebElement image_3_viewProfileLink;
	
	public MouseHoverPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void hoverImage_1() {
		act.moveToElement(image_1).perform();
	}
	public String getImage_1Name() {
		String image_1name=image_1_name.getText();
		return image_1name;
	}
	public boolean viewProfileLink_1IsDisplayed() {
		boolean flag_1=image_1_viewProfileLink.isDisplayed();
		return flag_1;
	}
	
	public void hoverImage_2() {
		act.moveToElement(image_2).perform();
	}
	public String getImage_2Name() {
		String image_2name=image_2_name.getText();
		return image_2name;
	}
	public boolean viewProfileLink_2IsDisplayed() {
		boolean flag_2=image_2_viewProfileLink.isDisplayed();
		return flag_2;
	}
	
	public void hoverImage_3() {
		act.moveToElement(image_3).perform();
	}
	public String getImage_3Name() {
		String image_3name=image_3_name.getText();
		return image_3name;
	}
	public boolean viewProfileLink_3IsDisplayed() {
		boolean flag_3=image_3_viewProfileLink.isDisplayed();
		return flag_3;
	}

}
