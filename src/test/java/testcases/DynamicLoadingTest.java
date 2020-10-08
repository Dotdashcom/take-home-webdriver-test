package testcases;

import java.io.IOException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;

public class DynamicLoadingTest extends TestBase {
	
	public DynamicLoadingTest() throws IOException {
		super();	
	}
	
	@Test 
	public void verifyDynamicLoading()
	{	
		//Use ExplicitWait here and validate the result
		WebDriverWait wait=new WebDriverWait(driver,20);	
		driver.get(urlvalues.url_dynamicloading);
		data.startButton.click();
		wait.until(ExpectedConditions.invisibilityOf(data.loadingicon));
		String s1 =data.hellotext.getText();
		String s2 = "Hello World!";
		Assert.assertEquals(s1, s2);
		System.out.println("“Hello World!” text is displayed");
	}
}
