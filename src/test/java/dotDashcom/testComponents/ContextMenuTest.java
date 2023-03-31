package dotDashcom.testComponents;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
import dotDashcom.pageObjects.ContextMenuPage;


public class ContextMenuTest extends BaseTest{
	ContextMenuPage contextMenu;
	
	@Before
	public void setup() throws IOException {
		setup("/context_menu");
		contextMenu=new ContextMenuPage(driver);
	}
	
	
	@Test
	public void rightClick() {
		contextMenu.rightClick();
		String alertMessage=contextMenu.getAlertMessage();
		System.out.println(alertMessage);
		Assert.assertEquals(alertMessage, "You selected a context menu");
	}

}
