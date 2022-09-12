package base;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.locators.AllLocators;

public class Page {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String browser;
	public static AllLocators locators;
	
	


	public static void initConfiguration(String endpoint) {

		WebDriverManager.chromedriver().setup();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");

		driver = new ChromeDriver(options);

		driver.get(Constants.testsiteurl+endpoint);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.implicitwait, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,10);

	}
	
	
	
	public Page() {
		this.locators = new AllLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,5);
		PageFactory.initElements(factory, this.locators);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void type(WebElement element, String value) {
		String elementName = element.getAttribute("name");
		element.sendKeys(value);
	}

	public static void typeWithEnter(WebElement element, String value) {
		String elementName = element.getAttribute("name");
		element.sendKeys(value, Keys.ENTER);

	}

	public static void select(WebElement dropdown, String value) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
	}

	public static void clickOnLink(List<WebElement> block, int i) {
		String methodName = block.get(i).getText();
		block.get(i).click();

	}
	
	public static String getText(WebElement element) {
		return element.getText();
	}
	

	public static void quitBrowser() {
		driver.quit();
	}

}
