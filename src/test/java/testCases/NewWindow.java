package testCases;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.BaseClass;

public class NewWindow extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateNewWindow() throws InterruptedException {
		// locate and click on multiple windows link
		WebElement mltplWndws_link = driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(mltplWndws_link));
		mltplWndws_link.click();

		// verify if multiple windows page is open
		String act_url = driver.getCurrentUrl();
		String exp_url = "http://localhost:7080/windows";
		System.out.println(act_url);
		if (act_url.equals(exp_url)) {
			softassert.assertTrue(true);
		}

		WebElement clickHere_link = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
		clickHere_link.click();
		// return the unique id of parent window
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		// iterate using Iterator
		Iterator<String> I1 = allWindowHandles.iterator();
		// iterate until child window unique id is not equal to parent window unique id
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parentWindow.equals(child_window)) {
				driver.switchTo().window(child_window);
				String act_childWndwTitle = driver.switchTo().window(child_window).getTitle();
				System.out.println(act_childWndwTitle);
				String exp_childWndwTitle = "New Window";
				softassert.assertEquals(act_childWndwTitle, exp_childWndwTitle); // verify command on new window
			}
		}

		softassert.assertAll();

	}

}
