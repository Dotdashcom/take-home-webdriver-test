package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;
import pages.FloatingMenuPage;

public class FloatingMenuTest extends GenericPage {
	FloatingMenuPage floatingMenuPage;

	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/floating_menu");
		floatingMenuPage = new FloatingMenuPage();
	}

	@Test
	public void tcFloatingMenu() throws InterruptedException {
		Assert.assertTrue(floatingMenuPage.getFloatingMenu());
	}
}