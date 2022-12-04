package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import mainUtils.UtilityClass;

public class CheckBoxes {
	
	
	WebDriver driver;
	
	By chkbox1 = By.xpath("//*[@id=\"checkboxes\"]/input[1]");  
    By chkbox2 = By.xpath("//*[@id=\"checkboxes\"]/input[2]");
    By txt_checkbox =By.xpath("//*[@id=\"content\"]/div/h3");

    public CheckBoxes(WebDriver driver){

        this.driver = driver;

    }
    UtilityClass utlity = new UtilityClass(driver);
    
    public void checkbox(String toptext){
    	
    	Reporter.log("Inside checkboxes Method $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    	
    	utlity.validate_Text(txt_checkbox,toptext,driver);
    	
        utlity.click_checkbox(chkbox1, driver);
        utlity.chk_isSelected(chkbox1,true, driver);

    }
    public void uncheckbox(String toptext){
    	
    	Reporter.log("Inside uncheckboxes Method $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    	
    	utlity.validate_Text(txt_checkbox,toptext,driver);
    	
        utlity.unclick_checkbox(chkbox2, driver);
        utlity.chk_isSelected(chkbox2,false, driver);

    }

}
