package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BaseTest;

public class CheckBoxesPage extends BaseTest {

	private By chkBoxes = By.cssSelector("input[type='checkbox']");

	public void checkBoxesAndAssert() {
		List<WebElement> checkBoxes = driver.findElements(chkBoxes);
		for (WebElement chkbox : checkBoxes) {
			if (!chkbox.isSelected()) {
				chkbox.click();
				Assert.assertTrue(chkbox.isSelected());
			}
		}
	}
	
	public void uncheckBoxesAndAssert() {
		List<WebElement> checkBoxes = driver.findElements(chkBoxes);
		for (WebElement chkbox : checkBoxes) {
			if (chkbox.isSelected()) {
				chkbox.click();
				Assert.assertTrue(!chkbox.isSelected());
			}
		}
	}

}
