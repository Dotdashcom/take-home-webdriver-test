package testCases;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.MouseHoverPage;

public class MouseHoverTest extends BaseTest {
	@Test
	public void mouseHover1() {
		HomePage homePage = new HomePage(driver);
		MouseHoverPage mouseHover = homePage.clickHover();
		assertTrue(mouseHover.moveTo1());	
	}
	@Test
	public void mouseHover2() {
		HomePage homePage = new HomePage(driver);
		MouseHoverPage mouseHover = homePage.clickHover();
		assertTrue(mouseHover.moveTo2());	
	}
	@Test
	public void mouseHover3() {
		HomePage homePage = new HomePage(driver);
		MouseHoverPage mouseHover = homePage.clickHover();
		assertTrue(mouseHover.moveTo3());	
	}
}
