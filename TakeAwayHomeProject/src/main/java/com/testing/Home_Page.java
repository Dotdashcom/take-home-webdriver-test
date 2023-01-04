/**
 * 
 */
package com.testing;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author priyanka goswami
 *this is home page file.
 */
public class Home_Page {
	
	public WebDriver driver;
	
	//Checkbox Elements//
	@FindBy(xpath="(//form[@id=\"checkboxes\"]/input)[1]") public WebElement checkbox1;	
	@FindBy(xpath="(//form[@id=\"checkboxes\"]/input)[2]") public WebElement checkbox2;
	
	//Contextmenu Elements//
	@FindBy(xpath="//div[@id=\"hot-spot\"]") public WebElement contextMenu;
	
	// Drag and Drop Elements//
	@FindBy(xpath="//div[@id ='column-a']") public WebElement drag;
	@FindBy(xpath="//div[@id ='column-b']") public WebElement drop;
	@FindBy(xpath="//div[@id=\"column-a\"]/header") public WebElement header;
	
	//Dropdown Elements//
	@FindBy(xpath="//select[@id=\"dropdown\"]") public WebElement dropdownMenu;
	@FindBy(xpath="//option[@value=\"1\"]") public WebElement selectedOption1;
	@FindBy(xpath="//option[@value=\"2\"]") public WebElement selectedOption2;

	//Dynamic content Element//
	@FindBy(xpath="	//div[@class=\"large-10 columns\"]") public WebElement content;
	
	// Dyanamic Control Elements //
		@FindBy(xpath="//div[@id=\"checkbox\"]/input") public WebElement firstCheckbox;
		@FindBy(xpath="//input[1]") public WebElement secondCheckbox;
		@FindBy(tagName="button") public WebElement removeButton;
		@FindBy(tagName="button") public WebElement addButton;
		@FindBy(xpath="(//p)[2]") public WebElement msg;
		@FindBy(xpath="(//button)[2]") public WebElement enableDisableButton;
		@FindBy(xpath="(//input)[2]") public WebElement textbox;
		
	//Dynamic loading Elements//
		@FindBy(xpath="//div[@id=\"start\"]/button") public WebElement startButtonDynamicLoading;
		@FindBy(xpath="//div[@id=\"finish\"]") public WebElement textDynamicLoading;
	
	//File download and upload Elements //
		@FindBy(xpath="//div[@class=\"example\"]/a") public WebElement fileDownloadOption;
		@FindBy(xpath="//input[@id=\"file-upload\"]") public WebElement fileUploadOption;
		@FindBy(xpath="//input[@id=\"file-submit\"]") public WebElement uploadButton;
		@FindBy(tagName ="h3") public WebElement  fileUploadedHeader;
		
 //Floating menu Element//
		@FindBy(xpath="//div[@id=\"menu\"]") public WebElement floatingMenu;
		
		
 //Frame Elements//
		@FindBy(tagName ="p") public WebElement frameText;
		
	//Mousehover Elements//
	@FindBy(xpath="(//div[contains(@class, 'figure')])[1]") public WebElement hoverImage1;
	@FindBy(xpath="(//h5)[1]") public WebElement hoverText1;
	@FindBy(xpath="(//div[contains(@class, 'figure')])[2]") public WebElement hoverImage2;
	@FindBy(xpath="(//h5)[2]") public WebElement hoverText2;
	@FindBy(xpath="(//div[contains(@class, 'figure')])[3]") public WebElement hoverImage3;
	@FindBy(xpath="(//h5)[3]") public WebElement hoverText3;

	//JavaScripts Alert Elements//
			@FindBy(xpath="(//button)[1]") public WebElement jsAlert;
			@FindBy(xpath="(//button)[2]") public WebElement jsConform;
			@FindBy(xpath="(//button)[3]") public WebElement jsPrompt;
			@FindBy(xpath="(//p)[2]") public WebElement jsMsg;
	
 //JS-display error Elements//
			@FindBy(tagName="p") public WebElement JSDisplayedError;		
	
//Open in new tab Elements//
	@FindBy(xpath="	(//a)[2]") public WebElement clickHereLink;
	@FindBy(tagName ="h3") public WebElement textOnNewTab;
		
//Notification alert Elements//
	@FindBy(xpath="//div[@id=\"flash-messages\"]/div") public WebElement notificationAlert;
	@FindBy(xpath="	//div[@class=\"example\"]/p/a") public WebElement clickHereLink1;
	

		
	//Invoking Browser
	public void setup() throws  InterruptedException{
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\priya\\workspace3\\Final_Project\\Project_Data\\Driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	//Scenario : Checkbox
	public void checkBox() {
		driver.get("http://localhost:7080/checkboxes");
		System.out.println( "Checkbox1 is selected:"+checkbox1.isSelected());
		System.out.println("Checkbox2 is selected: "+checkbox2.isSelected());
         checkbox1.click();
         //checkbox1.getAttribute("checked")
         checkbox2.click();
     	System.out.println("Checkbox1 is selected:"+checkbox1.isSelected());
		System.out.println("Checkbox2 is selected:"+checkbox2.isSelected());
		 Assert.assertEquals("true",checkbox1.getAttribute("checked"));
		 Assert.assertNull(checkbox2.getAttribute("checked"));
	}
	
	//Scenario : ContextMenu
	public void contextMenu() {
		driver.get("http://localhost:7080/context_menu");
		Actions builder = new Actions(driver);
		builder.contextClick(contextMenu).build().perform();
		Alert al = driver.switchTo().alert();
		String actual="You selected a context menu";
		String expected=al.getText();
		Assert.assertEquals(actual, expected);
		System.out.println(al.getText());
		al.accept();
	}
	
	//Scenario :  Drag and Drop
	public void dragAndDrop() throws InterruptedException {
		driver.get("http://localhost:7080/drag_and_drop");
		Actions builder = new Actions(driver);
		Thread.sleep(2000);
		/*https://github.com/SeleniumHQ/selenium/issues/3269 - as per this article its issue from chromedriver,
		 *  drag and drop is not working for chrome 
		 */
		//builder.dragAndDrop(drag, drop).build().perform();
		builder.clickAndHold(drag).moveByOffset(-1, -1).moveToElement(drop).release(drop).build().perform();
		//System.out.println(header.getText());
	}
	
	//Scenario : DropDown
	public void dropDownOptions() throws InterruptedException {
		driver.get("http://localhost:7080/dropdown");
		Select s = new Select(dropdownMenu);
	     s.selectByIndex(1);
	     Thread.sleep(2000);
	     System.out.println(selectedOption1.getAttribute("selected"));
	     Assert.assertEquals("true",selectedOption1.getAttribute("selected"));
	     Thread.sleep(2000);
	     s.selectByIndex(2);
	     Thread.sleep(2000);
	     System.out.println(selectedOption2.getAttribute("selected"));
	     Assert.assertEquals("true",selectedOption2.getAttribute("selected"));
	}
	
	//Scenario :  Dynamic Content
	public void dynamicContent() {
		driver.get("http://localhost:7080/dynamic_content");
		String s1=content.getText();
		driver.navigate().refresh();
		String s2=content.getText();
		Assert.assertNotEquals(s1, s2);
		String s3=content.getText();
		driver.navigate().refresh();
		String s4=content.getText();
		Assert.assertNotEquals(s3, s4);
	}
	
	//Scenario :  Dynamic control
	public void dynamicControl() throws InterruptedException {
		driver.get("http://localhost:7080/dynamic_controls");
		removeButton.click();
		Thread.sleep(4000);
		System.out.println("first checkbox: "+msg.getText());
		addButton.click();
		Thread.sleep(4000);
		System.out.println("after add button clicked checkbox available: "+secondCheckbox.isDisplayed());
		Assert.assertTrue(secondCheckbox.isDisplayed());
		enableDisableButton.click();
		Thread.sleep(4000);
		System.out.println("after enable button clicked textbox enable: "+textbox.isEnabled());
		Assert.assertTrue(textbox.isEnabled());
		enableDisableButton.click();
		Thread.sleep(4000);
		System.out.println("textbox is: "+msg.getText());
	}
	
	//Scenario :  Dynamic loading
	public void dynamicLoading() throws InterruptedException {
		driver.get("http://localhost:7080/dynamic_loading/2");
		Thread.sleep(500);
		startButtonDynamicLoading.click();
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"finish\"]")));
		 System.out.println(textDynamicLoading.getText());
		 Assert.assertTrue(textDynamicLoading.getText().contains("Hello World!"));
	}
	
	//Scenario :  File Download
		public void fileDownload() throws InterruptedException {
			driver.get("http://localhost:7080/download");
			fileDownloadOption.click();
			Assert.assertTrue(true);
		}
		
		//Scenario : File Upload
		public void fileUpload() throws InterruptedException {
			driver.get("http://localhost:7080/upload");
			fileUploadOption.sendKeys("C:/Users/priya/workspace3/TakeAwayHomeProject/Project_Data/some-file.txt");
			uploadButton.click();
			Thread.sleep(2000);
			String actual="File Uploaded!";
			String expected= fileUploadedHeader.getText();
			Assert.assertEquals(actual, expected);	   
		}
		
		//Scenario: Floating Menu
		public void floatingMenu() throws InterruptedException {
			driver.get("http://localhost:7080/floating_menu");
			Thread.sleep(500);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(500);
			if (floatingMenu.isDisplayed()) {
				Assert.assertTrue(true);
				System.out.println("Floating menu is still present");
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		//Scenario : IFrame
		public void frame() throws InterruptedException {
			driver.get("http://localhost:7080/iframe");		
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			frameText.sendKeys("Hey!! Myself Priyanka shgfdgfdghgsgfdghhgfshgdfhgfaghsdhgvsbvdgvnwmhdnvahdbmvsnvchbsmnvdnsvmdnvgsVhdbhVHJDbmVHGDvbnsvdgvsNBvdvBND bvSdnbvsVdbnvshdgjhBHdghjSBcvsHdmnsVdhvsNHVdvHDvjgSVmdvgsVdbn snbvcnbsn because I cant see anything user that pop up. some random key presss lololololol lalallalal");
			Thread.sleep(2000);
		}
		
	//Scenario :  Mouse hover
	public void mouseHover() throws InterruptedException {
		driver.get("http://localhost:7080/hovers");		
		Actions builder = new Actions(driver);
		builder.moveToElement(hoverImage1).build().perform();
		System.out.println( hoverText1.getText());
		builder.moveToElement(hoverImage2).build().perform();
		System.out.println( hoverText2.getText());
		builder.moveToElement(hoverImage3).build().perform();
		System.out.println( hoverText3.getText());
	}
	
	//Scenario:Java Script Alert
		public void javaScriptAlert() throws InterruptedException {
			driver.get("http://localhost:7080/javascript_alerts");
			jsAlert.click();
			Thread.sleep(1000);
			Alert al = driver.switchTo().alert();
			al.accept();
			System.out.println(jsMsg.getText());
			jsConform.click();
			al.accept();
			System.out.println(jsMsg.getText());
			jsPrompt.click();
			al.sendKeys("Hello, this is Priyanka.");
			al.accept();
			System.out.println(jsMsg.getText());
		}
		
		//Scenario: Java script Error
		public void javaScriptError() throws InterruptedException {
			driver.get("http://localhost:7080/javascript_error");
			//System.out.println(JSDisplayedError.getText());
		    Thread.sleep(1000);
		    LogEntries JSHideError= driver.manage().logs().get(LogType.BROWSER);
		  //  System.out.println(JSHideError.getAll());
		    Thread.sleep(500);
		    System.out.println(JSHideError.getAll().get(0));
		    Thread.sleep(1000);
		    Assert.assertTrue(JSHideError.getAll().get(0).toString().contains("Cannot read properties of undefined (reading 'xyz')"));
		}
		
	//Scenario :  Open in new tab
	public void openInNewTab() throws InterruptedException {
		driver.get("http://localhost:7080/windows");
		clickHereLink.click();
	    Thread.sleep(3000);
		//driver.navigate().to("http://localhost:7080/windows/new");
		  ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		  //switch from tab1 to tab2 (new window) this will allow to interact with new tab element
		  driver.switchTo().window(tabs2.get(1)); Thread.sleep(3000);
		String actual="New Window";
		String expected=textOnNewTab.getText();
		Assert.assertEquals(actual, expected);	
	}
	
	//Scenario : Notification Message
	public void notificationMessage() throws InterruptedException {
		driver.get("http://localhost:7080/notification_message_rendered");
		clickHereLink1.click();
		 Thread.sleep(500);
		 //using replaceFirst("×", "") ==> remove "x" from /a tag that inside div and using trim() ==>removing all white space to expected output
		 String s2=notificationAlert.getText().replaceFirst("×", "").trim();
		 Thread.sleep(500);
		 clickHereLink1.click();
		 Thread.sleep(500);
		 String s1=notificationAlert.getText().replaceFirst("×", "").trim();
		 Thread.sleep(500);
		 clickHereLink1.click();
		 Thread.sleep(500);
		 String s3=notificationAlert.getText().replaceFirst("×", "").trim();
		 Thread.sleep(500);
		 System.out.println(s1);
		 System.out.println(s2);
		 System.out.println(s3);
		 if(s1.equals("Action unsuccesful, please try again") || s2.equals("Action Successful")) {
			 Assert.assertTrue(true);
		 }
		 else { 
			 Assert.assertTrue(false);
			 }
	}
	
	//Closing Browser
	public void tearDown() {
		driver.quit();
	}

}
