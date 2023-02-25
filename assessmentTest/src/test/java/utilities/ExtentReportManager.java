package utilities;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext){		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		repName = "TestExecution-Report-"+timeStamp+".html";
				
		htmlReporter = new ExtentHtmlReporter(".\\reports\\"+repName);//specify location of the report
				
		htmlReporter.config().setDocumentTitle("assessmentTest Automation Report"); // Tile of report
		htmlReporter.config().setReportName("assessmentTest Functional Testing"); // name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Shoabna Govindaraju");
	}
	
	public void onTestSuccess(ITestResult result){
		test = extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.PASS, "Test Passed Successfully without any failures");
		String screenshotPath=System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png";
		try {
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot	
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void onTestFailure(ITestResult result){
		test = extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
					
		String screenshotPath=System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png";
		try {
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot	
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void onTestSkipped(ITestResult result){
		test = extent.createTest(result.getName()); // create new entry in th report
		test.log(Status.SKIP, "Test Failed");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext testContext){
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}
	
}
