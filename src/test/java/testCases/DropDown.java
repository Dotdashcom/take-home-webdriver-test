package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class DropDown extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateDropDown() throws InterruptedException {
		// locate and click on drop down link
		WebElement drpdwn_link = driver.findElement(By.xpath("//a[contains(text(),'Dropdown')]"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(drpdwn_link));
		drpdwn_link.click();

		// verify if drop down page is open
		String act_url = driver.getCurrentUrl();
		String exp_url = "http://localhost:7080/dropdown";
		System.out.println(act_url);
		if (act_url.equals(exp_url)) {
			softassert.assertTrue(true);
		}

		WebElement drpDwnList = driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select sel = new Select(drpDwnList);
		sel.selectByIndex(1);
		Thread.sleep(1000);
		// get text of selected option
		String act_selOption1 = sel.getFirstSelectedOption().getText();
		String exp_selOption1 = "Option 1";
		System.out.println("Selected option 1 text is " + act_selOption1);
		// verify option 1 is selected
		softassert.assertEquals(act_selOption1, exp_selOption1);

		sel.selectByIndex(2);
		Thread.sleep(1000);
		String act_selOption2 = sel.getFirstSelectedOption().getText();
		String exp_selOption2 = "Option 2";
		System.out.println("Selected option 1 text is " + act_selOption2);
		// verify option 1 is selected
		softassert.assertEquals(act_selOption2, exp_selOption2);

		softassert.assertAll();

	}

}
