package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.library.pitias.Base;

public class DynamicLoading extends Base {


	public void dynamic_Loading() {

		try {
			driver.get("http://localhost:7080/dynamic_loading/2");
			System.out.println(driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			WebElement start = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
			start.click();

			Thread.sleep(2000);
			WebElement finish = driver.findElement(By.cssSelector("#finish"));
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(finish));

			// Assertion
			System.out.println(finish.getText());
			assertEquals(finish.getText(), "Hello World!");

			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
