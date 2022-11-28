package Test_Cases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.FloatingMenuPage;
import TestBase.BaseTest;

public class FloatingMenuPageTest extends BaseTest {
	FloatingMenuPage floatingMemu;

	public FloatingMenuPageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		floatingMemu = new FloatingMenuPage();
	}

	@Test
	public void floatingMenuTest() {

		// logging into application
		floatingMemu.getUrl();

		// switch to the frame
		floatingMemu.scrollToTheBottomOfThePage();
	}

}