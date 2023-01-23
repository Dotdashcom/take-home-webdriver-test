package TestComponents;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listeners extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		String path = System.getProperty("user.dir") + "\\Report\\report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Raman Selenium Test Repprt");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.createTest(result.getMethod().getMethodName());
	}

}
