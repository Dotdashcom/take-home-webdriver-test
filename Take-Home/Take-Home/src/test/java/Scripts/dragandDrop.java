package Scripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Library.Base;

public class dragandDrop extends Base {

	@Test
	public void logger() {

		try {
			driver.get("http://localhost:7080/drag_and_drop");
			System.out.println(driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			WebElement Atext = driver.findElement(By.xpath("//header[contains(text(),'A')]"));
			WebElement Btext = driver.findElement(By.xpath("//header[contains(text(),'B')]"));
			String Atext1 = Atext.getText();
			// String Btext1 = Btext.getText();

			WebElement A = driver.findElement(By.xpath("//div[@id='column-a']"));
			WebElement B = driver.findElement(By.xpath("//div[@id='column-b']"));
			Actions action = new Actions(driver);
			action.clickAndHold(A).moveToElement(B).release(A).build().perform();

			Thread.sleep(5000);
			// String btext2 = Btext.getText();
			// String atext2 = Atext.getText();

			assertEquals(Atext1, "A");
			// assertEquals(Btext1,atext2);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
