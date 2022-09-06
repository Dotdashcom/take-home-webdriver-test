package pages.Tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import pages.Driver;
import pages.DynamicLoading;

public class TC8_DynamicLoading2 extends Driver {

	@Before
	public void setUp() throws Exception {
		Driver.Initialize();
	}

	@After
	public void tearDown() throws Exception {
		Driver.cleanup();
	}
	

	@Test
	public void test() {
		DynamicLoading.NavigateToDynamicLoadingPage();
		DynamicLoading.ClickStartButton();
		Assert.assertTrue(DynamicLoading.IsHelloWorldVisible().contains("Hello World!"));
	}

}
