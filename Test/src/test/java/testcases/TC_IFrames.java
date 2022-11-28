package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.IFrames;

public class TC_IFrames extends BaseClass{

	@Test
	public void VerifyIFrames() throws InterruptedException {

		driver.get("http://localhost:7080/iframe");

		IFrames ifrp = new IFrames(driver);
		ifrp.WritetoIframe("This is the new message for you");
	}

}	      


