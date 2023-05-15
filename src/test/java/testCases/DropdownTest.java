package testCases;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import pageObjectModel.DropdownPage;
import pageObjectModel.HomePage;

@Test
public class DropdownTest extends BaseTest {
	@Test
	public void selectFirst() {
		HomePage homePage= new HomePage(driver);
		DropdownPage dropDown = homePage.clickDropDown();
		dropDown.dropDownSelect("Option 1");
		assertEquals(dropDown.getSelected(), "Option 1");
	}
	
	@Test
	public void selectSecond() {
		HomePage homePage= new HomePage(driver);
		DropdownPage dropDown = homePage.clickDropDown();
		dropDown.dropDownSelect("Option 2");
		assertEquals(dropDown.getSelected(), "Option 2");
	}
}
