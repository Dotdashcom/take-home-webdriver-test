package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class Checkbox extends BaseClass {
	
	@FindBy(xpath = "(//form[@id='checkboxes']/input)[1]")
	public WebElement checkBox1;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	public WebElement checkBox2;

	public Checkbox() {
		PageFactory.initElements(driver, this);
	}
	
	public void Checkbox1() {
		checkBox1.click();
		
	}
	public void Checkbox2() {
		checkBox2.click();
		
	}
}
