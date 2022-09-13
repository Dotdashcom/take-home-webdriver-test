package tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Util.TestBase;
import pages.CheckBoxesPage;
public class CheckBoxesTest extends TestBase {
	
	CheckBoxesPage cp=new CheckBoxesPage();
	
	@BeforeClass
	  public void OpenBrowser() {
		cp.Initialization(); //Initialize the Browser
		cp.LandingPage();//Navigate to LandingPage
	  }
	@Test
	public void checkBox1() throws InterruptedException {
	
		cp.ClickOnCheckBox1();//click on checkbox1
		Assert.assertTrue(cp.ValidateCheckBox1());// Verify checkbox1 is selected or not		
	}
	@Test
	public void checkBox2() {
		cp.ClickOnCheckBox2();//click on checkbox2
		Assert.assertFalse(cp.ValidateCheckBox2());// Verify checkbox2 is selected or not
	}
	@AfterClass
	public void afterClass() {
		cp.closeBrowser();//Close the Browser
	}
}
