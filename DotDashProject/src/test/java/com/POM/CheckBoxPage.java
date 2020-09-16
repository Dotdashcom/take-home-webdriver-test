package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage {


	public WebDriver driver;

	public CheckBoxPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// paageObjectModel using selenium pagefactory

	}

	@FindBy(xpath = "//*[@id='checkboxes']/input[1]")
	WebElement checkbox1;

	//  @FindBy(xpath = "//body//input[2]")
	//  WebElement checkbox2;

	public void checkbox1() {
		checkbox1.click();	
	}

	public void ClickCheckBox1() {
		checkbox1.click();
	}

	@FindBy(xpath = "//body//input[2]")
	WebElement checkbox2;

	public void Uncheckbox2() {
		checkbox2.click();
	}

	public void ClickCheckBox2() {
		checkbox2.click();
	}


	public boolean checkBoxStatus() {
		return checkbox1.isSelected() && checkbox2.isSelected();

	}






	/*
		@FindBy(xpath="//iframe[@id='mce_0_ifr']")
		public WebElement iframe;
		@FindBy(xpath="//body[@id='tinymce']")
		public WebElement text;


		public void IFrame() {

			driver.switchTo().frame(iframe);

			text.sendKeys("dotdash");
	;
			driver.switchTo().parentFrame();

		}*/
}

