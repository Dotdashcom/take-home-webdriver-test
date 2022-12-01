package qa.testcases;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import qa.base.TestBase;
import qa.pages.LoginPage;

public class AllTest extends TestBase{

	LoginPage loginpage;
	SoftAssert softAssert;
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		softAssert = new SoftAssert();
	}

	@Test (priority = 1)
    public void loginTest_sucess() throws InterruptedException {
		driver.get(prop.getProperty("baseurl")+"/login");
		loginpage.login_scucessfully();
		Thread.sleep(1000);
		softAssert.assertEquals(loginpage.readLoginSuccessMessage() , prop.getProperty("loginSuccessMsg"));
		softAssert.assertAll();
	}
	
	@Test (priority = 2)
	public void loginTest_failure() throws InterruptedException {
		driver.get(prop.getProperty("baseurl")+"/login");
		loginpage.login_failure();
		Thread.sleep(1000);
		softAssert.assertEquals(loginpage.readLoginFailureMessage() , prop.getProperty("loginFailureMsg"));
		softAssert.assertAll();
	}
	
	@Test (priority = 3)
    public void checkboxSelectionTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/checkboxes");
		Thread.sleep(1000);
		boolean checkbox_1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected();
		System.out.println("checkbox 1 is selected? : "+ checkbox_1);
		Assert.assertEquals(checkbox_1, false);
	
		boolean checkbox_2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]")).isSelected();
		System.out.println("checkbox 2 is selected? : "+ checkbox_2);
		Assert.assertEquals(checkbox_2, true);
	}
	
	@Test (priority = 4)
    public void contextMenu_rightClickTest() throws InterruptedException {
		driver.get(prop.getProperty("baseurl")+"/context_menu");
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		WebElement contextMenu = driver.findElement(By.xpath("//div[@id='hot-spot']"));
		action.contextClick(contextMenu).build().perform();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertEquals("You selected a context menu", alert.getText());
	}
	
	@Test (priority = 5)
    public void drag_and_drop_Test() throws InterruptedException {
		driver.get(prop.getProperty("baseurl")+"/drag_and_drop");
		Thread.sleep(1000);
		WebElement dropFrom = driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement dropTo = driver.findElement(By.xpath("//div[@id='column-b']"));
		
		System.out.println("Before Drag and Drop");
		System.out.println(dropFrom.getText());
		System.out.println(dropTo.getText());

		Assert.assertEquals(dropFrom.getText(), "A");
		Assert.assertEquals(dropTo.getText(), "B");
		
		Thread.sleep(2000);
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
				                    + "simulateHTML5DragAndDrop(source,destination);", dropFrom, dropTo);

		System.out.println("After Drag and Drop");
		System.out.println(dropFrom.getText());
		System.out.println(dropTo.getText());

		Assert.assertEquals(dropFrom.getText(), "B");
		Assert.assertEquals(dropTo.getText(), "A");
	}
	
	@Test (priority = 6) 
    public void dropDownTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/dropdown");
		
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		Select s = new Select(dropdown);
		
		System.out.println("Select Option 1");
		s.selectByValue("1");
		System.out.println("Option 1 is selected : " + s.getFirstSelectedOption().isSelected());
		Assert.assertEquals(s.getFirstSelectedOption().isSelected(), true);

		Thread.sleep(1000);
		System.out.println("Select Option 2");
		s.selectByVisibleText("Option 2");
		System.out.println("Option 2 is selected : " + s.getFirstSelectedOption().isSelected());

		Assert.assertEquals(s.getFirstSelectedOption().isSelected(), true);
	}
	
	@Test (priority = 7) 
    public void dynamicContentTest() throws InterruptedException  {
		
		driver.get(prop.getProperty("baseurl")+"/dynamic_content");
		
		String oldContent = driver.findElement(By.xpath("//div[@class='row'][1]/div[2]")).getText();
		Thread.sleep(500);
		driver.navigate().refresh();
		driver.navigate().refresh();

		String newContent = driver.findElement(By.xpath("//div[@class='row'][1]/div[2]")).getText();
		
		if(oldContent.equals(newContent)) 
			System.out.println("Dynamic content Test Fail");
		else
			System.out.println("Dynamic content Test Pass");

		Assert.assertNotEquals(oldContent, newContent);
	}
	
	@Test (priority = 8)
    public void dynamicControlTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/dynamic_controls");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement checkBox = driver.findElement(By.xpath("//div[@id='checkbox']"));

		WebElement removeBtn = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
		removeBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(checkBox));
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='message']")).getText(), "It's gone!");

		WebElement addBtn = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		addBtn.click();
		wait.until(ExpectedConditions.textToBePresentInElement(addBtn, "Remove"));
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='message']")).getText(), "It's back!");

		WebElement textbox = driver.findElement(By.xpath("//form[@id='input-example']/input"));
		
		WebElement enableBtn = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
		enableBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(textbox));
		Assert.assertEquals(textbox.isEnabled(), true);

		WebElement disableBtn = driver.findElement(By.xpath("//button[contains(text(),'Disable')]"));
		disableBtn.click();
		wait.until(ExpectedConditions.textToBePresentInElement(disableBtn, "Enable"));
		Assert.assertEquals(textbox.isEnabled(), false);
	}

	@Test (priority = 9)
    public void dynamicLoadingTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/dynamic_loading/2");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));
		
		Assert.assertEquals(driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).getText(), "Hello World!");
	}
	
	@Test (priority = 10)
    public void fileDownloadTest() {
		
		driver.get(prop.getProperty("baseurl")+"/download");
		
		driver.findElement(By.xpath("//a[contains(text(),'some-file.txt')]")).click();
		boolean flag = isFileDownloaded("some-file");
		//System.out.println(flag);
		Assert.assertEquals(flag , true);
		
	}
	
	public static Boolean isFileDownloaded(String fileName) {
        
		boolean flag = false;
        String dirPath = "C:\\Users\\Sonal Patel\\Downloads"; 
       
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files.length == 0 || files == null) {
            System.out.println("The directory is empty");
            flag = false;
        } else {
            for (File listFile : files) {
                if (listFile.getName().contains(fileName)) {
                    System.out.println(fileName + " is present");
                    break;
                }
                flag = true;
            }
        }
        return flag;
    }
	
	@Test (priority = 11)
    public void fileUploadTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/upload");
		
		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:/Users/Sonal Patel/Downloads/some-file.txt");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]")).getText(), "File Uploaded!");
	}
	
	@Test (priority = 12)
    public void floatingMenuTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/floating_menu");
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,5000)");
		Thread.sleep(1000);
		WebElement floating_menu = driver.findElement(By.xpath("//div[@id='menu']"));
		Assert.assertEquals(floating_menu.isDisplayed() , true);
	}
	
	@Test (priority = 13) 
    public void iFrameTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/iframe");
		
		driver.switchTo().frame("mce_0_ifr");
		WebElement addText = driver.findElement(By.cssSelector("body"));
		addText.clear();
		addText.sendKeys("Hello World!");
		Thread.sleep(1000);
		System.out.println(addText.getText());
		Assert.assertEquals(addText.getText(), "Hello World!");
	}
	
	@Test (priority = 14) 
    public void mouseHoverTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/hovers");
		
		WebElement img1 = driver.findElement(By.xpath("//div[@class='figure'][1]"));
		WebElement img2 = driver.findElement(By.xpath("//div[@class='figure'][2]"));
		WebElement img3 = driver.findElement(By.xpath("//div[@class='figure'][3]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(img1).build().perform();
		Assert.assertEquals(driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]")).getText(), "name: user1");
		
		Thread.sleep(1000);
		action.moveToElement(img2).build().perform();
		Assert.assertEquals(driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]")).getText(), "name: user2");

		Thread.sleep(1000);
		action.moveToElement(img3).build().perform();
		Assert.assertEquals(driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]")).getText(), "name: user3");
	}
	
	@Test (priority = 15) 
    public void javaScriptAlertTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/javascript_alerts");
		Thread.sleep(1000);
		Alert alert;
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText() , "I am a JS Alert");
		alert.accept();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText() , "I am a JS Confirm");
		alert.accept();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText()	, "You clicked: Ok");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		Thread.sleep(1000);
		String promptMsg = "This is a prompt";
		alert = driver.switchTo().alert();
		alert.sendKeys(promptMsg);
		alert.accept();
		String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String final_result = result.substring(13, result.length());
		Assert.assertEquals(final_result, promptMsg);
	}
	
	@Test (priority = 16) 
    public void javaScriptErrorTest() throws InterruptedException {
		
		SoftAssert softAssert = new SoftAssert();
		driver.get(prop.getProperty("baseurl")+"/javascript_error");
		
		String js_error_msg = driver.findElement(By.cssSelector("p")).getText();
		System.out.println(js_error_msg);
		softAssert.assertEquals(js_error_msg, "Cannot read property 'xyz' of undefined.");
		softAssert.assertAll();
	}
	
	@Test (priority = 17) 
    public void newTabTest() throws InterruptedException  {
		
		driver.get(prop.getProperty("baseurl")+"/windows");
		
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		Set<String> allwindows = driver.getWindowHandles();
		System.out.println(allwindows.size());
		
		Iterator<String> iter = allwindows.iterator();
		String mainwindow = iter.next();
		String childwindow = iter.next();
		
		System.out.println(mainwindow);
		System.out.println(childwindow);
		
		driver.switchTo().window(childwindow);
		Thread.sleep(1000);
		String childwindow_text = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
		Assert.assertEquals(childwindow_text, "New Window");
	}
	
	@Test (priority = 18)
    public void notificationTest() throws InterruptedException  {
		
		driver.get(prop.getProperty("baseurl")+"/notification_message_rendered");
		
		for(int i=1; i<=3; i++) {
			WebElement clickHereLink = driver.findElement(By.xpath("//a[contains(text(),'Click here')]"));
			clickHereLink.click();
			Thread.sleep(1000);
			//String click_msg = driver.findElement(By.xpath("//div[@id='flash']")).getText();
			//System.out.println(click_msg);
		}
		
		String click_msg = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		//System.out.println(click_msg);
		String msg = click_msg.substring(0, click_msg.length()-2);
		boolean result = msg.equals("Action unsuccesful, please try again") || msg.equals("Action successful") || msg.equals("Action Unsuccessful"); 
		Assert.assertTrue(result);
	}
	
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
	
}
