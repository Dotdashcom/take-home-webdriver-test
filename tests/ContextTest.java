package tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Util.TestBase;
import graphql.Assert;
import pages.ContextPage;
public class ContextTest extends TestBase{
	
	ContextPage cp=new ContextPage(); 
	
	@BeforeClass
	public void openBrowser() {
		cp.Initialization();
		cp.LandingPage();//Navigate to LandingPage
	}
	@Test 
	public void rightClick() {
		cp.rightClickBox();//Right click on the box

	}
	@Test(dependsOnMethods="rightClick")
	public void acceptAlert() {
		
		Assert.assertTrue(cp.AlertText().equals("You selected a context menu"));//Verify Alert Message Text
		cp.acceptAlert();

	}
	@AfterClass
	public void afterClass() {
		cp.closeBrowser();// Close the browser
	}
}




