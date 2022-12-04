package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import mainUtils.UtilityClass;

public class Dropdown {
	
	WebDriver driver;
	

	By sl_drpdown = By.id("dropdown");
	By txt_dropdown =By.xpath("//*[@id=\"content\"]/div/h3");
    

    public Dropdown(WebDriver driver){

        this.driver = driver;

    }
    UtilityClass utlity = new UtilityClass(driver);
	
    public void select_dropdown(String toptext) {
    	
    	Reporter.log("Inside dropdown Method $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    	
    	utlity.validate_Text(txt_dropdown,toptext,driver);
    	
    	utlity.dropdown(sl_drpdown,"index","1", driver);
    	utlity.val_dropdown_value(sl_drpdown, "Option 1", driver); // validating text of option1
    	utlity.dropdown(sl_drpdown,"index","2", driver);
    	utlity.val_dropdown_value(sl_drpdown, "Option 2", driver); // validating text of option1
    	
    }

}
