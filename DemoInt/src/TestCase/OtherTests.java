package TestCase;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class OtherTests {
	
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
        ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		
		String downloadFilepath = System.getProperty("user.dir");
		chromePrefs.put("download.default_directory", downloadFilepath);
		
		options.setExperimentalOption("prefs",chromePrefs);
		
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }



@Test(priority=1)
public void checkBoxes() throws InterruptedException {
	
	driver.get("http://localhost:7080/checkboxes");
	
	OtherObjects obj = new OtherObjects(driver);
	
	boolean b1 = obj.checkbox1.isSelected();
	boolean b2 = obj.checkbox2.isSelected();
	
	obj.checkbox1.click();
	obj.checkbox2.click();
	
	boolean b3 = obj.checkbox1.isSelected();
	boolean b4 = obj.checkbox2.isSelected();
	
	//System.out.println(b1);
	//System.out.println(b2);
	//System.out.println(b3);
	//System.out.println(b4);
	
	Assert.assertNotEquals(b1, b3);
	Assert.assertNotEquals(b2, b4);
	

	
	}

@Test(priority=2)
public void JSAlerts() throws InterruptedException {
	
	driver.get("http://localhost:7080/javascript_alerts");
	
	OtherObjects obj = new OtherObjects(driver);
	obj.JSAlert.click();
	//Thread.sleep(6000);
	Alert alert1 = driver.switchTo().alert();
	String textOnAlert1 = alert1.getText();
	Assert.assertEquals(textOnAlert1, "I am a JS Alert");
	alert1.accept();
	
	
    obj.JSconfirm.click();
	//Thread.sleep(6000);
    Alert alert2 = driver.switchTo().alert();
	String textOnAlert2 = alert2.getText();
	Assert.assertEquals(textOnAlert2, "I am a JS Confirm");
	alert2.accept();
	
	obj.JSprompt.click();
	Alert alert3 = driver.switchTo().alert();
	
	
	alert3.sendKeys("This is Automation QA - Mitali");
	//String textOnAlert3 = alert3.getText();
	alert3.accept();
	String TypedMessage = obj.Result.getAttribute("innerText");
	Assert.assertEquals(TypedMessage, "You entered: This is Automation QA - Mitali");
	
	
	
	
}

@Test

public void iFrame() throws InterruptedException {
	
	driver.get("http://localhost:7080/iframe");
	
	OtherObjects obj = new OtherObjects(driver);
	
	driver.switchTo().frame("mce_0_ifr");
	obj.iFrame.clear();
	obj.iFrame.sendKeys(obj.S);
	String a = obj.iFrame.getText();
	System.out.println(a);
	Assert.assertEquals(a, obj.S);
	//Thread.sleep(3000);
}

@Test

public void newTab() {	
	
	driver.get("http://localhost:7080/windows");
	OtherObjects obj = new OtherObjects(driver);
	obj.clickHere.click();
	
	driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
	Assert.assertEquals(obj.newTabContent.getText(), obj.newTabBody);
}

@Test

public void jsError() {
	
	driver.get("http://localhost:7080/javascript_error");
	Set<String> logtypes = driver.manage().logs().getAvailableLogTypes();
	for (String string : logtypes) {
		System.out.println(string);
	}
	
   List<LogEntry> logEntries = driver.manage().logs().get(LogType.BROWSER).getAll();
   for (LogEntry logEntry : logEntries) {
   System.out.println(logEntry);
   }
 
  
	
}

@Test
public void dynamicLoading() {
	
	driver.get("http://localhost:7080/dynamic_loading/2");
	OtherObjects obj = new OtherObjects(driver);
	obj.Start.click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	wait.until(ExpectedConditions.visibilityOf(obj.Hello));
	Assert.assertTrue(obj.Hello.isDisplayed());

	
}


@Test
public void dynamicContent() {
	driver.get("http://localhost:7080/dynamic_content");
	OtherObjects obj = new OtherObjects(driver);
	
	String contentBeforeRefresh = obj.DynamicContent.getText();
	driver.navigate().refresh();
	
	String contentAfterRefresh = obj.DynamicContent.getText();
	if (!contentBeforeRefresh.equals(contentAfterRefresh)) {
	    System.out.println("Content has changed on refresh");
	} else {
	    System.out.println("Content has not changed on refresh");
	}
}

@Test
public void dragAndDrop()   {
	driver.get("http://localhost:7080/drag_and_drop");
	OtherObjects obj = new OtherObjects(driver);
	Actions actions = new Actions(driver);
	actions.dragAndDrop(obj.ColumnA, obj.ColumnB).perform();
}

@Test

public void floatingMenu()   {
	
	driver.get("http://localhost:7080/floating_menu");
	OtherObjects obj = new OtherObjects(driver);
	
	Point location = obj.Home.getLocation();
	System.out.println(" Before Scroll location is" +location);
	
	JavascriptExecutor jse= ((JavascriptExecutor) driver);
	
	jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    Assert.assertNotEquals(location, obj.Home.getLocation());
	
}

@Test
public void dynamicControl()   {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	
	driver.get("http://localhost:7080/dynamic_controls");
	
	OtherObjects obj = new OtherObjects(driver);
	obj.Remove.click();
	wait.until(ExpectedConditions.visibilityOf(obj.Add));
     boolean hj = driver.findElements(By.name("checkbox")).isEmpty();
	Assert.assertTrue(hj);
	
	obj.Add.click();
	wait.until(ExpectedConditions.visibilityOf(obj.checkBox));
	Assert.assertTrue(obj.checkBox.isDisplayed());
	
	
	obj.Enable.click();
	wait.until(ExpectedConditions.visibilityOf(obj.Disable));
	Assert.assertTrue(obj.TextBox.isEnabled());
	
	
	obj.Disable.click();
	wait.until(ExpectedConditions.invisibilityOf(obj.Disable));
	boolean a = obj.TextBox.isEnabled();
	Assert.assertFalse(a);
	
	
};

@Test
public void notificationMessage() {
	
	driver.get("http://localhost:7080/notification_message_rendered");
	OtherObjects obj = new OtherObjects(driver);
	
	//String[] expectedMessages = {"Action Successful", "Action unsuccessful, please try again", "Action Unsuccessful"};
	obj.NotificationClick.click();
	String actualMessage = obj.FlashMessage.getText();
	//System.out.println(expectedMessages);
	System.out.println(actualMessage);
	
	
	
}
	
@Test
public void contextMenu() {
	
	driver.get("http://localhost:7080/context_menu");

	WebElement box = driver.findElement(By.xpath("(//div[@id='hot-spot'])[1]"));
	
	
	Actions actions = new Actions(driver);
	actions.contextClick(box).build().perform();

	String expectedAlertText= "You selected a context menu";
	String actualAlertText= driver.switchTo().alert().getText();
	
	driver.switchTo().alert().accept();
	
	Assert.assertEquals(actualAlertText, expectedAlertText);
	
	
  }

@Test
public void dropDown() {
	
	driver.get("http://localhost:7080/dropdown");
	
	WebElement dropDown = driver.findElement(By.id("dropdown"));
	
	Select select = new Select(dropDown);
	
	
	select.selectByVisibleText("Option 1");
	
	
    WebElement a = select.getFirstSelectedOption()	;

   
    Assert.assertEquals(a.getText(),"Option 1" );
    System.out.println("Selected Option is: " +a.getText());

    select.selectByValue("2");
    WebElement b = select.getFirstSelectedOption()	;

    Assert.assertEquals(b.getText(),"Option 2" );
    System.out.println("Selected Option is: " +b.getText());
	
}

@Test
public void fileDownload() throws InterruptedException {
	
	driver.get("http://localhost:7080/download");
	driver.findElement(By.xpath("//a[normalize-space()='some-file.txt']")).click();
	//Thread.sleep(4000);
	File file = new File(System.getProperty("user.dir")+"\\some-file.txt");
	boolean c = file.exists();
	
	Assert.assertTrue(c);
	driver.quit();
	//check browser closure
	

         }

@Test
public void fileUpload() throws InterruptedException  {
	
	driver.get("http://localhost:7080/upload");
	
	String uploadFilepath = System.getProperty("user.dir");
	driver.findElement(By.id("file-upload")).sendKeys(uploadFilepath+"\\Upload File\\TestDemo.txt");
	
	driver.findElement(By.id("file-submit")).click();
	//Thread.sleep(4000);
	String result = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
	System.out.println(result);
	Assert.assertEquals(result, "File Uploaded!");
}

@Test

public void mouseHover() throws InterruptedException  {
	
	driver.get("http://localhost:7080/hovers");

	WebElement image1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
	WebElement image2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
	WebElement image3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));


	Actions actions = new Actions(driver);
	actions.moveToElement(image1).perform();
	//Thread.sleep(2000);
	String info1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).getText();
	System.out.println(info1);
	Assert.assertEquals(info1, "name: user1");
	

	actions.moveToElement(image2).perform();
	//Thread.sleep(2000);
	String info2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5")).getText();
	System.out.println(info2);
	Assert.assertEquals(info2, "name: user2");
	
	actions.moveToElement(image3).perform();
	//Thread.sleep(2000);
	String info3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5")).getText();
	System.out.println(info3);
	Assert.assertEquals(info3, "name: user3");
}




}
