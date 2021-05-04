package com.arthi.automation.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arthi.automation.reporters.ExtentTestManager;
import com.arthi.automation.utils.RestApiHelper;

/**
 * 
 * @author Arthina Kumar
 *
 */
public class TestBase {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);
    
	protected WebDriver driver;
	private Boolean isWebTesting = Boolean.TRUE;
	private String browserType;
	protected String downloadDir;
	
	public TestBase() {
		// TODO: Load the Test Properties
	}

	protected String getBearerToken(final Map<String, Object> request, final String ServiceAPIUrl) {
		RestApiHelper restApiHelper = new RestApiHelper();
		Response response = restApiHelper.post(ServiceAPIUrl, request, true);
		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
		JsonPath jsonPathEvaluator = response.jsonPath();
		final String bearerToken = jsonPathEvaluator.get("token");
		System.out.println("token from Response " + bearerToken);
		return bearerToken;
	}
		
	protected void assertContains(final String actualObj, final String expectedObj) {
		ExtentTestManager.logInfo("Validating the Actual: " + actualObj + " contains Expected: " + expectedObj);
		Assert.assertTrue(actualObj.contains(expectedObj));
	}
	
	protected void assertContainsAll(final String actualObj, final String... expectedObj) {
		ExtentTestManager.logInfo("Validating the Actual: " + actualObj + " contains Expected: " + expectedObj);
		for(int i=0; i< expectedObj.length; i++) {
			Assert.assertTrue(actualObj.contains(expectedObj[i]), expectedObj[i]);
		}
	}
		
	protected void assertEquals(final Object actualObj, final Object expectedObj) {
		try {
			Assert.assertEquals(actualObj, expectedObj);
			ExtentTestManager.logInfo("Validated the Actual: " + actualObj + " equals Expected: " + expectedObj);
		}
		catch(AssertionError ae) {
			ExtentTestManager.logFatal("Failed on Validation: " + ae.getMessage());
			throw ae;
		}
	}
	
	protected void assertNotNull(Object actualValue) {
		ExtentTestManager.logInfo("Validating the " + actualValue + "is NOT NULL");
		Assert.assertNotNull(actualValue);
	}
	
	private void setDriver(String browserType, String downloadDir) {
		switch (browserType) {
		case "Chrome":
			driver = initChromeDriver(downloadDir);
			break;
		case "Firefox":
			driver = initFirefoxDriver();
			break;
        case "Safari":
        	driver = initSafariDriver();
        	break;
        case "InternetExplorer":
        	WebDriverManager.iedriver().setup();
        	driver = new InternetExplorerDriver();
			break;
        case "Opera":
        	WebDriverManager.operadriver().setup();
        	driver = new OperaDriver();
        	//TO-DO
        	break;
        case "Edge":
        	WebDriverManager.edgedriver().setup();
        	driver = new EdgeDriver();
        	//TO-DO
        	break;
		default:
			LOGGER.info("given browser:{} is invalid, Launching Chrome as browser of choice..", browserType);
			driver = initChromeDriver(downloadDir);
		}
	}

	private WebDriver initChromeDriver(final String downloadDir) {
		ChromeOptions options =  new ChromeOptions();
		if (StringUtils.isNotBlank(downloadDir)) {
			LOGGER.info("Launching google chrome with download Dir: {}", downloadDir);
			File folder = new File(downloadDir);
			Map<String, Object> prefs = new HashMap<String, Object>();
		    prefs.put("profile.default_content_settings.popups", 0);
			prefs.put("download.default_directory", folder.getAbsolutePath());			
			options.setExperimentalOption("prefs", prefs);
		}
		
		LOGGER.info("Launching google chrome with new profile..");
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;		
	}

	private WebDriver initFirefoxDriver() {
		LOGGER.info("Launching Firefox browser..");
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		options.setCapability("marionette", true);
    	WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.navigate().to(appURL);
		return driver;
	}
	
	private WebDriver initSafariDriver() {
		LOGGER.info("Launching apple safari with new profile..");
		//System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.navigate().to(appURL);
		return driver;
	}

	@BeforeSuite
	@Parameters("browser")
	public void initSuite(ITestContext testContext, @Optional("Chrome") final String browserType) {
		final String otherHeader = isWebTesting ? "-" + browserType : ""; 
		ExtentTestManager.startReport(testContext.getSuite().getName() + otherHeader);
	}
	
	@Parameters({"isWebAutomation", "browser", "downloadDir"})
	@BeforeClass
	public void setUp(ITestContext testContext, @Optional("true") String isWebAutomation, @Optional("Chrome") final String browserType, @Optional("./src/test/resources/ToDownload") final String downloadDir) {
		this.browserType = browserType;
		this.isWebTesting = Boolean.valueOf(isWebAutomation);
		this.downloadDir = downloadDir;
		if (isWebTesting) {
			try {
				setDriver(this.browserType, this.downloadDir);
				testContext.setAttribute("driver", this.driver);
			} catch (Exception e) {
				LOGGER.error("Error: {}", e.getMessage(), e);
			}
		}
		ExtentTestManager.createTest(this.getClass().getSimpleName());
	}

	@BeforeMethod
	public void initTest(ITestContext testContext, Method method, final Object[] dataDrivenTestName) {
		final String testName = dataDrivenTestName.length > 0 ? method.getName() + "_" + ObjectUtils.toString(dataDrivenTestName[1], "EMPTY") : method.getName();
		Test test = method.getAnnotation(Test.class);
		final String testDescription = test.description();
		
		LOGGER.info("$$$$$$$ Initializing the Extent Report as: {} ({})", testName, testDescription);
		ExtentTestManager.startTest(this.getClass().getSimpleName(), testName, testDescription);		
	}
	
	@AfterMethod
	public void stopReport() {
		LOGGER.info("Extent Reporter getting flushed..");
		ExtentTestManager.endTest();
	}
	
	@AfterClass
	public void tearDown() {

		if (isWebTesting) {
			LOGGER.info("Web Driver getting cleaned up..");
			this.driver.quit();
			LOGGER.info("Web Driver cleaned up successfully.");
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}