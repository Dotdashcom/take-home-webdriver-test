package webtests.Reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

  public class GenerateExtentReports extends TestListenerAdapter{

	 ExtentReports extent;  //specify the location of report
	 ExtentTest test;       //what details should be populated in the report
	 ExtentHtmlReporter htmlreporter;
	
  public void onTestStart(ITestResult result) {
	
       String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.SS").format(new Date());
       String repName = "Test-Report-"+timeStamp+".html";
       
		
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"//test-output//"+repName);
		htmlreporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml")); 
		extent = new ExtentReports();
		
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("HostName","LocalHost");
		extent.setSystemInfo("Environment","Docker");
		extent.setSystemInfo("User Name","Ruchi");
     }
  
	public void onTestSuccess(ITestResult res) {
		test= extent.createTest(res.getName());
		test.log(Status.PASS,MarkupHelper.createLabel(res.getName(), ExtentColor.GREEN));		
	}
	
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		
		String screenshotPath= System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		File fl= new File(screenshotPath);
		if (fl.exists()) {
			try {
				test.fail("Screenshot is below:"+ test.addScreenCaptureFromPath(screenshotPath));
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			}
		
		}
	
	public void onTestSkipped(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.BLUE)); 
	}
	
	@AfterTest
	public void endreport() {
		
		extent.flush();
	}
		
		
		
	
}

	
