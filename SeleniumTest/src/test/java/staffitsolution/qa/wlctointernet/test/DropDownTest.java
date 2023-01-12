package staffitsolution.qa.wlctointernet.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;

public class DropDownTest extends BaseTest {

	@Test
	public void selDropDownTest() throws InterruptedException {
		driver.get(prop.getProperty("dropdownurl"));
		Thread.sleep(2000);
		WebElement msdpdwn = driver.findElement(By.xpath("//select[@id='dropdown']"));
		// Perform right click operation
		Select sel = new Select(msdpdwn);
		List<WebElement> alloptions = sel.getOptions();
		int count = alloptions.size();
		System.out.println("No of dropdown options:" + count);

		// select the dropdown list
		for (int i = 1; i < count; i++) {
			sel.selectByIndex(i);
			Thread.sleep(2000);
			List<WebElement> dropdownlist = sel.getOptions();
			System.out.println(dropdownlist);

		}
	}
}
