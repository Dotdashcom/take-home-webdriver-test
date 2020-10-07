package TheInternet.DotDash;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicContent extends  base {

	@Test
	public void dynamicContentTest() throws InterruptedException {
		driver.get(URL + "dynamic_content ");
		String text1 = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().refresh();
		String text2 = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();
		Assert.assertNotEquals(text2, text1);

	}

}
