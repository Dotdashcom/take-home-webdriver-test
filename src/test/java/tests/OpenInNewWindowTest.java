package tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import PageObjects.OpenInNewWindowPage;
import Utility.InternetWebBaseTest;
import junit.framework.Assert;

public class OpenInNewWindowTest extends InternetWebBaseTest{
	@Test
	public void testOpenInNewWindowTest() throws IOException, InterruptedException {
		driver.get(loadProperties().getProperty("BASE_URL")+"windows");
		OpenInNewWindowPage newwindow=new OpenInNewWindowPage(driver);
		newwindow.clickhere();
		Thread.sleep(2000);
		Set<String> set=driver.getWindowHandles();
		Iterator<String> itr=set.iterator(); 
		String url=itr.next();
		String newurl=itr.next();
		driver.switchTo().window(newurl);
		Assert.assertTrue("New window is not opening",driver.getCurrentUrl().contains("new"));
	}

}
