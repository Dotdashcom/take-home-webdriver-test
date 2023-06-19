package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.MouseHoverPage;

import static org.testng.Assert.assertTrue;

public class MouseHoverTest extends BaseTest{
    @Test
    public void verifyMouseHover1() {
        HomePage homePage = new HomePage(driver);
        MouseHoverPage mouseHover = homePage.clickHover();
        assertTrue(mouseHover.moveToImage1());
    }
    @Test
    public void verifyMouseHover2() {
        HomePage homePage = new HomePage(driver);
        MouseHoverPage mouseHover = homePage.clickHover();
        assertTrue(mouseHover.moveToImage2());
    }
    @Test
    public void verifyMouseHover3() {
        HomePage homePage = new HomePage(driver);
        MouseHoverPage mouseHover = homePage.clickHover();
        assertTrue(mouseHover.moveToImage3());
    }
}
