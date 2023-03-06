package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

@Listeners(reportingUtils.TestListener.class)
public class BasicTestConfiguration {

	WebDriver driver;
	Properties p;
	ExtentReports extent;
	ExtentTest test;


	@BeforeSuite
	public void readProps() throws IOException {
		p = new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\Rohan\\eclipse-workspace\\webdriverTesting\\configuration.properties");
		p.load(file);
		
	}

	@BeforeMethod
	public void setup() throws IOException {

		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver.get(p.getProperty("baseUrl"));


		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest(getClass().getSimpleName());

	}

	@AfterMethod
	public void teardown() {

		driver.close();
		extent.flush();
	}

}
