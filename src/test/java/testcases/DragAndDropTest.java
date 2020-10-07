package testcases;

import java.io.IOException;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.TestBase;

public class DragAndDropTest extends TestBase{
	
	public DragAndDropTest() throws IOException {
		super();	
	}
	
	@Test
	public void verifyDragAndDrop() throws InterruptedException
	{
		driver.get(urlvalues.url_drag);
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		
		// using clickAndHold , moveToElement methods perform drag and drop operation 
		actions.clickAndHold(data.column_a).moveToElement(data.column_b).release().build().perform();
			
		SoftAssert sa = new SoftAssert();
        //Validate whether the switch has happened
        sa.assertTrue(data.column_a_text.getText().equals("B") && data.column_b_text.getText().equals("A"));
        sa.assertAll();
	}
}
