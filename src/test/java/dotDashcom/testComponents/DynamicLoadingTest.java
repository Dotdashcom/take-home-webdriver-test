package dotDashcom.testComponents;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import dotDashcom.pageObjects.DynamicLoadingPage;


public class DynamicLoadingTest extends BaseTest{
	
	DynamicLoadingPage dynamicLoading;
	
	@Before
	public void setup() throws IOException {
		setup("/dynamic_loading/2");
		dynamicLoading=new DynamicLoadingPage(driver);
	}
	
	@Test
	public void checkDynamicLoading() {
		String message=dynamicLoading.clickStart();
		Assert.assertEquals(message, "Hello World!");
	}
	
}
