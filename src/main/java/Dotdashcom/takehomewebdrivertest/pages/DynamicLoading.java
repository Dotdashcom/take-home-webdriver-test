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

public class DynamicLoading extends BaseClass {
	
	@FindBy(linkText = "Dynamic Loading")
    WebElement dynamicLoadingButton;

    @FindBy(partialLinkText = "that is hidden")
    WebElement example1Button;
    @FindBy(tagName = "button")
    WebElement startButton;

    @FindBy(xpath = "//h4[.='Hello World!']")
    WebElement message;
	
	
Actions action = new Actions(driver);
	
	JavascriptExecutor j = (JavascriptExecutor) driver;
	
	
	

	//Initializing the Page Objects:
	public DynamicLoading(){
		PageFactory.initElements(driver, this);
	
	}

		
	public  void clickondynamicloading(){
			
			 j.executeScript("arguments[0].click();", new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(dynamicLoadingButton)));
			
					    	
				
	}

    public void clickButtons(){
        example1Button.click();
        startButton.click();
    }

    public String getMessage(WebDriver driver){
 	   
 	   WebDriverWait w = new WebDriverWait(driver,10);
 	    w.until(ExpectedConditions.presenceOfElementLocated (By.id("finish")));  
         return message.getText();
    }
}
	
