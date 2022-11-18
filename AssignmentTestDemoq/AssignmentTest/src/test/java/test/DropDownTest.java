package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.DropDownPage;

public class DropDownTest extends TestBaseAssignment{
	
	@Test
	@Parameters({"DropDownUrl"})
	public void DropDownTestCase(String DropDownUrl) throws InterruptedException{
		this.helper.getDriver().get(DropDownUrl);
		this.helper.maximizeWindows();
		
		DropDownPage dp = new DropDownPage(this.helper.getDriver(),helper);
		
		dp.slectOption1();
		dp.VerifySelectedText("Option 1");
		
		dp.slectOption2();
		dp.VerifySelectedText("Option 2");		
		
	}
	

}
