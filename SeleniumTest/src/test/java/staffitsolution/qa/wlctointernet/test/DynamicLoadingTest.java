package staffitsolution.qa.wlctointernet.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;


public class DynamicLoadingTest extends BaseTest{
	
	@Test
	public void dynamicLoadingTest() throws InterruptedException 
	{
		By name=By.xpath("//div[@id='finish']");
		
		driver.get(prop.getProperty("dynamicLoadingurl"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button")).click();

		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		String text= wait.until(ExpectedConditions.visibilityOfElementLocated(name)).getText();
		System.out.println(text);
		Assert.assertEquals(text, "Hello World!");
}

}
