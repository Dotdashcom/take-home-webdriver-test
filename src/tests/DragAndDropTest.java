package tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Util.TestBase;
import pages.DragAndDropPage;

public class DragAndDropTest extends TestBase {
	
	DragAndDropPage dp=new DragAndDropPage();
	
	@BeforeClass
	public void OpenBrowser() {
		dp.Initialization();
		dp.LandingPage();
		
	}
	@Test
	public void dragColumnAtoB() {
		dp.dragAndDrop();

	}
	
	@AfterClass
	public void afterClass() {
		dp.closeBrowser();
	}
}
