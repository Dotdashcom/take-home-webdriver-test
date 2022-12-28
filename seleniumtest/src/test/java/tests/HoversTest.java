package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;
import pages.HoversPage;

public class HoversTest extends GenericPage {
	HoversPage hoversPage;

	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/hovers");
		hoversPage = new HoversPage();
	}

	@Test
	public void tcHovers() throws InterruptedException {
		Assert.assertTrue(hoversPage.getHoversBool());
	}
}