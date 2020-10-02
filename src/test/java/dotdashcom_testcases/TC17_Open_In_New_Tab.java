package dotdashcom_testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC17_Open_In_New_Tab {

	public static WebDriver driver;

	// browser starting method
	@BeforeMethod
	public void BrowserInvoking() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32_v85//chromedriver.exe");
		driver = new ChromeDriver();

		// receiving url to the browser
		driver.get("http://localhost:7080/windows");

		// maximizing window
		driver.manage().window().maximize();
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

	@AfterMethod
	public void teardown() {
		// quit is used as there are 2 tabs opened so closing all the open browsers
		driver.quit();

	}

}
