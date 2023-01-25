package pomPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basePackage.BaseClass;

public class PomContextMenu extends BaseClass {
	
	public PomContextMenu() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (id ="hot-spot") WebElement contextmenu;
	
    public  void rightclickoncontextmenu() {
    	Actions actions = new Actions(driver);
    	
    	actions.moveToElement(contextmenu).build().perform();
    	actions.contextClick(contextmenu).perform();
    	
     	
    }
     public String alert() throws InterruptedException {
    	 
    	// Switching to Alert 
    	 
    	

        Alert alert=  driver.switchTo().alert();	
         

         		
         // Capturing alert message.    
         String alertMessage= driver.switchTo().alert().getText();		
         		
         // Displaying alert message		
       System.out.println(alertMessage);	
         Thread.sleep(5000);
         		
         // Accepting alert		
         alert.accept();
		return alertMessage;		
    	 
    	    	 
     }
}
