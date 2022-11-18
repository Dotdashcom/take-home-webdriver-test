package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FloatingMenuPage;

public class FloatingMenuTest extends TestBaseAssignment {
	
	
	@Test
	@Parameters({"FloatingMenuUrl"})
	public void FloatingMenuTestCase(String FloatingMenuUrl) throws InterruptedException{
		this.helper.getDriver().get(FloatingMenuUrl);
		this.helper.maximizeWindows();
		
		FloatingMenuPage fm = new FloatingMenuPage(this.helper.getDriver());
		
		helper.ScrollDown();
		fm.isMenuDisplayed();
		
		
	}

}
