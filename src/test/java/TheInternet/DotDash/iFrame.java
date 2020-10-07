package TheInternet.DotDash;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class iFrame extends base {

	@Test
	public void iFrameTest() throws InterruptedException {
		driver.get(URL + "iframe ");
		driver.switchTo().frame("mce_0_ifr");
		String TextEntered = "Hi I am Testing Iframe";
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys(TextEntered);
		Thread.sleep(1000);
		String TextAppeared = driver.findElement(By.id("tinymce")).getText();
		assertEquals(TextAppeared, TextEntered);
		driver.close();
	}

}
