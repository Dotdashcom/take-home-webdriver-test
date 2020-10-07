package dotdashcom_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC05_DragAndAdrop extends BaseTest {
	
	@BeforeMethod
	public void BrowserInvoking()
	{

		driver.get("http://localhost:7080/drag_and_drop");
	
	}
	
	@Test
	public void drag_and_drop() throws InterruptedException
	{
		
		WebElement element_A =	driver.findElement(By.xpath("//*[@id='column-a']"));
		 
		 WebElement element_B =	driver.findElement(By.xpath("//*[@id='column-b']"));
		Actions dragdrop = new Actions(driver);
		dragdrop.dragAndDrop(element_A, element_B).build().perform();
		Boolean result = element_A.isDisplayed();
		System.out.println(result);
		
		
		//dragdrop.dragAndDrop(element_B, element_A).build().perform();
		//dragdrop.clickAndHold(element_A).build().perform();
		//dragdrop.moveToElement(element_B).build().perform();
		//dragdrop.release(element_B).build().perform();
		//dragdrop.clickAndHold(element_A).moveToElement(element_B).release(element_B).build().perform();
	
		
	}

}
