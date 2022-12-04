package dashtest;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainUtils.UtilityClass;
import pages.CheckBoxes;
import pages.ContextMenu;
import pages.Drag_and_Drop;
import pages.Dropdown;
import pages.Dynamicdata;
import pages.Files;
import pages.Floating_Menu;
import pages.Window_new;
import pages.javascripts_alerts;
import pages.login;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;


public class MainScripts {
	

	WebDriver driver;
	ChromeOptions chromeOptions;

	login ln;
	CheckBoxes chkbx;
	ContextMenu contxtMenu;
	Drag_and_Drop dnd;
	Dropdown drpdwn;
	Dynamicdata dynmic;
	Files files;
	Floating_Menu floatingmenu;
	javascripts_alerts jsalerts;
	Window_new newWindow;
	
	public String downloadPath = System.getProperty("user.dir") + "\\test";
	
//	public MainScripts(WebDriver driver) {
//		this.driver = driver;
//	}

	@BeforeMethod
	public void beforeMethod() {
		
		chromeOptions = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("download.default_directory", downloadPath);
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
	}
	
	@Test(enabled = true)
	public void loginSuccess() throws InterruptedException {
		ln = new login(driver);
		System.out.println("Navigating to the page: "+UtilityClass.configReader("url_login"));
		driver.get(UtilityClass.configReader("url_login"));
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "The Internet");
		System.out.println(UtilityClass.configReader("userid"));
		Thread.sleep(5000);
		String user=UtilityClass.configReader("userid");
		String password = UtilityClass.configReader("password");
		ln.enterCredentials(user,password, "Login Page");
		ln.validate_login("You logged into a secure area!\n" + 
				"×");		
	}
	
	@Test(enabled = true)
	public void loginFailed() throws InterruptedException {
		ln = new login(driver);
		System.out.println("Navigating to the page");
		driver.get(UtilityClass.configReader("url_login"));
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "The Internet");
		Thread.sleep(5000);
		String user=UtilityClass.configReader("userid");
		String password = UtilityClass.configReader("wrongpassword");
		ln.enterCredentials(user,password, "Login Page");
		ln.validate_login("Your password is invalid!\n" + 
				"×");
	}
	
	@Test(enabled = true)
	public void checkbox() throws InterruptedException {
//		Test checks and unchecks checkboxes.
//		Test uses assertions to make sure boxes were properly checked and unchecked.
		chkbx = new CheckBoxes(driver);
		driver.get(UtilityClass.configReader("url_checkboxes"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "The Internet");
		Thread.sleep(5000);
		chkbx.checkbox("Checkboxes");
		chkbx.uncheckbox("Checkboxes");
		
	}
	
	@Test(enabled = true)
	public void contextMenu() throws InterruptedException {
//		Test right clicks on the context menu.
//		Test asserts the alert menu text.
		contxtMenu = new ContextMenu(driver);
		driver.get(UtilityClass.configReader("url_ContestMenu"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "The Internet");
		Thread.sleep(5000);
		contxtMenu.validateContextMenu("Context Menu");
		
		
	}
	
	@Test(enabled = true)
	public void dragAndDrop() throws InterruptedException {
//		Test drags element A to element B.
//		Test asserts that the text on element A and B are switched.
		dnd = new Drag_and_Drop(driver);
		driver.get(UtilityClass.configReader("url_drag_and_drop"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "The Internet");
		Thread.sleep(5000);
		dnd.drag_n_drop("Drag and Drop");
		
	}
	
	@Test(enabled = true)
	public void dropdown() throws InterruptedException {
//		Test selects Option 1 and Option 2 from the drop down menu.
//		Test asserts Option 1 and Option 2 are selected.
		drpdwn = new Dropdown(driver);
		driver.get(UtilityClass.configReader("url_dropdown"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "The Internet");
		Thread.sleep(5000);
		drpdwn.select_dropdown("Dropdown List");
	}
	
	@Test(enabled = true) // not completed yet
	public void dynamicContent() throws InterruptedException {
//		Test refreshes the page a couple of times.
//		Test asserts that the content changes on each refresh.
		dynmic = new Dynamicdata(driver);
		driver.get(UtilityClass.configReader("url_dynamic_content"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "The Internet");
		Thread.sleep(5000);
		dynmic.dynamic_content("Dynamic Content");
	}
	
	@Test(enabled = true)
	public void dynamicControl() throws InterruptedException {
//		Test clicks on the Remove Button and uses explicit wait.
//		Test asserts that the checkbox is gone.
//		Test clicks on Add Button and uses explicit wait.
//		Test asserts that the checkbox is present.
//		Test clicks on the Enable Button and uses explicit wait.
//		Test asserts that the text box is enabled.
//		Test clicks on the Disable Button and uses explicit wait.
//		Test asserts that the text box is disabled.
		dynmic = new Dynamicdata(driver);
		driver.get(UtilityClass.configReader("url_dynamic_controls"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "The Internet");
		Thread.sleep(5000);
		dynmic.dynamic_Control("Dynamic Controls");
	}
	
	@Test(enabled = true)
	public void dynamicloading() throws InterruptedException {
//		Test clicks the start button and uses explicit wait.
//		Test asserts that “Hello World!” text is displayed.
		dynmic = new Dynamicdata(driver);
		driver.get(UtilityClass.configReader("url_dynamic_loading"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "The Internet");
		Thread.sleep(5000);
		dynmic.dynamic_loading("Dynamically Loaded Page Elements");
	}
	
	@Test(enabled = true)
	public void fileDownload() throws InterruptedException {
//		Test clicks on the file.
//		Test asserts that the file is downloaded.
		files = new Files(driver);
		driver.get(UtilityClass.configReader("url_download"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "The Internet");
		Thread.sleep(5000);
		files.file_Download("File Downloader");
	}
	
	@Test(enabled = true)
	public void fileUpload() throws InterruptedException {
//		Test uses Upload Button or Drag and Drop to upload a file.
//		Test asserts that the file is uploaded.
		files = new Files(driver);
		driver.get(UtilityClass.configReader("url_upload"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "The Internet");
		Thread.sleep(5000);
		files.file_Upload("File Uploader");
	}
	
	@Test(enabled = true)
	public void floatingMenu() throws InterruptedException {
//		Test scrolls the page.
//		Test asserts that the floating menu is still displayed.
		floatingmenu = new Floating_Menu(driver);
		driver.get(UtilityClass.configReader("url_floating_menu"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "The Internet");
		Thread.sleep(5000);
		floatingmenu.val_floating_menu("Floating Menu");
	}
	
	@Test(enabled = true)
	public void iframetest() throws InterruptedException {
//		Test switches to Iframe and types some text.
//		Test asserts that the typed text is as expected.
		floatingmenu = new Floating_Menu(driver);
		driver.get(UtilityClass.configReader("url_iframe"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "The Internet");
		Thread.sleep(5000);
		floatingmenu.val_iframes("An iFrame containing the TinyMCE WYSIWYG Editor");
		
	}
	@Test(enabled = true)
	public void mouseHover() throws InterruptedException {
//		Test does a mouse hover on each image.
//		Test asserts that additional information is displayed for each image.
		floatingmenu = new Floating_Menu(driver);
		driver.get(UtilityClass.configReader("url_hovers"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "The Internet");
		Thread.sleep(5000);
		floatingmenu.val_mouse_hover("Hovers");
	}
	
	@Test(enabled = true)
	public void javaScriptAlerts() throws InterruptedException {
//		Test Clicks on JS Alert Button.
//		Test asserts alert message.
//		Test clicks on JS confirm Button and clicks ok on alert.
//		Test asserts the alert message.
//		Test clicks on JS Prompt Button and types a message on Prompt.
//		Test asserts that the alert message contains the typed message.
		jsalerts = new javascripts_alerts(driver);
		driver.get(UtilityClass.configReader("url_javascript_alerts"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "The Internet");
		Thread.sleep(5000);
		jsalerts.val_javascript_alerts("JavaScript Alerts");
	}
	
	@Test(enabled = true)
	public void javaScriptError() throws InterruptedException {
//		Test finds the JavaScript error on the page.
//		Test asserts that the page contains error: Cannot read property 'xyz' of undefined.
		jsalerts = new javascripts_alerts(driver);
		driver.get(UtilityClass.configReader("url_javascript_error"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Page with JavaScript errors on load");
		Thread.sleep(5000);
		jsalerts.val_javascript_alerts_error();
	}
	
	@Test(enabled = true)
	public void openNewTab() throws InterruptedException {
//		Test clicks on the Click Here link.
//		Test asserts that a new tab is opened with text New Window.
		newWindow = new Window_new(driver);
		driver.get(UtilityClass.configReader("url_windows"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "The Internet");
		Thread.sleep(5000);
		newWindow.navigate_new_window("Opening a new window");
	}
	
	@Test(enabled = true)
	public void notification_Message() throws InterruptedException {
//		Test clicks on the Click Here link a multiple times.
//		Test asserts that one of the “Action Successful”, “Action unsuccessful, 
//		please try again” and “Action Unsuccessful” messages show on click.
		newWindow = new Window_new(driver);
		driver.get(UtilityClass.configReader("url_Message"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "The Internet");
		Thread.sleep(5000);
		newWindow.notification_message("Notification Message");
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
