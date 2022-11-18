package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.NewWindowPage;
import pages.OpenInNewTabPage;

public class OpenInNewTabTest extends TestBaseAssignment{
	
	@Test
	@Parameters({"OpenInNewTabUrl"})
	public void SwicthNewTabAndVerifyTestCase(String OpenInNewTabUrl) throws InterruptedException{
		this.helper.getDriver().get(OpenInNewTabUrl);
		this.helper.maximizeWindows();
		
		OpenInNewTabPage dl = new OpenInNewTabPage(this.helper.getDriver(), helper);
		NewWindowPage nw = new NewWindowPage(this.helper.getDriver());
		
		dl.ClickLink();
		nw.VerifyNewWindowText("New Window");
		
		}

}
