package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.library.pitias.Base;

public class MouseHover extends Base {

	public void mouse() {

		try {
			driver.get("http://localhost:7080/hovers");
			System.out.println(driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

//			Test does a mouse hover on each image.
//			Test asserts that additional information is displayed for each image.
			WebElement user1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
			WebElement user2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
			WebElement user3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
			Actions action = new Actions(driver);
			action.moveToElement(user1).perform();
			WebElement user1info = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5"));
			System.out.println(user1info.getText());
			assertEquals(user1info.getText(), "name: user1");
			Thread.sleep(3000);

			action.moveToElement(user2).perform();
			WebElement user2info = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5"));
			System.out.println(user2info.getText());
			assertEquals(user2info.getText(), "name: user2");

			Thread.sleep(3000);
			action.moveToElement(user3).perform();
			WebElement user3info = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5"));
			System.out.println(user3info.getText());
			assertEquals(user3info.getText(), "name: user3");

			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
