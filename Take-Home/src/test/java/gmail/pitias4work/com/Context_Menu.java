package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.library.pitias.Base;

public class Context_Menu extends Base {

	String text = "You selected a context menu";

	
	public void context() {
	
		try {
			driver.get("http://localhost:7080/context_menu");
			System.out.println(driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			Actions act = new Actions(driver);
			WebElement rightclick = driver.findElement(By.cssSelector("#hot-spot"));
			act.contextClick(rightclick).perform();
			Thread.sleep(2000);

			Alert alert = driver.switchTo().alert();
			assertEquals(alert.getText(), text);

			alert.accept();

			Thread.sleep(2000);

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
