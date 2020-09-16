package com.dotDash.DotDash;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class Hooks {
	
	MainDriver md; 
	WebDriver driver;
	LoginPageFactory lpf;
	LoginHomePageFactory hpf;
	CheckBoxFactory cbf;
	ContextPageFactory cpf;
	DragAndDrop dad;
	DropDownPage ddp;
	DynamicContentPage dcp;
	DynamicControlPage dcop;
	DynamicLoadingPage dlp;
	FIleUploadPage fup;
	FIleDownloadPage fdp;
	FloatingMenuPage fmp;
	JavaScrptAlertPage jsap;
	OpenNewTabPage ontp;
	NotificationPage np;
	IFramePage ip;
	MouseHoverPageFactory mhpf;
	SoftAssert sf;
	String actual;
	String expected;
	
	@BeforeMethod
	public void setUp() {
		
		md = new MainDriver(driver);
		driver = md.openBrowserNS("chrome");
		lpf = new LoginPageFactory(driver);
		hpf = new LoginHomePageFactory(driver);
		cbf = new CheckBoxFactory(driver);
		cpf = new ContextPageFactory(driver);
		dad = new DragAndDrop(driver);
		ddp = new DropDownPage(driver);
		dcp = new DynamicContentPage(driver);
	   dcop = new DynamicControlPage(driver);
	    dlp = new DynamicLoadingPage(driver);
	    fup = new FIleUploadPage(driver);
	    fdp = new FIleDownloadPage(driver);
	    fmp = new FloatingMenuPage(driver);
	   jsap = new JavaScrptAlertPage(driver);
	   ontp = new OpenNewTabPage(driver);
	   	 np = new NotificationPage(driver);
	   	 ip = new IFramePage(driver);
	   mhpf = new MouseHoverPageFactory(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
		
	}
}
