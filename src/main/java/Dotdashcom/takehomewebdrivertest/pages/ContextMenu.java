package Dotdashcom.takehomewebdrivertest.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotdashcom.takehomewebdrivertest.base.BaseClass;

	public class ContextMenu extends BaseClass {
		
			
		
			
		@FindBy(xpath="//a[contains(text(),'Context Menu')]")
		WebElement contextmenu;
			
			@FindBy(xpath="//div[@id='hot-spot']")
			WebElement boxclick;
			
			@FindBy(xpath="//body/div[2]/div[1]/div[1]/form[1]/input[2]")
			WebElement checkbox2;

			
			
			@FindBy(xpath="//div[@id='flash']")
			WebElement loginsuccesserrortext;
			
			Actions action = new Actions(driver);
			


			WebDriverWait wait = new WebDriverWait(driver, 15);

			JavascriptExecutor j = (JavascriptExecutor) driver;
			// Initializing the Page Objects:
			public ContextMenu() {
				PageFactory.initElements(driver, this);
			}

			public  String contextmenu(){
				
				j.executeScript("arguments[0].click();", new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(contextmenu)));
				
				    	action.contextClick(boxclick).perform();
				    	//Switch to the alert box and click on OK button
				    	Alert alert = driver.switchTo().alert();
				    	String alerttext = alert.getText();
				    	System.out.println("Alert Text\n" +alerttext);
				    	alert.accept();
				    	
				    	
				return alerttext;
			}
	}


