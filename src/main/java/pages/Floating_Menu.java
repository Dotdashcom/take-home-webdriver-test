package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import mainUtils.UtilityClass;

public class Floating_Menu {
	WebDriver driver;
	
	
	By txt_floatingmenu = By.xpath("//*[@id=\"content\"]/div/h3");
	
	By hover_img1 = By.xpath("//*[@id=\"content\"]/div/div[1]/img");
	By hover_img2 = By.xpath("//*[@id=\"content\"]/div/div[2]/img");
	By hover_img3 = By.xpath("//*[@id=\"content\"]/div/div[3]/img");
	
	By hover_img1_user = By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5");
	By hover_img2_user = By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5");
	By hover_img3_user = By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5");
	
	By txt_iframe = By.id("tinymce");
	
	 public Floating_Menu(WebDriver driver){
		 this.driver = driver;

	    }
	 UtilityClass utlity = new UtilityClass(driver);
	 public void val_floating_menu(String toptext) throws InterruptedException {
		 Reporter.log("Inside floating menu Method $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	    	
		 utlity.validate_Text(txt_floatingmenu,toptext,driver);
	    
		 utlity.scrolldown(driver);
		 
		 Assert.assertEquals(driver.findElement(By.id("menu")).isDisplayed(), true);
		
	 }
	 
	 public void val_iframes(String toptext) throws InterruptedException {
		 Reporter.log("Inside iframes Method $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		 
		 utlity.validate_Text(txt_floatingmenu,toptext,driver);
	    
		 driver.switchTo().frame("mce_0_ifr");
		 
		 utlity.clear_txt_box(txt_iframe,driver);
		 utlity.enter_text(txt_iframe, driver,"Testing iframes");
		 
		 driver.switchTo().defaultContent();
		 utlity.click_anything(txt_floatingmenu,driver);
		 
		 driver.switchTo().frame("mce_0_ifr");
		 utlity.validate_Text(txt_iframe,"Testing iframes",driver);

	 }
	 public void val_mouse_hover(String toptext) throws InterruptedException {
		 Reporter.log("Inside mouse hover Method $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	    	
		 utlity.validate_Text(txt_floatingmenu,toptext,driver);
	    
		 utlity.mouse_hover(driver,hover_img1);
		 utlity.assert_text(hover_img1_user, "name: user1", driver);
		 
		 utlity.mouse_hover(driver,hover_img2);
		 utlity.assert_text(hover_img2_user, "name: user2", driver);
		 
		 utlity.mouse_hover(driver,hover_img3);
		 utlity.assert_text(hover_img3_user, "name: user3", driver);

	 }

}
