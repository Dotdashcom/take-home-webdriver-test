package webtests.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webtests.BasePackage.WT_BaseClass;

public class WT_017_NotificationMsg_POM extends WT_BaseClass {

	//Locators
	@FindBy (xpath= "//a[contains(text(),'Click here')]")
    WebElement Clickherelink;
		
	@FindBy (xpath= "//div[@id='flash-messages']")
	WebElement messagebox;
		
      //Contructor  
     public  WT_017_NotificationMsg_POM() {
    	 PageFactory.initElements(driver,this );
    }
        
     public void ClickHereLink() {
      	Clickherelink.click();
    }
     
     public String MessageBox() {
      return messagebox.getText();
		
    }
}
	

