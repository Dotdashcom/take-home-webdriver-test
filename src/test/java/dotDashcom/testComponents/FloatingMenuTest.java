package dotDashcom.testComponents;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dotDashcom.pageObjects.FloatingMenuPage;

public class FloatingMenuTest extends BaseTest {
	FloatingMenuPage floatingMenu;

	@Before
	public void setup() throws IOException {

		setup("/floating_menu");
		floatingMenu = new FloatingMenuPage(driver);
	}
	
	@Test
	public void checkFloatingMenu() {
		//before scrolling down
		Assert.assertTrue(floatingMenu.checkFloatingMenu());
		floatingMenu.scrollDown();
		//after scrolling down
		Assert.assertTrue(floatingMenu.checkFloatingMenu());
	}
}
