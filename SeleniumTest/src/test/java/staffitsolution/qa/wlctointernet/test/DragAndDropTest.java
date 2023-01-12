package staffitsolution.qa.wlctointernet.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;

public class DragAndDropTest extends BaseTest {

	@Test
	public void draganddrop() throws InterruptedException {
		driver.get(prop.getProperty("draganddropurl"));
		Thread.sleep(2000);

		Thread.sleep(2000);
		WebElement a = driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement b = driver.findElement(By.xpath("//div[@id='column-b']"));

		int x = b.getLocation().x;
		int y = b.getLocation().y;

		Actions actions = new Actions(driver);
		actions.moveToElement(a).pause(Duration.ofSeconds(20)).clickAndHold(a).pause(Duration.ofSeconds(20))
				.moveByOffset(x, y).moveToElement(b).moveByOffset(x, y).pause(Duration.ofSeconds(1)).release().build()
				.perform();

		String Box2 = a.getText();
		System.out.println("Text for source is:" + Box2);
//			Assert.assertEquals(Box2, Box2);
	}
}
