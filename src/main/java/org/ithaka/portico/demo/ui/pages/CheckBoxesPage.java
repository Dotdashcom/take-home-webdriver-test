package org.ithaka.portico.demo.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxesPage {
	
	public  WebDriver driver;
	
	public CheckBoxesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public CheckBoxesPage() {}
	
	
	@FindBy(xpath="//input[@type = 'checkbox'][1]")
	public WebElement checkbox_1;
	
	@FindBy(xpath="//input[@type = 'checkbox'][2]")
	public WebElement checkbox_2;
	
	public void checkTheBox() {
		
		driver.get("http://localhost:7080/checkboxes");
		
		if(!checkbox_1.isSelected())
			checkbox_1.click();
		
		
		if(!checkbox_2.isSelected())
			checkbox_2.click();
		
		
	}

}
