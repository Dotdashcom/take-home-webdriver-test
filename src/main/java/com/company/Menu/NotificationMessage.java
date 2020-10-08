package com.company.Menu;


import com.company.Base.BaseObjectClass;
import com.company.Base.BaseUrl;
import com.company.Base.BrowseFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessage {

	@Test
	public void checkContextMenu() throws Exception
	{
		BrowseFactory.setUp();
		
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.notificationPageUrl);		
		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		int count=5;
		for(int i=0;i<count;i++)
		{
			baseObjectClass.clickhere().click();
			System.out.println(baseObjectClass.message().getText()+"***");
			
				
		}
		if(baseObjectClass.message().getText().contains("successful"))
		{
			Assert.assertTrue(true,"Successful");
		}
		else if( baseObjectClass.message().getText().contains("unsuccessful"))
		{
			Assert.assertTrue(true,"Unuccessful");
		}
		
		
		Thread.sleep(2000);
		
		BrowseFactory.tearDown();
		
	}
	
}
