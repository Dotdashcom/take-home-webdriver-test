package Dotdashcom.takehomewebdrivertest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotdashcom.takehomewebdrivertest.base.BaseClass;

public class DynamicControls extends BaseClass {
	
	
	 @FindBy(linkText = "Dynamic Controls")
	    WebElement dynamicControlsButton;

	    @FindBy(xpath = "//button[contains(text(),'Remove')]")
	    WebElement removeButton;

	    @FindBy(xpath = "//p[@id='message']")
	    WebElement message;

	    @FindBy(xpath = "//button[contains(text(),'Add')]")
	    WebElement addButton;

	    @FindBy(xpath = "//button[contains(text(),'Enable')]")
	    WebElement enableButton;
	    @FindBy(xpath = "//button[contains(text(),'Disable')]")
	    WebElement disableButton;
	
	

	Actions action = new Actions(driver);
	
	JavascriptExecutor j = (JavascriptExecutor) driver;
	
	
	

	//Initializing the Page Objects:
	public DynamicControls(){
		PageFactory.initElements(driver, this);
	
	}

		
	public  void clickondynamiccontrols(){
			
			 j.executeScript("arguments[0].click();", new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(dynamicControlsButton)));
			
					    	
				
	}
	public void clickRemoveButton(){
        removeButton.click();
    }

   public String getMessage(WebDriver driver){
	   
	   WebDriverWait w = new WebDriverWait(driver,3);
	    w.until(ExpectedConditions.presenceOfElementLocated (By.id("message")));  
        return message.getText();
   }

   public void clickAddButton(){
        addButton.click();
   }
   public void clickEnableButton(){
        enableButton.click();
   }
   public  void clickDisableButton(){
        disableButton.click();
   }}
