package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import mainUtils.UtilityClass;

public class Window_new {
	
	WebDriver driver;
	
	
	By txt_window =By.xpath("//*[@id=\"content\"]/div/h3");
	By link_clik_msg = By.linkText("Click here");
	By vali_msg = By.id("flash");
	By clk_new_window = By.xpath("//*[@id=\"content\"]/div/a");
	
	 public Window_new(WebDriver driver){
		 this.driver = driver;

	    }
	 UtilityClass utlity = new UtilityClass(driver);
	 
	 public void navigate_new_window(String toptext) {
		
		 Reporter.log("Inside navigate_new_window Method $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		 
		 utlity.validate_Text(txt_window,toptext,driver);
	    
		 utlity.click_anything(clk_new_window, driver);
		 
		 String mainWindowHandle = driver.getWindowHandle();
		 Set<String> windows = driver.getWindowHandles(); 
		 System.out.println(windows);
		 Iterator<String> iterator = windows.iterator();
		 while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	       		 	Assert.assertEquals(driver.getTitle(), "New Window");
	       		 	WebElement txt_new_window = driver.findElement(By.className("example"));
	       		 Assert.assertEquals(txt_new_window.getText(), "New Window");
	                }
	        }
	 }
	 
	 public void notification_message(String toptext) throws InterruptedException {
		 Reporter.log("Inside notification_message Method $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	    	
		 utlity.validate_Text(txt_window,toptext,driver);

		 int counter=0;
		 String success = "Action successful\r\n" + 
		 		"×";
		 String unsuccess="Action unsuccesful, please try again\r\n" + 
		 		"×";
		 while(counter<=5) {
			 System.out.println("Looping time");
//				Test clicks on the Click Here link a multiple times.
			 utlity.click_anything(link_clik_msg, driver);
			 
			 String expct = utlity.fetch_Text(vali_msg, driver);
			 
			 if (expct.contains("successful")) {
				 utlity.validate_Text(vali_msg,success, driver);
			 }
			 else {
				 utlity.validate_Text(vali_msg,unsuccess, driver);
			 }
				
			counter++; 
		 }
	 	}

}
