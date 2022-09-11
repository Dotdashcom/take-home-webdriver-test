package tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Util.TestBase;
import graphql.Assert;
import pages.MouseHoverPage;

public class MouseHoverTest extends TestBase{
	MouseHoverPage mp=new MouseHoverPage();
	
	@BeforeClass
	public void OpenBrowser() {
		mp.Initialization();
		mp.landingPage();//Navigate to landingPage

	}
	@Test
	public void hoverOnUser1() {
		mp.hoverOnUser1();//perform hover on user 1
		Assert.assertTrue(mp.VerifyhoverOnUser1().contains("name: user1"));//Verify information displayed on user 1

	}
	@Test
	public void hoverOnUser2(){
		mp.hoverOnUser2();//perform hover on user 2
		Assert.assertTrue(mp.VerifyhoverOnUser2().contains("name: user2"));//Verify information displayed on user 2

	}
	@Test
	public void hoverOnUser3() {
		mp.hoverOnUser3();//perform hover on user 3
		Assert.assertTrue(mp.VerifyhoverOnUser3().contains("name: user3"));//Verify information displayed on user 3

	}

	@AfterClass
	public void afterClass() {
		mp.closeBrowser();//Close the Browser
	}
}
