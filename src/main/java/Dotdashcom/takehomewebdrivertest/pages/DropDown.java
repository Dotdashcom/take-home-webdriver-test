package Dotdashcom.takehomewebdrivertest.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotdashcom.takehomewebdrivertest.base.BaseClass;

public class DropDown extends BaseClass {
	
	
	
	
	@FindBy(xpath="//select[@id='dropdown']")
	WebElement dropdown1;
	
	
	@FindBy(xpath="//a[contains(text(),'Dropdown')]")
	WebElement dropdownmenu;
	
	

	Actions action = new Actions(driver);
	
	JavascriptExecutor j = (JavascriptExecutor) driver;
	
	
	

	//Initializing the Page Objects:
	public DropDown(){
		PageFactory.initElements(driver, this);
	}

	public  String draganddropoption1(){
		j.executeScript("arguments[0].click();", new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(dropdownmenu)));
		
		j.executeScript("arguments[0].click();", new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(dropdown1)));
		Select dropdown = new Select (dropdown1);
		dropdown.selectByValue("1");
		dropdown.getOptions();
		
		
		return dropdown.getFirstSelectedOption().getText();
				    	
			

}
	public  String draganddropoption2(){
		j.executeScript("arguments[0].click();", new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(dropdownmenu)));
		
		j.executeScript("arguments[0].click();", new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(dropdown1)));
		Select dropdown = new Select (dropdown1);
		dropdown.selectByValue("2");
		dropdown.getOptions();
		
		
		return dropdown.getFirstSelectedOption().getText();
				    	
			

}}


