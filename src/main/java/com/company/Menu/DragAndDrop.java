package com.company.Menu;


import com.company.Base.BaseObjectClass;
import com.company.Base.BaseUrl;
import com.company.Base.BrowseFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {
	
	@Test
	public void TestDragAndDrop() throws Exception
	{
		
		BrowseFactory.setUp();
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.dragAndDropPageUrl);		
		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		Thread.sleep(5000);
		Actions actions=new Actions(driver);
		actions.dragAndDrop(baseObjectClass.ElementA(), baseObjectClass.ElementB()).perform();
		
		String textBoxOne=baseObjectClass.ElementA().getText();
		String textBoxTwo=baseObjectClass.ElementB().getText();
		if(baseObjectClass.ElementA().getText().equalsIgnoreCase(textBoxTwo) && baseObjectClass.ElementB().getText().equalsIgnoreCase(textBoxOne))
		{
			//Assert.assertTrue(true,"Text is switched");
			System.out.println("Text is switched");
		}
		else
		{
			//Assert.assertTrue(false,"Text is not switched");
			System.out.println("Text is not switched");
		}
		
		BrowseFactory.tearDown();
		
		
	}
	

}
