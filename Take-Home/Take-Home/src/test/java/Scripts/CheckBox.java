package Scripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Library.Base;

public class CheckBox extends Base{


	@Test
	public void logger() {

		try {
			driver.get("http://localhost:7080/checkboxes");
			System.out.println(driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			WebElement checkbox1 = driver.findElement(By.xpath("//body//input[1]"));
			WebElement checkbox2 = driver.findElement(By.xpath("//body//input[2]"));

			if (checkbox1.isSelected()) {
				System.out.println("The checkbox 1 is selected");
			} else {
				checkbox1.click();
				System.out.println("The checkbox 1 is clicked");
			}

			if (checkbox2.isSelected()) {
				System.out.println("The checkbox 2 is selected");
			} else {
				checkbox2.click();
				System.out.println("The checkbox 2 is clicked");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}