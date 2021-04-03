package DotDashGithubChallenge.githubChallenge;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

		private static WebDriver driver;
			
			private Driver() {
				
			}
			
			public static WebDriver getDriver() {
				
				System.out.println("Instantiating the Chrome browser instance");
					
						WebDriverManager.chromedriver().setup();
						driver = new ChromeDriver();
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						return driver;
			}
			
			
			public static void quitBrowser() {
				System.out.println("quiting the browser");
				if (driver != null) {
					driver.quit();
				}
}
}
