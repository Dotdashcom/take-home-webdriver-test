package qa.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import qa.base.TestBase;

public class JavaScriptErrorTest extends TestBase {

	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test 
    public void javaScriptErrorTest() throws InterruptedException {
		
		SoftAssert softAssert = new SoftAssert();
		driver.get(prop.getProperty("baseurl")+"/javascript_error");
		
		String js_error_msg = driver.findElement(By.cssSelector("p")).getText();
		System.out.println(js_error_msg);
		softAssert.assertEquals(js_error_msg, "Cannot read property 'xyz' of undefined.");
		softAssert.assertAll();
	}
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}

}
