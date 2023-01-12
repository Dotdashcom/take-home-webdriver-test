package staffitsolution.qa.wlctointernet.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;

public class DynamicContentTest extends BaseTest {
	@Test
	public void dynamicContentTest() throws InterruptedException {
		List<String> intialContent = new ArrayList<String>();
		driver.get(prop.getProperty("dynamicContenturl"));
		Thread.sleep(2000);
		By content1 = By.xpath("//div[@class='large-10 columns']");
		List<WebElement> list = driver.findElements(content1);

		for (WebElement webElement : list) {
			intialContent.add(webElement.getText());
		}

		// refresh page
		for (int i = 0; i < 2; i++) {
			driver.navigate().refresh();
		}

		List<WebElement> refreshDatalist = driver.findElements(content1);
		for (int i = 0; i < refreshDatalist.size(); i++) {
			Assert.assertNotEquals(intialContent.get(i), refreshDatalist.get(i).getText());
		}
	}
}
