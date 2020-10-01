package com.testing;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class PageFile extends LocatorsFile implements DataFile{

	public WebDriver driver;
	public WebDriverWait wait;
	public Actions builder;
	public String msg;

	public void openBrowser() throws IOException, InterruptedException {
		
		File appDir = new File("ProjectData");	   
		File chDriver = new File(appDir, "chromedriver.exe");
		
		//Opening Chrome Browser
		System.setProperty("webdriver.chrome.driver", chDriver.getAbsolutePath());		
		driver = new ChromeDriver();
		
		//Setup Driver Property
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		wait = new WebDriverWait(driver,100);
		
		builder = new Actions(driver);
		
		PageFactory.initElements(driver, this);	

	}
	
	public void closeBrowser() {		
		driver.quit();
	}
	
	public void loginWithValidCredentials() throws Exception {	

		driver.get(baseURL + loginURL);	
		
		//Valid Credentials
		wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(validUserName);
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(validPassword);
		wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
		
		msg = wait.until(ExpectedConditions.visibilityOf(messageBox)).getText();
		
		Assert.assertTrue(msg.contains("You logged into a secure area!"));
		
	}
	
	public void loginWithInValidCredentials() throws Exception {	

		driver.get(baseURL + loginURL);	
		
		//Invalid Username & Valid Password
		wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(invalidUserName);
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(validPassword);
		wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
		
		msg = wait.until(ExpectedConditions.visibilityOf(messageBox)).getText();
		
		Assert.assertTrue(msg.contains("Your username is invalid!"));
		
		//Valid Username & Invalid Password
		wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(validUserName);
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(invalidPassword);
		wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
		
		msg = wait.until(ExpectedConditions.visibilityOf(messageBox)).getText();
		
		Assert.assertTrue(msg.contains("Your password is invalid!"));
		
		//Invalid Username & Invalid Password
		wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(invalidUserName);
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(invalidPassword);
		wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
		
		msg = wait.until(ExpectedConditions.visibilityOf(messageBox)).getText();
		
		Assert.assertTrue(msg.contains("Your username is invalid!"));
		
	}
	
	public void checkbox() throws Exception {	

		driver.get(baseURL + checkboxURL);	
		
		List<WebElement> checkboxList = driver.findElements(By.xpath("//*[@id=\"checkboxes\"]/input"));

		//Checkbox 1 - checked and unchecked
		if(checkboxList.get(0).isSelected()) {
			System.out.println("Checkbox1" + " -- " + " is checked.");
			checkboxList.get(0).click();
			System.out.println("Checkbox1" + " -- " + " is unchecked.");
		}
		else
		{
			System.out.println("Checkbox1" + " -- " + " is unchecked.");
			checkboxList.get(0).click();
			System.out.println("Checkbox1" + " -- " + " is checked.");
		}
	
		//Checkbox 2 - checked and unchecked
		if(checkboxList.get(1).isSelected()) {
			System.out.println("Checkbox2" + " -- " + " is checked.");
			checkboxList.get(1).click();
			System.out.println("Checkbox2" + " -- " + " is unchecked.");
		}
		else
		{
			System.out.println("Checkbox2" + " -- " + " is unchecked.");
			checkboxList.get(1).click();
			System.out.println("Checkbox2" + " -- " + " is checked.");
		}
		
	}
	
	public void contextMenu() throws Exception {	

		driver.get(baseURL + contextMenuURL);	
		
		wait.until(ExpectedConditions.visibilityOf(contextMenuBox));
		builder.contextClick(contextMenuBox).build().perform();		//Right Click on contect menu box
		
		Alert al = driver.switchTo().alert();

		Assert.assertTrue(al.getText().contains("You selected a context menu"));
		
		al.accept();
		
	}
	
	public void dragDrop() throws Exception {	

		driver.get(baseURL + dragAndDropURL);	
		
		wait.until(ExpectedConditions.visibilityOf(dragAndDropBoxA));
		wait.until(ExpectedConditions.visibilityOf(dragAndDropBoxB));
		
		System.out.println("Before Drag & Drop : " + dragAndDropBoxA.getText() + " & " + dragAndDropBoxB.getText());
		builder.dragAndDrop(dragAndDropBoxA, dragAndDropBoxB).build().perform();
		Thread.sleep(2000);
		System.out.println("After Drag & Drop : " + dragAndDropBoxA.getText() + " & " + dragAndDropBoxB.getText());
		
		Assert.assertTrue(dragAndDropBoxA.getText().contains("B"));
		Assert.assertTrue(dragAndDropBoxB.getText().contains("A"));
		
	}
	
	public void dropdown() throws Exception {	

		driver.get(baseURL + dropdownURL);	
		
		wait.until(ExpectedConditions.visibilityOf(dropdownList));
		
		Select s = new Select(dropdownList);
		
		s.selectByValue("1");
		Assert.assertTrue(dropdownList.getText().contains("Option 1"));
		
		Thread.sleep(2000);
		
		s.selectByVisibleText("Option 2");
		Assert.assertTrue(dropdownList.getText().contains("Option 2"));
		Thread.sleep(2000);
		
	}
	
	public void dynamicContent() throws Exception {	

		driver.get(baseURL + dynamicContentURL);	
		
		String pageSourceBeforeRefresh = driver.getPageSource();
		driver.navigate().refresh();
		driver.navigate().refresh();
		String pageSourceAfterRefresh = driver.getPageSource();

		Assert.assertNotEquals(pageSourceBeforeRefresh, pageSourceAfterRefresh);
		
	}
	
	public void dynamicControls() throws Exception {	

		driver.get(baseURL + dynamicControlsURL);	

		//Remove Checkbox
		wait.until(ExpectedConditions.visibilityOf(dynamicControlButtonAddRemove)).click();
		msg = wait.until(ExpectedConditions.visibilityOf(dynamicControlMsg)).getText();
		Assert.assertTrue(msg.contentEquals("It's gone!"));
		
		//Add Checkbox
		wait.until(ExpectedConditions.visibilityOf(dynamicControlButtonAddRemove)).click();
		msg = wait.until(ExpectedConditions.visibilityOf(dynamicControlMsg)).getText();
		Assert.assertTrue(msg.contentEquals("It's back!"));
		
		//Enable
		wait.until(ExpectedConditions.visibilityOf(dynamicControlButtonEnableDisable)).click();
		msg = wait.until(ExpectedConditions.visibilityOf(dynamicControlMsg)).getText();
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"input-example\"]/input")))).isEnabled());
		Assert.assertTrue(msg.contentEquals("It's enabled!"));
		
		//Disable
		wait.until(ExpectedConditions.visibilityOf(dynamicControlButtonEnableDisable)).click();
		msg = wait.until(ExpectedConditions.visibilityOf(dynamicControlMsg)).getText();
		Assert.assertFalse(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"input-example\"]/input")))).isEnabled());
		Assert.assertTrue(msg.contentEquals("It's disabled!"));
		
	}
	
	public void dynamicLoading() throws Exception {	

		driver.get(baseURL + dynamicLoadingURL);	
		
		wait.until(ExpectedConditions.visibilityOf(dynamicLoadingButton)).click();
		String actualString = wait.until(ExpectedConditions.visibilityOf(dynamicLoadingText)).getText();
		String expectedString = "Hello World!";
		
		Assert.assertEquals(actualString, expectedString);

	}
	
	public void fileDownload() throws Exception {
		
		driver.get(baseURL + downloadFileURL);
		
		wait.until(ExpectedConditions.visibilityOf(downloadFile)).click();
		
		Thread.sleep(3000);
		
		String filepath = System.getProperty("user.home") + "\\Downloads";
		String filename = "some-file.txt";
		
		Assert.assertTrue(isFileDownloaded(filepath,filename));
		
	}
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		  File dir = new File(downloadPath);
		  File[] dirContents = dir.listFiles();

		  for (int i = 0; i < dirContents.length; i++) {
		      if (dirContents[i].getName().equals(fileName)) {
		          // File has been found, it can now be deleted:
		          dirContents[i].delete();
		          return true;	// File Download
		      }
		  }
		  return false;	// File Not Download
	}
	
	public void fileUpload() throws Exception {
		
		driver.get(baseURL + uploadFileURL);
		
		File appDir = new File("ProjectData");	   
		File uploadFilePath = new File(appDir, "uploadFile.txt");

		wait.until(ExpectedConditions.visibilityOf(chooseFile)).sendKeys(uploadFilePath.getAbsolutePath());
		wait.until(ExpectedConditions.visibilityOf(uploadFile)).click();
		
		Thread.sleep(3000);
		
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(uploadFileMsg)).getText().contentEquals("File Uploaded!"));
		
	}
	
	public void floatingMenu() throws Exception {
		
		driver.get(baseURL + floatingMenuURL);
		
		//Before Floating
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(floatingMenuHome)).isDisplayed());
		
		JavascriptExecutor jse = (JavascriptExecutor)driver; 
		jse.executeScript("window.scrollBy(0,10000)","");
		
		Thread.sleep(3000);
		
		//After Floating
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(floatingMenuHome)).isDisplayed());

	}
	
	public void iFrame() throws Exception {
		
		driver.get(baseURL + iFrameURL);
		
		driver.switchTo().frame(0);
		
		wait.until(ExpectedConditions.visibilityOf(iFrameText)).sendKeys(Keys.CONTROL + "a");
		wait.until(ExpectedConditions.visibilityOf(iFrameText)).sendKeys(Keys.DELETE);
		
		wait.until(ExpectedConditions.visibilityOf(iFrameText)).sendKeys("This is New Text");
		
		Thread.sleep(1000);
		
		Assert.assertTrue(driver.getPageSource().contains("This is New Text"));
	
	}
	
	public void mouseHover() throws Exception {
		
		driver.get(baseURL + mouseHoverURL);
		
		//Mouser Hover on Image 1
		wait.until(ExpectedConditions.visibilityOf(mouseHoverImage1));
		builder.moveToElement(mouseHoverImage1).build().perform();
		Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(mouseHoverText1)).getText(), "name: user1");
		
		//Mouser Hover on Image 2
		wait.until(ExpectedConditions.visibilityOf(mouseHoverImage2));
		builder.moveToElement(mouseHoverImage2).build().perform();
		Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(mouseHoverText2)).getText(), "name: user2");
		
		//Mouser Hover on Image 3
		wait.until(ExpectedConditions.visibilityOf(mouseHoverImage3));
		builder.moveToElement(mouseHoverImage3).build().perform();
		Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(mouseHoverText3)).getText(), "name: user3");
		
	}
	
	public void javaScriptAlert() throws Exception {
		
		driver.get(baseURL + javaScriptAlertURL);
		Alert al;
		
		wait.until(ExpectedConditions.visibilityOf(jsAlertButton)).click();;
		al = driver.switchTo().alert();
		al.accept();
		Assert.assertEquals(jsResult.getText(), "You successfuly clicked an alert");

		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(jsConfirmButton)).click();;
		al = driver.switchTo().alert();
		al.accept();
		Assert.assertEquals(jsResult.getText(), "You clicked: Ok");
		
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(jsConfirmButton)).click();;
		al = driver.switchTo().alert();
		al.dismiss();
		Assert.assertEquals(jsResult.getText(), "You clicked: Cancel");
		
		Thread.sleep(1000);
	
		wait.until(ExpectedConditions.visibilityOf(jsPromptButton)).click();;
		al = driver.switchTo().alert();
		al.sendKeys("hi");
		al.accept();
		Assert.assertEquals(jsResult.getText(), "You entered: hi");	
		
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(jsPromptButton)).click();
		al = driver.switchTo().alert();
		al.sendKeys("hi");
		al.dismiss();
		Assert.assertEquals(jsResult.getText(), "You entered: null");	
		
		Thread.sleep(1000);
		
	}
	
	public void javaScriptError() throws Exception {
		
		driver.get(baseURL + javaScriptErrorURL);
		ExtractJSLogs();

	}
	
    public void ExtractJSLogs() {
        
    	LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            Assert.assertTrue(entry.getMessage().contains("Cannot read property 'xyz' of undefined"));
        }
        
    }
    
	public void newTab() throws Exception {
		
		driver.get(baseURL + newTabURL);
		
		wait.until(ExpectedConditions.visibilityOf(newTabLink)).click();

		Set<String> allWindows = driver.getWindowHandles();
		
		Iterator<String> iter = allWindows.iterator();
		String mainWindow = iter.next();
		String childWindow = iter.next();
			
		driver.switchTo().window(childWindow);
		Assert.assertTrue(driver.getPageSource().contains("New Window"));
	
	}
	
	public void messageNotification() throws Exception {
		
		driver.get(baseURL + messageNotificationURL);
		
		wait.until(ExpectedConditions.visibilityOf(messageNotificationLink)).click();
		
		String s = wait.until(ExpectedConditions.visibilityOf(messageNotification)).getText();
		System.out.println(s);
		
		boolean result;
		
		if(s.contains("Action successful") || s.contains("Action unsuccesful, please try again"))
			result = true;
		else
			result = false;
			
		Assert.assertTrue(result);

	}
    
}