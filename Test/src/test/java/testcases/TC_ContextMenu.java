package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContextMenu;

public class TC_ContextMenu extends BaseClass{

	@Test
		public void VerifyContextMenu()
		
		{
			String url = driver.getCurrentUrl();
			driver.get(url + "/context_menu");
			ContextMenu Cm = new ContextMenu(driver);
	        Cm.rightClickOnBox();
	        Cm.assertionOfAlert();
			    }
		
		
		
		
		
		
		
}