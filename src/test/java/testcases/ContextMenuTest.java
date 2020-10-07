package testcases;

import java.io.IOException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;

public class ContextMenuTest extends TestBase{

	public ContextMenuTest() throws IOException {
		super();	
	}
	
	@Test
	public void verifyContextMenu()
	{
		driver.get(urlvalues.url_ContextMenu);
		
		//using Actions class perform right  click operation 
		Actions actions = new Actions(driver);
		actions.contextClick(data.contextMenu).build().perform();
		
		//switching the Webdriver to alert mode 
		String alertmsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String expectedmsg = "You selected a context menu";
		Assert.assertEquals(alertmsg, expectedmsg);
		System.out.println("successfully right click on ContextMenu");
	}	
}
