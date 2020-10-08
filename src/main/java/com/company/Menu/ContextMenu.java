package com.company.Menu;

import com.company.Base.BaseObjectClass;
import com.company.Base.BaseUrl;
import com.company.Base.BrowseFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenu {
	
	

	
	@Test
	public void checkContextMenu() throws Exception
	{
		BrowseFactory.setUp();
		
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.contextPageUrl);		
		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		
		Actions actions=new Actions(driver);
		actions.contextClick(baseObjectClass.contextmenu()).perform();
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		System.out.println(text);
		alert.accept();
		
		Assert.assertTrue(text.contains("You selected a context menu"), "Context Menu click");
		Thread.sleep(5000);
		
		BrowseFactory.tearDown();
		
	}
	
	

}
