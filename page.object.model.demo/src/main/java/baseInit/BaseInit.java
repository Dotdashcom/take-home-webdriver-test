package baseInit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseInit {
	protected static WebDriver driver;
	
	public static void openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\KomPatel\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		// driver.get("http://localhost:7080");
	}
	
	public static void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
