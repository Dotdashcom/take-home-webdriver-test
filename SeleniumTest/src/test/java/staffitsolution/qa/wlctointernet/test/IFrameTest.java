package staffitsolution.qa.wlctointernet.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;

public class IFrameTest extends BaseTest{

	@Test
	public void iFrameTest() throws InterruptedException 
	{
		driver.get(prop.getProperty("iframeurl"));
		Thread.sleep(2000);
		By iframeloc = By.xpath("//iframe[@id='mce_0_ifr']");
		By textContent = By.xpath("//body[@id='tinymce']");
		String inputString = "This is an iframe content space.";
				
		driver.switchTo().frame(driver.findElement(iframeloc)).findElement(textContent).clear();
		driver.findElement(textContent).sendKeys("This is an iframe content space.");
		String outputString = driver.findElement(textContent).getText();
		System.out.println("Text for iframe is:" + outputString);
		Assert.assertEquals(inputString, outputString);
		
	}
}
