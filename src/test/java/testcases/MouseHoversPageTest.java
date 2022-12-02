package testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.MouseHoverPage;
import testbase.TestBase;

public class MouseHoversPageTest {
	WebDriver driver;
	MouseHoverPage mouseHoverPage;

	@Test(description = "User is able to hover all images")
	public void mouseHoversTest() {
		List<String> actualResult = mouseHoverPage.hoverAllImages().getUsersList();
		List<String> expectedResult = new ArrayList<>(Arrays.asList("name: user1", "name: user2", "name: user3"));
		Boolean matchResult = actualResult.equals(expectedResult);
		Assert.assertTrue(matchResult);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = TestBase.getInstance();
		mouseHoverPage = new MouseHoverPage(driver);
		mouseHoverPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}