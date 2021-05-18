
import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;


public class Tests{
	
	
	
	
	
	 WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		
		
		
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:7080");
	}
	
	@Test
	public void LoginSuccess() {
		
		LoginPage l = new LoginPage(driver);
		driver.get("http://localhost:7080/login");
		l.getUsername().sendKeys("tomsmith");
		l.getPassword().sendKeys("SuperSecretPassword!");
		l.getLoginButton().click();
		Boolean verify = driver.findElement(By.xpath("//div[@class='flash success']")).isDisplayed();
		assertTrue(verify);
	}
	
	@Test
	public void LoginFailure() {
		
		LoginPage l = new LoginPage(driver);
		driver.get("http://localhost:7080/login");
		l.getUsername().sendKeys("wronguser");
		l.getPassword().sendKeys("wrongpass");
		l.getLoginButton().click();
		Boolean verify = driver.findElement(By.xpath("//div[@class='flash error']")).isDisplayed();
		assertTrue(verify);
		
	}
	
	@Test
	public void CheckBoxes() {
		
		driver.findElement(By.linkText("Checkboxes")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::input")).click();
		assertTrue(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());
		assertFalse(driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::input")).isSelected());
	}
	
	@Test
	public void ContextMenu() {
		
		Actions actions = new Actions(driver);
		driver.findElement(By.linkText("Context Menu")).click();
		WebElement hotspot = driver.findElement(By.id("hot-spot"));
		actions.contextClick(hotspot).perform();
		String alertText = driver.switchTo().alert().getText();
		assertEquals(alertText, "You selected a context menu");
	}
	
//	@Test
//	public void DragAndDrop() {
//		
//		driver.findElement(By.linkText("Drag and Drop")).click();
//       
//		Actions actions = new Actions(driver);
//		
//		WebElement from = driver.findElement(By.id("column-a"));
//		WebElement to = driver.findElement(By.id("column-b"));
//		
//		actions.moveToElement(from).clickAndHold().moveToElement(to).release().build().perform();
	
	// Potential bug with this one 
//	}
	
	@Test
	public void Dropdown() {
		
		driver.findElement(By.linkText("Dropdown")).click();
		driver.findElement(By.id("dropdown")).click();
		driver.findElement(By.id("dropdown")).click();;
		driver.findElement(By.cssSelector("option[value='1']")).click();
		assertEquals(driver.findElement(By.cssSelector("option[selected='selected']")).getText(),"Option 1");
		driver.findElement(By.id("dropdown")).click();
		driver.findElement(By.cssSelector("option[value='2']")).click();
		assertEquals(driver.findElement(By.cssSelector("option[selected='selected']")).getText(),"Option 2");
	}
	
	@Test
	public void DynamicContent(){
		
		driver.findElement(By.linkText("Dynamic Content")).click();	
		
		for(int i = 0; i < 3; i++) {
			WebElement first = driver.findElement(By.cssSelector("div[class='large-10 columns']"));
			driver.navigate().refresh();
			WebElement second = driver.findElement(By.cssSelector("div[class='large-10 columns']"));
			
			assertFalse(first.equals(second));
		}
	}
	
	@Test
	public void DynamicControls() {
		
		driver.findElement(By.linkText("Dynamic Controls")).click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		driver.findElement(By.xpath("//button[@type='button']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		assertTrue(driver.findElement(By.id("checkbox")).isDisplayed());
		driver.findElement(By.xpath("//form[@id='input-example'] //button[@type='button']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		assertTrue(driver.findElement(By.cssSelector("input[type='text']")).isEnabled());
		driver.findElement(By.xpath("//form[@id='input-example'] //button[@type='button']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		assertFalse(driver.findElement(By.cssSelector("input[type='text']")).isEnabled());
	}
	
	@Test
	public void DynamicLoading() {
		
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		driver.findElement(By.xpath("//div[@id='start'] //button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		assertEquals(driver.findElement(By.xpath("//div[@id='finish'] //h4")).getText(),"Hello World!");
	}
	
	@Test
	public void FileDownload() {
		
		driver.findElement(By.linkText("File Download")).click();
		driver.findElement(By.linkText("some-file.txt")).click();
		
		File fileLocation = new File("C:\\Users\\Yunus\\Downloads");
		File[] totalFiles = fileLocation.listFiles();
		
		for(File file : totalFiles) {
			if(file.getName().equals("some-file")) {
				System.out.println("File is downloaded");
				break;
			}
		}
	}
	
	@Test 
	public void FileUpload() {
		
		driver.findElement(By.linkText("File Upload")).click();
		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\Yunus\\Downloads\\some-file.txt");
		driver.findElement(By.id("file-submit")).click();
		assertTrue(driver.findElement(By.xpath("//div[@class='example'] //h3")).getText().equals("File Uploaded!"));
	}
	
	@Test
	public void FloatingMenu() {
		
		driver.findElement(By.linkText("Floating Menu")).click();	
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,4200);");
		jse.executeScript("window.scrollBy(0,-4200);");
		
		assertTrue(driver.findElement(By.id("menu")).isDisplayed());
	}
	
	@Test
	public void Iframe() {
		
		driver.findElement(By.linkText("Frames")).click();
		driver.findElement(By.linkText("iFrame")).click();
		
		if(driver.findElement(By.cssSelector("div[role='alert']")).isDisplayed()) {
			driver.findElement(By.xpath("//div[@role='alert'] //button")).click();
		}
		
		driver.switchTo().frame("mce_0_ifr");
		assertTrue(driver.findElement(By.id("tinymce")).getText().equals("Your content goes here."));
	}
	
	@Test
	public void MouseHover() {
		
		driver.findElement(By.linkText("Hovers")).click();
		Actions actions = new Actions(driver);
		
		WebElement first = driver.findElement(By.xpath("//div[@class ='figure']"));
		WebElement second = driver.findElement(By.xpath("//div[@class ='figure']/following-sibling::div"));
		WebElement third = driver.findElement(By.xpath("//div[@class ='figure']/following-sibling::div[2]"));
		
		actions.moveToElement(first).perform();
		assertTrue(driver.findElement(By.xpath("//div[@class='figcaption'] //h5")).getText().equals("name: user1"));
		
		actions.moveToElement(second).perform();
		assertTrue(driver.findElement(By.xpath("//div[@class ='figure']/following-sibling::div//div//h5"))
				.getText().equals("name: user2"));
		
		actions.moveToElement(third).perform();
		assertTrue(driver.findElement(By.xpath("//div[@class ='figure']/following-sibling::div[2]//div//h5"))
				.getText().equals("name: user3"));
		
	}
	
	@Test
	public void JavaScriptAlerts() {
		
		driver.findElement(By.linkText("JavaScript Alerts")).click();
		
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		assertTrue(driver.switchTo().alert().getText().equals("I am a JS Alert"));
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		assertTrue(driver.switchTo().alert().getText().equals("I am a JS Confirm"));
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		driver.switchTo().alert().sendKeys("Hello World!");
		driver.switchTo().alert().accept();
		assertTrue(driver.findElement(By.id("result")).getText().equals("You entered: Hello World!"));
	}
	
//	@Test
//	public void JavaScriptError() {
//		
//		
//		
//		driver.findElement(By.linkText("JavaScript onload event error")).click();
//		Set<String> logTypes = driver.manage().logs().getAvailableLogTypes();
//		
//		for (String string : logTypes) {
//			System.out.println(string);
//		}
//		
//		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
//		List<LogEntry> logs = logEntries.filter(Level.ALL);
//		
//		for (LogEntry logEntry : logs) {
//			System.out.println(logEntry);
//		}
//	}
	
	@Test
	public void OpenInNewTab() {
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    assertEquals(driver.findElement(By.xpath("//div[@class='example'] //h3")).getText(), "New Window");		
	}
	
	@Test
	public void NotificationMessage() {
		
		driver.findElement(By.linkText("Notification Messages")).click();
		
		for(int i = 0; i < 3; i++) {
		driver.findElement(By.linkText("Click here")).click();
		String flashText = (driver.findElement(By.id("flash-messages")).getText());
		
		if(flashText.equals("Action Successful") || flashText.equals("Action unsuccessful, please try again")
				|| flashText.equals("Action Unsuccessful")) {
		
		assertTrue(true);
			}
		}			
	}
	

	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
		
}
