package staffitsolution.qa.wlctointernet.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;

public class CheckBoxesTest extends BaseTest {

	@Test(priority = 1)
	public void selCheckBoxTest() throws InterruptedException {
		driver.get(prop.getProperty("loginurlchkbox"));
		Thread.sleep(2000);
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

		// Select checkboxes
		for (int i = 0; i < checkboxes.size(); i++) {
			if (checkboxes.get(i).isDisplayed() && checkboxes.get(i).isEnabled()) {
				// checkboxes.clear();
				if (!checkboxes.get(i).isSelected()) {
					checkboxes.get(i).click();
				}
			}

		}
		System.out.println("Checked all Boxes..");
		Assert.assertTrue(checkboxes.get(0).isSelected());
		Assert.assertTrue(checkboxes.get(1).isSelected());

		// Deselect checkboxes
		for (int i = 0; i < checkboxes.size(); i++) {
			if (checkboxes.get(i).isDisplayed() && checkboxes.get(i).isEnabled()) {
				if (checkboxes.get(i).isSelected()) {
					checkboxes.get(i).click();
				}
			}

		}
		System.out.println("Unchecked all Boxes..");
		Assert.assertTrue(!checkboxes.get(0).isSelected());
		Assert.assertTrue(!checkboxes.get(1).isSelected());
	}

}
