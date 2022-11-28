package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC_CheckBoxTest extends BaseClass {


	@Test
	public void TestCheckbox()
	
	{
		String url = driver.getCurrentUrl();
		driver.get(url + "/checkboxes");
		List <WebElement> AllCheckboxes =  driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(AllCheckboxes.size());
		AllCheckboxes.get(1).click();
		
		for(int i=0; i<AllCheckboxes.size(); i++)
		{ 
			AllCheckboxes.get(i).click();

				if(AllCheckboxes.get(i).isSelected()) 
				{ 
			     	System.out.println(" checkBox is checked ");
					Assert.assertTrue(true);
					AllCheckboxes.get(i).click();
				}
				if(!AllCheckboxes.get(i).isSelected()) 
				{
					System.out.println("checkBox is unchecked "); 
					Assert.assertTrue(false);
			
				} 





		}
	}
}


