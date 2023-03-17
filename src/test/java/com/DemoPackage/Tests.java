package com.DemoPackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.Set;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Tests {
	String driverPath = "D:\\Humber\\selenium\\my\\chromedriver.exe";
	public WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void checkboxes() {

		driver.get("http://localhost:7080/checkboxes");
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		Assert.assertFalse(checkbox1.isSelected());
		checkbox1.click();
		Assert.assertTrue(checkbox1.isSelected());
		Assert.assertTrue(checkbox2.isSelected());
		checkbox2.click();
		Assert.assertFalse(checkbox2.isSelected());
	}

	@Test
	public void ContextMenu() {

		driver.get("http://localhost:7080/context_menu");
		// Retrieve WebElement
		WebElement contextBtn = driver.findElement(By.xpath("//*[@id=\"hot-spot\"]"));
		// Instantiate Action Class
		Actions actions = new Actions(driver);
		// Right Click the button to display Context Menu&nbsp;
		actions.contextClick(contextBtn).perform();
		// Alert Message (Expected Text)
		String expectedAlertMessage = "You selected a context menu";
		// Captured Alert Text (Actual Text)
		String actualAlertMessage = driver.switchTo().alert().getText();
		// Assertion
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
		// Accept the alert (Click OK)
		driver.switchTo().alert().accept();
		
	}

	@Test
	public void DragAndDrop() {

		driver.get("http://localhost:7080/drag_and_drop");
		// Actions class method to drag and drop
		Actions action = new Actions(driver);

		WebElement from = driver.findElement(By.id("column-a"));

		WebElement to = driver.findElement(By.id("column-b"));
		WebElement header = driver.findElement(By.xpath("//*[@id=\"column-a\"]/header"));
		// Perform drag and drop
		action.dragAndDrop(from, to).perform();

		// verify text changed 
		String text = header.getText();
		Assert.assertEquals(text, "A");
	}
	@Test
	public void DropDown() {

		driver.get("http://localhost:7080/dropdown");
		Select drpdown = new Select(driver.findElement(By.id("dropdown")));
		drpdown.selectByVisibleText("Option 1");
		String selection1 = drpdown.getFirstSelectedOption().getText();
		Assert.assertEquals("Option 1",selection1);
		drpdown.selectByVisibleText("Option 2");
		String selection2 = drpdown.getFirstSelectedOption().getText();
		Assert.assertEquals("Option 2",selection2);
		
	}
	@Test
	public void DynamicContent() {

		driver.get("http://localhost:7080/dynamic_content");
		//get the value of an element on the page 
		String old_value = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]")).getText();

		//refresh the page
		driver.navigate().refresh();
		//get the new value of the element
		String new_value = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]")).getText();

		//assert that the values are not equal
		Assert.assertNotEquals(old_value,new_value);
		
	}
	@Test
	public void DynamicControls() {

		driver.get("http://localhost:7080/dynamic_controls");
		//get the value of an element on the page 
		WebElement AddRemoveButton= driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
		AddRemoveButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
		Assert.assertEquals(0, driver.findElements(By.id("checkbox")).size());
		AddRemoveButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
		Assert.assertEquals(1, driver.findElements(By.id("checkbox")).size());
		WebElement enableDisableBtn= driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
		enableDisableBtn.click();
		WebElement textbox= driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
		wait.until(ExpectedConditions.elementToBeClickable(textbox));
		Assert.assertEquals(true, textbox.isEnabled());
		enableDisableBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Enable']")));
		Assert.assertEquals(false, textbox.isEnabled());
		
			}
	@Test
	public void DynamicLoading() {

		driver.get(" http://localhost:7080/dynamic_loading/2");
		//get the value of an element on the page 
		WebElement startbtn = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
		
		startbtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement msg = driver.findElement(By.xpath("//*[text()='Hello World!']"));
		wait.until(ExpectedConditions.visibilityOf(msg));
		//assert that the label is present
		Assert.assertEquals("Hello World!",msg.getText());
		
	}
	@Test
	public void FileUpload() {

		driver.get("http://localhost:7080/upload");
		//get the value of an element on the page 
		WebElement fileUploadBtn = driver.findElement(By.id("file-upload"));
		fileUploadBtn.sendKeys("D:\\empty.txt");
		WebElement uploadBtn = driver.findElement(By.id("file-submit"));
		uploadBtn.click();
		String msg = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
		Assert.assertEquals("File Uploaded!",msg);
		
		
	}
	@Test
	public void FileDownload() {

		driver.get("http://localhost:7080/download");
		//get the value of an element on the page 
		WebElement fileDwnld = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[2]"));
		fileDwnld.click();
		String downloadPath = "C:\\Users\\musta\\Downloads";
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        int flag=0;
        for (int i = 0; i < dirContents.length; i++) {
        	System.out.println(dirContents[i].getName());
            if (dirContents[i].getName().equalsIgnoreCase("empty.txt")) {
                flag=1;
            }else {
                //Thread.sleep(1000);
            }
        }
        Assert.assertEquals(1,flag);
    }
	@Test
	public void FloatingMenu() {

		driver.get("http://localhost:7080/floating_menu");
		//get the value of an element on the page 
		WebElement menu = driver.findElement(By.id("menu"));
		Assert.assertEquals(true, menu.isDisplayed());
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Assert.assertEquals(true, menu.isDisplayed());		
	}
	@Test
	public void IFrame() {

		driver.get("http://localhost:7080/iframe");
		driver.switchTo().frame("mce_0_ifr");
		WebElement iFrame = driver.findElement(By.id("tinymce"));
		iFrame.clear();
		iFrame.sendKeys("Hello My Name is Mustafa");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals("Hello My Name is Mustafa", iFrame.getText());		
	}
	@Test
	public void MouseHover() {

		driver.get(" http://localhost:7080/hovers");
		Actions action=new Actions(driver);
		WebElement img1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]"));
		action.moveToElement(img1).perform();
		WebElement label1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5"));
		Assert.assertEquals(true, label1.isDisplayed());
		
		WebElement img2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]"));
		action.moveToElement(img2).perform();
		WebElement label2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5"));
		Assert.assertEquals(true, label2.isDisplayed());
		
		WebElement img3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]"));
		action.moveToElement(img3).perform();
		WebElement label3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5"));
		Assert.assertEquals(true, label3.isDisplayed());
	}
	@Test
	public void JavaScriptsAlerts() {

		driver.get(" http://localhost:7080/javascript_alerts");
		WebElement alert = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
		alert.click();
		Assert.assertEquals("I am a JS Alert", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		WebElement confirm = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
		confirm.click();
		Assert.assertEquals("I am a JS Confirm", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		WebElement prompt = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
		prompt.click();
		driver.switchTo().alert().sendKeys("my name is mustafa");
		driver.switchTo().alert().accept();
		Assert.assertEquals("You entered: my name is mustafa", driver.findElement(By.xpath("//*[@id=\"result\"]")).getText());
	}
	@Test
	public void JavaScriptError() {
		driver.get(" http://localhost:7080/javascript_error");
		List<LogEntry> errors= driver.manage().logs().get(LogType.BROWSER).getAll();
                Assert.assertTrue(errors.get(errors.size()-1).getMessage().contains("Cannot read properties of undefined"));
		}
	@Test
	public void OpenInNewTab() {

		driver.get(" http://localhost:7080/windows");
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		btn.click();
		String parentID = driver.getWindowHandle();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		if(parentID.equals(tabs2.get(0))) {
		  driver.switchTo().window(tabs2.get(1));
		}else {
		  driver.switchTo().window(tabs2.get(0));
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals("New Window", driver.findElement(By.xpath("/html/body/div/h3")).getText());
		}
	@Test
	public void NotificationMessage() {

		driver.get("http://localhost:7080/notification_message_rendered");
		WebElement clickHere = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
		clickHere.click();
		String msg=driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
		System.out.println(msg);
		int flag=0;
		if(msg.contains("Action unsuccesful, please try again") || msg.contains("Action successful") || msg.contains("Action Unsuccessful"))
		{
			flag=1;
		}
		Assert.assertEquals(1,flag);
		WebElement clickHere2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
		clickHere2.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String msg2=driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
		System.out.println(msg2);
		flag=0;
		if(msg2.contains("Action unsuccesful, please try again") || msg2.contains("Action successful") || msg2.contains("Action Unsuccessful"))
		{
			flag=1;
		}
		Assert.assertEquals(1,flag);
		}

	@AfterTest
	public void tearDown() {

		driver.close();
	}

}
