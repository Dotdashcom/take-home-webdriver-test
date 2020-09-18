package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.library.pitias.Base;

public class DynamicContent extends Base {

	public void dynamic_Content() {

		try {
			driver.get("http://localhost:7080/dynamic_content");
			System.out.println(driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			String locate = "//body//div[@id='content']//div[@id='content']//div[1]//div[1]//img[1]";

			for (int i = 0; i <= 5; i++) {
				driver.navigate().refresh();

				List<WebElement> images = driver.findElements(By.xpath(locate));

				String imageFileName = "/img/avatars/Original-Facebook-Geek-Profile-Avatar-5.jpg";
				for (WebElement image : images) {
					if (image.getAttribute("src").contains(imageFileName)) {
						assertTrue(false);
					}
				}
				Thread.sleep(3000);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
