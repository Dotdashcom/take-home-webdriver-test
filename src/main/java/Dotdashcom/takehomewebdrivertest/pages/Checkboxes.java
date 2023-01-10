package Dotdashcom.takehomewebdrivertest.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotdashcom.takehomewebdrivertest.base.BaseClass;

public class Checkboxes extends BaseClass {
	
		
		//Page Factory - OR:
		@FindBy(xpath="//input[@id='username']")
		WebElement username;
		
		@FindBy(xpath="//a[contains(text(),'Checkboxes')]")
		WebElement checkboxtest;
		
		@FindBy(xpath="//body/div[2]/div[1]/div[1]/form[1]/input[1]")
		WebElement checkbox1;
		
		@FindBy(xpath="//body/div[2]/div[1]/div[1]/form[1]/input[2]")
		WebElement checkbox2;

		
		
		@FindBy(xpath="//div[@id='flash']")
		WebElement loginsuccesserrortext;
		
		JavascriptExecutor j = (JavascriptExecutor) driver;
		
		public Checkboxes(){
			PageFactory.initElements(driver, this);
		}

		public  boolean checkbox1status(){
			j.executeScript("arguments[0].click();", new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(checkboxtest)));
			
			    	if(!checkbox1.isSelected())
			    		checkbox1.click();
			    	
			    	
			return checkbox1.isSelected();
		}
}
