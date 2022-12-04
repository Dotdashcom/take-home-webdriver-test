package pages;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.Reporter;

import mainUtils.UtilityClass;

public class javascripts_alerts {
	WebDriver driver;

	By txt_jsAlerts =By.xpath("//*[@id=\"content\"]/div/h3");
	By lnk_dwnlod_file =By.linkText("some-file.txt");
	By txt_jsalerts1 = By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button");
	By val_txt_jsalert1 = By.id("result");
	By txt_jsalerts2 = By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button");
	By txt_jsalerts3 = By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button");
	
	
	public javascripts_alerts(WebDriver driver){
		this.driver = driver;
	}

	UtilityClass utlity = new UtilityClass(driver);
	public void val_javascript_alerts(String toptext) {
		Reporter.log("Inside val_javascript_alerts Method $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	    	

		utlity.validate_Text(txt_jsAlerts,toptext,driver);
	    
//		Test Clicks on JS Alert Button.
//		Test asserts alert message.
		utlity.click_anything(txt_jsalerts1, driver);
		utlity.validate_alert_msg("I am a JS Alert",driver);
		utlity.accept_alert(driver);
		utlity.assert_text(val_txt_jsalert1, "You successfuly clicked an alert", driver);
		
		
//		Test clicks on JS confirm Button and clicks ok on alert.
//		Test asserts the alert message.
		utlity.click_anything(txt_jsalerts2, driver);
		utlity.validate_alert_msg("I am a JS Confirm", driver);
		utlity.accept_alert(driver);
		utlity.assert_text(val_txt_jsalert1, "You clicked: Ok", driver);
		
		
//		Test clicks on JS Prompt Button and types a message on Prompt.
//		Test asserts that the alert message contains the typed message.
		utlity.click_anything(txt_jsalerts3, driver);
		utlity.validate_alert_msg("I am a JS prompt", driver);
		utlity.enter_txt_jsAlerts(driver, "testing dash");
		utlity.accept_alert(driver);
		utlity.assert_text(val_txt_jsalert1, "You entered: testing dash", driver);
		 
		 
	 
	 }
	
	public void val_javascript_alerts_error() {
		Reporter.log("Inside Javascript Error message");
		LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> log = entries.getAll();
        String[] error = log.get(0).getMessage().split("TypeError:");
        Assert.assertEquals(error[1].trim(), "Cannot read properties of undefined (reading 'xyz')");
        System.out.println(Arrays.toString(error));
		
}
	
}
	
