package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.MouseHoverPage;

public class MouseHoverTest extends TestBaseAssignment {
	
	@Test
	@Parameters({"MouseHoverUrl"})
	public void MouseHoverAndTextVerificationTestCase(String MouseHoverUrl) throws InterruptedException{
		this.helper.getDriver().get(MouseHoverUrl);
		this.helper.maximizeWindows();
		
		MouseHoverPage dl = new MouseHoverPage(this.helper.getDriver());
		
		dl.HoverUserImage(0);
		dl.VerifyUserName(0, "name: user1");
		
		}

}
