package dotdashcom_testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC17_Open_In_New_Tab extends BaseTest{

	// browser starting method
	@BeforeMethod
	public void BrowserInvoking() {

		// receiving url to the browser
		driver.get("http://localhost:7080/windows");
	}

	@Test
	public void new_tab() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// getting parent window handle
		String parentWindow = driver.getWindowHandle();

		// Clicking on the Google link
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();

		// get all the windows
		Set<String> allWindows = driver.getWindowHandles();

		// No of windows=2 including parent
		// System.out.println("No of windows or tabs after clicking: " +
		// allWindows.size());
		// removing parent window,
		allWindows.remove(parentWindow);

		Iterator<String> ite = allWindows.iterator();

		// So now Set contains only new tab window only,so switch to it
		driver.switchTo().window((String) ite.next());
		WebElement new_tab_ele = driver.findElement(By.tagName("h3"));
		String new_tab_txt = new_tab_ele.getText();
		System.out.println("Text present in new tab is: " + new_tab_txt);
		Assert.assertEquals(new_tab_txt, "New Window");
	}

}
