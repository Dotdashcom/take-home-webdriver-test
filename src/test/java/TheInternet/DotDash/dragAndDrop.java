package TheInternet.DotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class dragAndDrop extends base {

	@Test
	public void DragAndDropTest() throws InterruptedException {
		driver.get(URL + "drag_and_drop");
		WebElement A = driver.findElement(By.id("column-a"));
		WebElement B = driver.findElement(By.id("column-b"));
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.clickAndHold(A).moveToElement(B).release().build().perform();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='column-a']/header")).getText(), "B");
		

	}
}
