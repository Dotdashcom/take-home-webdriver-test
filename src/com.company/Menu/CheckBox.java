package com.company.Menu;


import com.company.Base.BaseObjectClass;
import com.company.Base.BaseUrl;
import com.company.Base.BrowseFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckBox {
	
	
	@Test
	public void TestCheckBox() throws Exception
	{
		
		BrowseFactory.setUp();
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.checkBoxUrl);		
		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		if(!baseObjectClass.checkbox1().isSelected())
		{
			baseObjectClass.checkbox1().click();
			Assert.assertTrue(baseObjectClass.checkbox1().isSelected(),"Checkbox1 is click\"");
			System.out.println("Checkbox1 is click");
		}
		
		
		if(baseObjectClass.chekbox2().isSelected())
		{
			baseObjectClass.chekbox2().click();
			Assert.assertTrue(!baseObjectClass.chekbox2().isSelected());
			System.out.println("Checkbox2 is click");
		}
		
		
		Thread.sleep(5000);
		BrowseFactory.tearDown();
		
		
		
		
		
		
		
		
	}

}
