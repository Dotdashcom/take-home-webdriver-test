package ddcTest;


import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DDCTest {
	
	
	ChromeOptions options = new ChromeOptions();
	WebDriver driver = new ChromeDriver(options.addArguments("--remote-allow-origins=*"));
	String baseUrl="http://localhost:7080";
	
	
	@BeforeSuite
	public void setup() {
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
	@Test	
	public void testLoginSuccess() {
		driver.get(baseUrl+"/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
		
		String expectedUrl = baseUrl+"/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test	
	public void testLoginFailure() {
		driver.get(baseUrl+"/login");
		
		//checking wrong username: 
		
		driver.findElement(By.id("username")).sendKeys("wrongUsername");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
		
		String expectedUrl = baseUrl+"/login";
		String actualUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(actualUrl, expectedUrl);
		
		String expectedErrorMsg = "Your username is invalid!";
		String actualErrorMsg = driver.findElement(By.id("flash-messages")).getText();
		
		Assert.assertTrue(actualErrorMsg.contains(expectedErrorMsg));
		
		//checking wrong password:
		
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("wrongPassword!");
		driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
		
		
		Assert.assertEquals(actualUrl, expectedUrl);
		
		expectedErrorMsg = "Your password is invalid!";
		actualErrorMsg = driver.findElement(By.id("flash-messages")).getText();
		
		Assert.assertTrue(actualErrorMsg.contains(expectedErrorMsg));
		
	}
	
	@Test
	public void testCheckboxes() {
		
		driver.get(baseUrl+"/checkboxes");
		
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		
		Boolean state1 = checkbox1.isSelected();
		Boolean state2 = checkbox2.isSelected();
		
		//click checkboxes:
		
		checkbox1.click();
		checkbox2.click();
		
		Assert.assertEquals(checkbox1.isSelected(),!state1);
		Assert.assertEquals(checkbox2.isSelected(),!state2);
		
		//click again:
		
		checkbox1.click();
		checkbox2.click();
		
		Assert.assertNotEquals(checkbox1.isSelected(),!state1);
		Assert.assertNotEquals(checkbox2.isSelected(),!state2);
		
	}

	
	@Test
	public void testContextMenu() {
		
		driver.get(baseUrl+"/context_menu");
		
		Actions action = new Actions(driver);
		WebElement spot = driver.findElement(By.id("hot-spot"));
		action.contextClick(spot).perform();
		
		Alert alert = driver.switchTo().alert();
		
		String expectedAlertMsg = "You selected a context menu";
		
		Assert.assertTrue(alert.getText().contains(expectedAlertMsg));		
		alert.accept();
		
	}
	
	@Test
	public void testDragAndDrop() throws InterruptedException {
		
		driver.get(baseUrl+"/drag_and_drop");
		
		WebElement a = driver.findElement(By.id("column-a"));
		WebElement b = driver.findElement(By.id("column-b"));
		
		Thread.sleep(2000);
		dragAndDrop(a,b);
		
		Assert.assertEquals(a.getText(), "B");
		Assert.assertEquals(b.getText(), "A");

	}
	
	
	public void dragAndDrop(WebElement from, WebElement to) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                        + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                        + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                        + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                        + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                        + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                        + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                        + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                        + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                        + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                        + "var dropEvent = createEvent('drop');\n"
                        + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                        + "var dragEndEvent = createEvent('dragend');\n"
                        + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                        + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                        + "simulateHTML5DragAndDrop(source,destination);", from, to);
    }
	
	@Test
	public void testDropDown() {
		
		driver.get(baseUrl+"/dropdown");
		
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"dropdown\"]"));
		dropdown.click();
		
		WebElement opt1 = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[1]"));
		opt1.click();
		
		Assert.assertTrue(opt1.isSelected());
		
		dropdown.click();
		
		WebElement opt2 = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[2]"));
		opt2.click();
		
		Assert.assertTrue(opt2.isSelected());
		
	}
	
	@Test
	public void testDynamicContent() {
		
		driver.get(baseUrl+"/dynamic_content");
		
		String text1Before= driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]")).getText();
		String text2Before= driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]")).getText();
		String text3Before= driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]")).getText();
		
		driver.navigate().refresh();
		
		String text1After= driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]")).getText();
		String text2After= driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]")).getText();
		String text3After= driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]")).getText();
		
		
		Assert.assertEquals(text1Before.equals(text1After) && text2Before.equals(text2After) && text3Before.equals(text3After),false);

		
		
	}
	
	@Test
	public void testDynamicControls() {
		
		
		driver.get(baseUrl+"/dynamic_controls");
		
		WebElement checkBox = driver.findElement(By.id("checkbox"));
		WebElement removeBtn = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
		WebElement addBtn = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
		WebElement textBox = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
		WebElement enableDisableBtn = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		// Click Remove button and wait until checkbox disappear 
		removeBtn.click();	
		wait.until(ExpectedConditions.invisibilityOf(checkBox));
		WebElement goneMsg = driver.findElement(By.id("message"));
		Assert.assertEquals(goneMsg.getText(), "It's gone!");
		
		//Click add button and wait until checkbox is present
		addBtn.click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
		WebElement backMsg = driver.findElement(By.id("message"));
		Assert.assertEquals(backMsg.getText(), "It's back!");
		
		//Click on enable button 
		enableDisableBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(textBox));
		WebElement enabledMsg = driver.findElement(By.id("message"));
		Assert.assertEquals(enabledMsg.getText(), "It's enabled!");
		
		//Click on disable button 
		enableDisableBtn.click();
		wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"input-example\"]/input"))));
		WebElement disabledMsg = driver.findElement(By.id("message"));
		Assert.assertEquals(disabledMsg.getText(), "It's disabled!");
		
	}
	
	@Test
	public void testDynamicLoading() {
		
		driver.get("http://localhost:7080/dynamic_loading/2");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		WebElement startBtn = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
		startBtn.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		String text = driver.findElement(By.id("finish")).getText();
		
		Assert.assertEquals(text, "Hello World!");
		
	}
	
	@Test
	public void testFileDownload() throws InterruptedException {
		
		driver.get(baseUrl+"/download");
		
		Thread.sleep(2000);
		
		WebElement file = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		file.click();
		Thread.sleep(2000);
		
		String home = System.getProperty("user.home");
		File f = new File(home + "/Downloads/some-file.txt");
		
		Assert.assertTrue(f.exists());
	}
	
	
	@Test
	public void testFileUpload() throws InterruptedException {
		
		driver.get(baseUrl+"/upload");
		
		Thread.sleep(2000);
		
		String home = System.getProperty("user.home");
		
		driver.findElement(By.id("file-upload")).sendKeys(home + "/Downloads/some-file.txt");
		driver.findElement(By.id("file-submit")).submit();
		
		
		String message = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
		Assert.assertEquals(message, "File Uploaded!");
		
	}
	
	@Test
	public void testFloatingMenu() throws InterruptedException {
		
		driver.get(baseUrl+"/floating_menu");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		WebElement menu = driver.findElement(By.id("menu"));
        
        Thread.sleep(3000);
        
        Assert.assertTrue(menu.isDisplayed());
		
	}
	
	@Test
	public void testIframe() throws InterruptedException {
		
		driver.get(baseUrl+"/iframe");
		
		//Close popup
		driver.findElement(By.xpath("/html/body/div[4]/div/div/button")).click();
		
		driver.switchTo().frame("mce_0_ifr");
		
		WebElement textField = driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
		textField.clear();
		textField.sendKeys("Peace");
		
		String editedText = driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).getText();
		
		Assert.assertEquals(editedText,"Peace");
		
		
		Thread.sleep(2000);
	}
	
	
	@Test
	public void testMouseHover() {
		
		driver.get(baseUrl+"/hovers");
		
		//Instantiating Actions class
		Actions actions = new Actions(driver);
		
		WebElement image1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
		WebElement image2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
		WebElement image3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
		
		actions.moveToElement(image1).perform();
		WebElement elem1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div"));
		Assert.assertTrue(elem1.isDisplayed());
		
		actions.moveToElement(image2).perform();
		WebElement elem2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div"));
		Assert.assertTrue(elem2.isDisplayed());
		
		actions.moveToElement(image3).perform();
		WebElement elem3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div"));
		Assert.assertTrue(elem3.isDisplayed());
		
	}
	
	@Test
	public void testJavascriptAlerts() {
		
		driver.get(baseUrl+"/javascript_alerts");
		
		
		//JS Alert
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
		String alert1 = driver.switchTo().alert().getText();
		
		Assert.assertEquals(alert1, "I am a JS Alert");
		driver.switchTo().alert().accept();
		
		//JS Confirm
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		String alert2 = driver.switchTo().alert().getText();
		
		Assert.assertEquals(alert2, "I am a JS Confirm");
		driver.switchTo().alert().accept();
		
		//JS Prompt
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
		
		Boolean hasTextField = false;
		try{
			driver.switchTo().alert().sendKeys("is it?");
			hasTextField=true;
		}catch(ElementNotInteractableException e){
			
		}
		
		Assert.assertEquals(!hasTextField,false);
		driver.switchTo().alert().accept();
		
	}
	
	@Test
	public void testJavascriptError() {
		
		driver.get(baseUrl+"/javascript_error");
		
		
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		
		String errorMsg ="";
		List<LogEntry> log = logEntries.toJson();
		for(LogEntry logEntry:log) {
			errorMsg+=logEntry.getMessage();
		}
		System.out.print(errorMsg);
		Assert.assertTrue(errorMsg.contains("Cannot read properties of undefined (reading 'xyz')"));
	}
	
	@Test
	public void testOpenInNewTab() {
		
		driver.get(baseUrl+"/windows");
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
		
		//Go to the new tab
		driver.navigate().to(baseUrl+"/windows/new");
		
		String text = driver.findElement(By.xpath("/html/body/div/h3")).getText();
		
		Assert.assertEquals(text, "New Window");
		
	}
	
	@Test
	public void testNotificationMessage() throws InterruptedException {
		
		driver.get(baseUrl+"/notification_message_rendered");
		
		for (int i = 0; i < 5; i++) {
			WebElement clickHereLink = driver.findElement(By.linkText("Click here"));
			clickHereLink.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement notif = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

			String msg = notif.getText();
			Boolean isCorrectMessage =  (msg.contains("Action successful") || msg.contains("Action unsuccesful, please try again"));
			
			Assert.assertTrue(isCorrectMessage);

		}
		
	}

	
	
	
	
	
	
	
	
	
	

}
