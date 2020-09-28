import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import base.WebLink;
import pages.CheckBoxPage;
import pages.DropDownPage;
import pages.MouseHoverPage;


public class MouseHover_Test extends BaseTest{
	MouseHoverPage page=null;
	
@Test
public void validateOptionOne() {
	page=new MouseHoverPage(driver);
	try {
driver.get(WebLink.mouseHoverPageUrl);
	Assert.assertEquals(page.verifyHoverOver(), true);	
	}
	catch(Exception e) {
		e.getLocalizedMessage();
		Assert.assertTrue(false);
	}
}


}
