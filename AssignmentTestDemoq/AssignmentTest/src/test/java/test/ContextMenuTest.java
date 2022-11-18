package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.ContextMenuPage;

public class ContextMenuTest extends TestBaseAssignment{


	@Test
	@Parameters({"ContextMenuUrl"})
	public void ContextMenuTestCase(String ContextMenuUrl) throws InterruptedException{
		this.helper.getDriver().get(ContextMenuUrl);
		this.helper.maximizeWindows();

		ContextMenuPage cp =new ContextMenuPage(this.helper.getDriver(),helper);

		cp.rightClickContextMenu();
		cp.alertText();
		cp.VerifyRightClick();

	}

}
