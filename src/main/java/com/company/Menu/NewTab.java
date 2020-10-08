package com.company.Menu;

import com.company.Base.BaseObjectClass;
import com.company.Base.BaseUrl;
import com.company.Base.BrowseFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class NewTab {

	@Test
	public void checkContextMenu() throws Exception
	{
		BrowseFactory.setUp();
		
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.openNewTabPageUrl);		
		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		String selectnewTab=Keys.chord(Keys.CONTROL,Keys.RETURN);
		baseObjectClass.linkC().sendKeys(selectnewTab);
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		String text=driver.findElement(By.xpath("/html/body/div/h3")).getText();
		System.out.println(text);
		
		Assert.assertTrue(text.contains("New Window"));
		
		Thread.sleep(5000);
		
		BrowseFactory.tearDown();
		
	}
	
}
