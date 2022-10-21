package TestScenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CheckBoxesPageObject;
import PageObjects.ContextMenuPageObject;
import PageObjects.DragAndDropPO;
import PageObjects.DropDownPO;
import PageObjects.DynamicContentPO;
import PageObjects.DynamicControlPO;
import PageObjects.DynamicLoadingPO;
import PageObjects.FileDownloadPO;
import PageObjects.FileUploadPO;
import PageObjects.FloatingMenuPO;
import PageObjects.IFramesPO;
import PageObjects.JavaScriptAlertPO;
import PageObjects.JavaScriptErrorPO;
import PageObjects.LoginPO;
import PageObjects.MouseHoverPO;
import PageObjects.NewTabPO;
import PageObjects.NotificationMessagePO;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenarios {

	WebDriver driver;
	String URL= "http://localhost:7080/";
	
		
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		}
	
	@Test (priority=0)
	public void LoginSuccess() {
		driver.get(URL+"login");
		LoginPO page=new LoginPO(driver);
		page.Validusername();
		page.Validpassword();
		page.clicksubmit();
		page.validatesuccessmessage();
	}
	
	@Test 
	public void LoginFailure() {
		driver.get(URL+"login");
		LoginPO page=new LoginPO(driver);
		page.Invalidusername();
		page.Invalidpassword();
		page.clicksubmit();
		page.validatesuccessmessage();
		page.validatefailuremessage();
	}
	
	@Test 
	public void CheckBoxes() {
	driver.get(URL+"checkboxes");
	CheckBoxesPageObject page1=new CheckBoxesPageObject(driver);
	page1.Selectcheckbox();
		
	}
	
	@Test 
	public void ContextMenu() throws InterruptedException {
		driver.get(URL+"context_menu");
		ContextMenuPageObject page2= new ContextMenuPageObject (driver);
		page2.contextmenu();
		page2.validatetext();
	}
	
	@Test 
	public void DragandDrop() throws InterruptedException {
		driver.get(URL+"drag_and_drop");
		DragAndDropPO page3= new DragAndDropPO(driver);
		page3.draganddrop();
	}
	
	@Test 
	public void DropDown() {
		driver.get(URL+"dropdown");
		DropDownPO page4= new DropDownPO(driver);
		page4.dropDown();
	}
	
	@Test 
	public void DynamicContent() {
	driver.get(URL + "dynamic_content ");
	DynamicContentPO page5= new DynamicContentPO(driver);
	page5.dynamicContent();
	}

	@Test 
	public void DynamicControls() {
	driver.get(URL + "dynamic_controls");
	DynamicControlPO page6= new DynamicControlPO(driver);
	page6.dynamicControls();
	}
	
	@Test 
	public void DynamicLoading() {
	driver.get(URL + "dynamic_loading/2");
	DynamicLoadingPO page7= new DynamicLoadingPO(driver);
	page7.dynamicLoading();
	
	}
	
	@Test 
	public void FileUpload() throws InterruptedException {
	driver.get(URL + "upload");
	FileUploadPO page8a= new FileUploadPO(driver);
	page8a.fileUpload();
	}
	
	@Test 
	public void FileDownload() {
	driver.get(URL + "download");
	FileDownloadPO page8b= new FileDownloadPO(driver);
	page8b.fileDownload();
	}
	
	@Test 
	public void FloatingMenu() throws InterruptedException {
	driver.get(URL + "floating_menu");
	FloatingMenuPO page9= new FloatingMenuPO(driver);
	page9.floatingMenu();
	}
	
	@Test 
	public void IFrames() throws InterruptedException {
	driver.get(URL + "iframe");
	IFramesPO page10= new IFramesPO(driver);
	page10.iFrames();
	}
	
	@Test 
	public void MouseHover() throws InterruptedException {
	driver.get(URL + "hovers");
	MouseHoverPO page11= new MouseHoverPO(driver);
	page11.mouseHover();
	}
	
	@Test 
	public void javaScriptAlert() throws InterruptedException  {
	driver.get(URL + "javascript_alerts");
	JavaScriptAlertPO page12= new JavaScriptAlertPO(driver);
	page12.javaScript();
	}
	
	@Test 
	public void javaScriptError() throws InterruptedException  {
	driver.get(URL + "javascript_error");
	JavaScriptErrorPO page13= new JavaScriptErrorPO(driver);
	page13.javaScriptError();
	}
	
	@Test 
	public void NewWindow() throws InterruptedException  {
	driver.get(URL + "windows");
	NewTabPO page14= new NewTabPO(driver);
	page14.NewTab();
	}
	
	@Test 
	public void NotificationMessage()  {
	driver.get(URL + "notification_message_rendered");
	NotificationMessagePO page15= new NotificationMessagePO(driver);
	page15.NotificationMessage();
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	}
