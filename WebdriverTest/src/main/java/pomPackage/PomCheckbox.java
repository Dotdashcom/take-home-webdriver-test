package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class PomCheckbox extends BaseClass{
	
	public PomCheckbox() {
		 
		 PageFactory.initElements(driver,this);
	 }
  
	@FindBy (xpath= "//body/div[2]/div[1]/div[1]/form[1]/input[1]") WebElement checkbox1;
	
	@FindBy (xpath= "//body/div[2]/div[1]/div[1]/form[1]/input[2]") WebElement checkbox2;
	
	public void checkbothbox() throws InterruptedException {
		checkbox2.click();
		
		Thread.sleep(3000);
		checkbox1.click();
		
		Thread.sleep(3000);
		checkbox2.click();
		
	}
	
	public void uncheckbothbox() throws InterruptedException {
		
		Thread.sleep(3000);
		checkbox1.click();
		
		Thread.sleep(3000);
		checkbox2.click();
		
	
	}
	public boolean varifycheckbox1() {
		
		return checkbox1.isDisplayed();	
	}
	
    public boolean varifycheckbox2() {
		
		return checkbox2.isDisplayed();	
	}
	
	
}
