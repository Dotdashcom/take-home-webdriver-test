package DotDash.E2E;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import pageObjects.TC07_dynamicContentObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

public class TC07_dynamicContentTest extends base{
	@BeforeTest
	public void setup() {
		driver = initializeDriver();
	}

	//first check all the boxes and assert it
	@Test
	public void testDynamicContent(){
		/*	Testing Scenario:
	  		Test that the content changes on each refresh
		 */
		TC07_dynamicContentObject dco = new TC07_dynamicContentObject(driver);
		dco.getdynamicContentLink().click();
		for(int i = 0;i<2;i++) {
			String img1Src = dco.getdynamicContentImg(1).getAttribute("src");
			String img2Src = dco.getdynamicContentImg(2).getAttribute("src");
			String img3Src = dco.getdynamicContentImg(3).getAttribute("src");

			String content1Text = dco.getdynamicContentText(1).getText();
			String content2Text = dco.getdynamicContentText(2).getText();
			String content3Text = dco.getdynamicContentText(3).getText();

			driver.navigate().refresh();
			String newImg1Src = dco.getdynamicContentImg(1).getAttribute("src");
			String newImg2Src = dco.getdynamicContentImg(2).getAttribute("src");
			String newImg3Src = dco.getdynamicContentImg(3).getAttribute("src");

			String newContent1Text = dco.getdynamicContentText(1).getText();
			String newContent2Text = dco.getdynamicContentText(2).getText();
			String newContent3Text = dco.getdynamicContentText(3).getText();

			//comparing image source and contents
			Assert.assertNotEquals(newImg1Src, img1Src);
			Assert.assertNotEquals(newContent1Text, content1Text);
			
			Assert.assertNotEquals(newImg2Src, img2Src);
			Assert.assertNotEquals(newContent2Text, content2Text);
			
			Assert.assertNotEquals(newImg3Src, img3Src);
			Assert.assertNotEquals(newContent3Text, content3Text);
		}

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
