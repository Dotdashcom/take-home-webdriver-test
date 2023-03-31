package dotDashcom.testComponents;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
import dotDashcom.pageObjects.MouseHoverPage;

public class MouseHoverTest extends BaseTest{
	MouseHoverPage mouseHover;
	
	@Before
	public void setup() throws IOException {

		setup("/hovers");
		mouseHover = new MouseHoverPage(driver);
	}
	
	@Test
	public void getHoverInformation() {
		String additionalInfo;
		additionalInfo=mouseHover.checkInfoForImage(1);
		Assert.assertEquals(additionalInfo, "name: user1");
		
		additionalInfo=mouseHover.checkInfoForImage(2);
		Assert.assertEquals(additionalInfo, "name: user2");
		
		additionalInfo=mouseHover.checkInfoForImage(3);
		Assert.assertEquals(additionalInfo, "name: user3");
		
		
	}
}
