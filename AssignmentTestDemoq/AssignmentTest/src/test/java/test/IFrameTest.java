package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.IFramePage;

public class IFrameTest extends TestBaseAssignment{
	
	@Test
	@Parameters({"IFrameUrl"})
	public void IFrameAndTextEditorTextTestCase(String IFrameUrl) throws InterruptedException{
		this.helper.getDriver().get(IFrameUrl);
		this.helper.maximizeWindows();
		
		IFramePage dl = new IFramePage(this.helper.getDriver());
		
		dl.ClickCloseLabel();
		dl.EnterTextEditor("This is From Anurag the Tester");
		dl.VerifyText("This is From Anurag the Tester");
		
		}

}
