package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import mainUtils.UtilityClass;

public class Dynamicdata {
	
	WebDriver driver;
	
	By txthead_dynamic_content =By.xpath("//*[@id=\"content\"]/div/h3");
	By txt_dynamic_content =By.xpath("//*[@id=\"content\"]/div[3]/div[2]");
	
	
	By txthead_dynamic_control =By.xpath("//*[@id=\"content\"]/div[1]/h4[1]");
	By btn_Remove =By.xpath("//*[@id=\"checkbox-example\"]/button");
	By btn_Add =By.xpath("//*[@id=\"checkbox-example\"]/button[text()='Add']");
	
	By clk_checkbox =By.xpath("//*[@id=\"checkbox\"]/input");
	By click_checkbox =By.xpath("//*[@id=\"checkbox\"]");
	
	By btn_enable =By.xpath("//*[@id=\"input-example\"]/button[text()=\"Enable\"]");
	By btn_disable =By.xpath("//*[@id=\"input-example\"]/button[text()=\"Disable\"]");
	By enter_text =By.xpath("//*[@id=\"input-example\"]/input");
	
	By txthead_dynamic_loading =By.xpath("//*[@id=\"content\"]/div/h3");
	By btn_start =By.xpath("//*[@id=\"start\"]/button");
	By verify_dynamic_loading =By.id("finish");
	
    

    public Dynamicdata(WebDriver driver){

    	
        this.driver = driver;

    }
    UtilityClass utlity = new UtilityClass(driver);

    
    public void dynamic_content(String toptext) {
    	
    	Reporter.log("Inside Dynamic Content Method $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    	
    	
    	utlity.validate_Text(txthead_dynamic_content,toptext,driver);
    	
    	
    	String initial_txt = utlity.fetch_Text(txt_dynamic_content, driver);
    	driver.navigate().refresh();
    	
    	utlity.explicit_wait(txt_dynamic_content, driver);

    	System.out.println(initial_txt);
    	//System.out.println(after_txt);
    	utlity.not_validate_Text(txt_dynamic_content,initial_txt, driver);
    	
    	//Assert.assertNotEquals(initial_txt, after_txt, "Text is not matching");
    	
    }
    
    public void dynamic_Control(String toptext) throws InterruptedException {
    	
    	Reporter.log("Inside Dynamic Control Method $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    	
    	utlity.validate_Text(txthead_dynamic_control,toptext,driver);
    	utlity.click_anything(btn_Remove, driver);
    	
    	utlity.explicit_wait(btn_Add,driver);    	
    	
//		Test asserts that the checkbox is gone.

    	try {
    		WebElement clk_chkbx = driver.findElement(clk_checkbox);
    	}
    	catch (Exception e) {
    		
    		System.out.println("Checkbox is gone");
    		Reporter.log("Checkbox is gone");
    		
    	}

//		Test clicks on Add Button and uses explicit wait.

    	utlity.click_anything(btn_Add, driver);
    	utlity.explicit_wait(btn_Remove,driver);
    	
//		Test asserts that the checkbox is present.

    	utlity.chk_isDisplayed(click_checkbox, true, driver);
    	
    	
//		Test clicks on the Enable Button and uses explicit wait.
    	utlity.click_anything(btn_enable, driver);
    	utlity.explicit_wait(btn_disable,driver);
    	
//		Test asserts that the text box is enabled.
//    	WebElement enabled_enter_text = driver.findElement(enter_text);
    	//Assert.assertEquals(enabled_enter_text.isEnabled(), true);
    	
    	utlity.chk_isEnabled(enter_text, true, driver);
    	
    	//enabled_enter_text.sendKeys("test");
    	utlity.enter_text(enter_text, driver, "test");
    	
//		Test clicks on the Disable Button and uses explicit wait.
    	utlity.click_anything(btn_disable, driver);
    	utlity.explicit_wait(btn_enable,driver);
    	
//		Test asserts that the text box is disabled.
    	utlity.chk_isEnabled(enter_text, false, driver);
    	
    }
    
    public void dynamic_loading(String toptext) throws InterruptedException {
    	
    	Reporter.log("Inside Dynamic loading Method $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    	utlity.validate_Text(txthead_dynamic_loading,toptext,driver);
    	utlity.click_anything(btn_start,driver);
    	utlity.explicit_wait(verify_dynamic_loading,driver);    	
    	
    	utlity.validate_Text(verify_dynamic_loading,"Hello World!",driver);
    	
    }
}
