package dotDashcom.testComponents;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
import dotDashcom.pageObjects.NewTabPage;

public class NewTabTest extends BaseTest{
	NewTabPage newTab;
	
	@Before
	public void setup() throws IOException {

		setup("/windows");
		newTab = new NewTabPage(driver);
	}
	
	@Test
	public void checkNewTab() {
		String newUrl=newTab.openAndSwitchToNewTab();
		Assert.assertEquals(newUrl, "http://localhost:7080/windows/new");
		String title=newTab.checkNewTabText();
		Assert.assertEquals(title, "New Window");
	}
	
}
