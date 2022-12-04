package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import mainUtils.UtilityClass;

public class ContextMenu {
	
	WebDriver driver;
	

	By contextmenu = By.id("hot-spot");
	By txt_cm =By.xpath("//*[@id=\"content\"]/div/h3");
    

    public ContextMenu(WebDriver driver){

        this.driver = driver;

    }
    UtilityClass utlity = new UtilityClass(driver);
	
    public void validateContextMenu(String toptext){
    	
    	Reporter.log("Inside validateContextMenu Method $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    	
    	utlity.validate_Text(txt_cm,toptext,driver);
    	
    	utlity.right_click(contextmenu,driver);
    	
    	utlity.validate_alert_msg("You selected a context menu",driver);
    	utlity.accept_alert(driver);

    }

}
