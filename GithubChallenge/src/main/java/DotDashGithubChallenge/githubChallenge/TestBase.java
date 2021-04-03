package DotDashGithubChallenge.githubChallenge;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

		protected WebDriver driver;

		public TestBase(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		public WebDriver getDriver() {
			return driver;
		}
		

	}
