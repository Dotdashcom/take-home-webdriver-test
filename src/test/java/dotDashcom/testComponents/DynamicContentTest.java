package dotDashcom.testComponents;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import dotDashcom.pageObjects.DynamicContentPage;

public class DynamicContentTest extends BaseTest{
	DynamicContentPage dynamicContent;
	
	@Before
	public void setup() throws IOException {
		setup("/dynamic_content");
		dynamicContent=new DynamicContentPage(driver);
	}
	
	@Test
	public void refreshDynamicContent() {
		
		Assert.assertTrue(dynamicContent.checkChangingContent());
		System.out.println("Dynamic content has changed after refresh 1");
		dynamicContent.refreshPage();
		Assert.assertTrue(dynamicContent.checkChangingContent());
		System.out.println("Dynamic content has changed after refresh 2");
	}
}
