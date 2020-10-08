package testcases;

import java.io.IOException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;

public class DynamicControlsTest extends TestBase {
	
	public DynamicControlsTest() throws IOException {
		super();	
	}
	
	@Test
	public void verifyDynamicControls()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		driver.get(urlvalues.url_controls);
		data.removebutton.click();
		
		//use ExplicitWait here on specific condition 
		wait.until(ExpectedConditions.elementToBeClickable(data.addbutton));
		
		String actual = data.textmsg.getText();
		String Expected = "It's gone!";
		Assert.assertEquals(actual, Expected);
		System.out.println("checkbox is gone");
		data.addbutton.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(data.checkbox));
		data.enablebutton.click();
		wait.until(ExpectedConditions.elementToBeClickable(data.textbox));
		String s1 = data.msg1.getText();
		String s2 = "It's enabled!";
		Assert.assertEquals(s1, s2);
		System.out.println("text box is enabled ");
		data.disablebutton.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(data.enablebutton));
		String text1 = data.msg1.getText();
		String text2 = "It's disabled!";
		Assert.assertEquals(text1,text2);
		System.out.println("Textbox is displayed");		
	}
}
