package DotDash.E2E;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageObjects.TC017_multipleWindowObject;
import java.util.Iterator;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

public class TC017_multipleWindowTest2 extends base{
	@BeforeTest
	public void setup() {
		driver = initializeDriver();
	}

	//first check all the boxes and assert it
	@Test
	public void testDynamicContent() throws InterruptedException{
		TC017_multipleWindowObject mwo = new TC017_multipleWindowObject(driver);
		mwo.getWindowLink().click();
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> IT = s.iterator();
		while(IT.hasNext()){
			String child_window=IT.next();
			if(!parent.equals(child_window)){
				driver.switchTo().window(child_window);
				AssertJUnit.assertEquals(mwo.getWindow2Text().getText(), "New Window");
			}
		}
		driver.switchTo().window(parent);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
