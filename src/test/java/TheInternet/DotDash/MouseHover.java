package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover extends base {

	@Test
	public void MouseHoverTest() throws InterruptedException {
		driver.get(URL + "hovers ");
		WebElement ProfileIcon = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/img[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(ProfileIcon).build().perform();
		WebElement Info = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
		Thread.sleep(1000);
		assertTrue(Info.isDisplayed());
	}

}
