package testcases;

import java.io.IOException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.BrowseData;
import testdata.BaseUrl;

public class DragAndDropTest extends TestBase{
	
	BrowseData data;
	BaseUrl urlvalues;
	public DragAndDropTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {		 
		initialization();		
		data =new BrowseData();
		urlvalues = new BaseUrl();
	}

	@Test
	public void verifyDragAndDrop() throws InterruptedException
	{
		driver.get(urlvalues.url_drag);
		Actions actions = new Actions(driver);
		String beforeDrag = data.column_a_text.getText();
		
		// using clickAndHold , moveToElement methods perform drag and drop operation 
		
		actions.clickAndHold(data.column_a).moveToElement(data.column_b)
		.release().build().perform();
		String afterDrag = data.column_a_text.getText();
		Assert.assertTrue(beforeDrag.equalsIgnoreCase(afterDrag));
		System.out.println("text has been switched");	
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
