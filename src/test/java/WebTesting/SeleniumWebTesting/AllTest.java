package WebTesting.SeleniumWebTesting;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import resources.base;

public class AllTest extends base {

	
	@Test()
	public void CheckBoxesTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/checkboxes");
		String expectedHomePageURL = "The Internet";;
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		//Saving check boxes in variables
		WebElement checkBox1 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[1]"));
		WebElement checkBox2 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]"));
		//Asserting when landed on page the check boxes are as expected or not
		Assert.assertFalse(checkBox1.isSelected());
		Assert.assertTrue(checkBox2.isSelected());
		//clicking the checkbox and asserting if it is as expected
		checkBox1.click();
		Assert.assertTrue(checkBox1.isSelected());
		Assert.assertTrue(checkBox2.isSelected());
		//clicking the checkbox and asserting if it is as expected
		checkBox2.click();
		Assert.assertTrue(checkBox1.isSelected());
		Assert.assertFalse(checkBox2.isSelected());
		//clicking the checkbox and asserting if it is as expected
		checkBox1.click();
		Assert.assertFalse(checkBox1.isSelected());
		Assert.assertFalse(checkBox2.isSelected());
		//clicking the checkbox and asserting if it is as expected
		checkBox2.click();
		Assert.assertFalse(checkBox1.isSelected());
		Assert.assertTrue(checkBox2.isSelected());
		
	}
	@Test()
	public void ContextMenuTest() throws IOException, InterruptedException
	{
		Actions action = new Actions(driver);
		//Driver navigating to the URL
		driver.get("http://localhost:7080/context_menu");
		String expectedHomePageURL = "The Internet";;
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		//saving menu in a variable to perform action
		WebElement contextMenu = driver.findElement(By.cssSelector("#hot-spot"));
		//performing context click with help of action
		action.contextClick(contextMenu).perform();
		//changing driver focus to alert
		Alert alert = driver.switchTo().alert(); 
		String expectedAlertMessage = "You selected a context menu";
		//Asserting if the text in alert is as expected
		Assert.assertEquals(alert.getText(),expectedAlertMessage);
		//clicking ok to change driver focus to window
		alert.accept();
	}
	
	@Test()
	public void DragDropTest() throws IOException, InterruptedException
	{
		Actions action = new Actions(driver);
		//Driver navigating to the URL
		driver.get("http://localhost:7080/drag_and_drop");
		String expectedHomePageURL = "The Internet";;
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		//grabbing web Elements and saving to move
		WebElement source = driver.findElement(By.id("column-a"));
		WebElement destination = driver.findElement(By.id("column-b"));
		//performing action drag and drop 
		action.dragAndDrop(source, destination).perform();
		
		//Asserting if drag and drop is successful or not
		Assert.assertEquals(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/header[1]")).getText(),"B");
		Assert.assertEquals(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/header[1]")).getText(),"A");

	}
	
	@Test()
	public void DropdownTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/dropdown");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		WebElement dropDown = driver.findElement(By.id("dropdown"));
		//Saving dropdown in a variable
		Select dropdown = new Select(dropDown);
		//selecting first indexed item from drop down
		dropdown.selectByIndex(1);
		String selected = dropdown.getFirstSelectedOption().getText();
		//Asserting if the correct item is being selected
		Assert.assertEquals(selected, "Option 1");
		//selecting second indexed item from drop down
		dropdown.selectByIndex(2);
		selected = dropdown.getFirstSelectedOption().getText();
		//Asserting if the correct item is being selected
		Assert.assertEquals(selected, "Option 2");
	}
	
	
	@Test()
	public void DynamicContentTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/dynamic_content");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		//saving web element for refresing the page
		WebElement clickHereRefresh = driver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(2) p:nth-child(3) > a:nth-child(2)"));
		
		String oldContent = driver.findElement(By.cssSelector("body")).getText();
		//refreshing through driver refresh button
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		String newContent = driver.findElement(By.cssSelector("body")).getText();
		//asserting if the old content is different then new content
		Assert.assertNotEquals(oldContent, newContent);
		
		String old1Content = driver.findElement(By.cssSelector("body:nth-child(2) > div.row:nth-child(2)")).getText();
		//Refreshing through webelement Grabbing element again to remove Stale Element reference exception
		clickHereRefresh = driver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(2) p:nth-child(3) > a:nth-child(2)"));
		clickHereRefresh.click();
		clickHereRefresh = driver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(2) p:nth-child(3) > a:nth-child(2)"));
		clickHereRefresh.click();
		Thread.sleep(1000);
		String new1Content = driver.findElement(By.cssSelector("body:nth-child(2) > div.row:nth-child(2)")).getText();
		//asserting if the old content is different then new content
		Assert.assertNotEquals(old1Content, new1Content);
	}
	
	
	@Test()
	public void DynamicControlsTest() throws IOException, InterruptedException
	{
		Boolean notPresent;
		Boolean present;
		//Driver navigating to the URL
		driver.get("http://localhost:7080/dynamic_controls");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		
		WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
		WebElement enableButton = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
		
		//clicking remove button
		removeButton.click();
			//wait variable for explicit wait
			WebDriverWait wait = new WebDriverWait(driver, 10000);
			//explicit wait
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add')]")));
			try
			{
				// checking if the checkbox is present or not
				notPresent = ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]"))).apply(driver);
				//Asserting if element is resent or not
				Assert.assertTrue(notPresent);
			}
			//handling no such element exception as element wont be present
			catch(NoSuchElementException e) {
				notPresent = true;
				//Asserting as element is not present
				Assert.assertTrue(notPresent);
			}
			
			WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
			// clicking Add button
			addButton.click();
			//explicit wait till remove button is visible
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Remove')]")));
			
			// checking if the checkbox is present or not
			present = ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]"))).apply(driver);
			//Asserting if the element is present or not
			Assert.assertFalse(present);

			// Clicking Enable button
			enableButton.click();
			// explicit wait
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Disable')]")));
			
			WebElement inputText = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[2]/input[1]"));
			//Asserting if the input text place is enabled or not
			Assert.assertTrue(inputText.isEnabled());

			
			
			WebElement disableButton = driver.findElement(By.xpath("//button[contains(text(),'Disable')]"));
			//disabled web element is clicked
			disableButton.click();
			//explicit wait
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enable')]")));
			//check if input text is enabled or not
			Assert.assertFalse(inputText.isEnabled());
			

			
	}
	
	
	@Test()
	public void DynamicLoadingTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/dynamic_loading/2");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		//wait variable created
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		
		WebElement startButton = driver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(2) div:nth-child(4) > button:nth-child(1)"));
		startButton.click();
		//Explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));
		String actual = driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).getText();
		//asserting if the output is same as expected
		Assert.assertEquals(actual, "Hello World!");
		
	}
	
	@Test()
	public void FileDownloadTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/download");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		//wait variable created
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		//webelement to download file
		WebElement downloadFile = driver.findElement(By.xpath("//a[contains(text(),'some-file.txt')]"));
		//To run this test change location according to your preference
		String expectedPath = "/Users/satinderpalsingh/Downloads/";
		String expectedFileName = "some-file.txt";
		//Path for downloading file and creating a file object
		File file = new File(expectedPath + expectedFileName);
		//checking if the file already exists in the location and deleting it
		if (file.exists())
		    file.delete();
		
		// downloading file here.
		downloadFile.click();
		Thread.sleep(2000);
		//Asserting if the file is available in the given location
		Assert.assertTrue(file.exists());
		
		//Not deleting the file as this file will be used for uploading in upload test
		
	}
	
	
	@Test()
	public void FileUploadTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/upload");
		String expectedHomePageURL = "The Internet";;
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		WebElement chooseFileButton , uploadButton , confirmationText;
		
		chooseFileButton = driver.findElement(By.cssSelector("#file-upload"));
		uploadButton = driver.findElement(By.cssSelector("#file-submit"));
		//defining path . please change path according to your system
		String expectedPath = "/Users/satinderpalsingh/Downloads/";
		String expectedFileName = "some-file.txt";
		//Path for uploading file and creating a file object
		File file = new File(expectedPath + expectedFileName);
		//sending path for selection of file
		chooseFileButton.sendKeys(expectedPath + expectedFileName);
		// clicking upload button
	     uploadButton.click();
	     confirmationText = driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]"));
	     //checking if the file is uploaded
	     Assert.assertTrue(confirmationText.isDisplayed());
		
	}

	

	@Test()
	public void FloatingMenuTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/floating_menu");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		WebElement menu = driver.findElement(By.cssSelector("#menu"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Assert.assertTrue(menu.isDisplayed());
		// This  will scroll down the page by  1000 pixel vertical		
        js.executeScript("window.scrollBy(0,1000)");
        
        //checking if the menu is still displayed or not after scrolling
        Assert.assertTrue(menu.isDisplayed());
	}

	
	@Test()
	public void iframeTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/iframe");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		
		WebElement iframe, editor_body;
		
		iframe = driver.findElement(By.cssSelector("#mce_0_ifr"));
		//switching driver focus to frame
		driver.switchTo().frame(iframe);
		
		editor_body = driver.findElement(By.xpath("//p[contains(text(),'Your content goes here.')]"));
		//sending text to frame
		editor_body.sendKeys("Check text");
		String expectedText = "Your content goes here.Check text";
		//checking if text is displayed as expected or not
		Assert.assertEquals(editor_body.getText(), expectedText);
		
	}
	

	@Test()
	public void JSAlertTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/javascript_alerts");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		WebElement jsAlert, jsConfirm, jsPrompt, result;
		String textToSend = "Hello message";
		//saving all the elements that are required
		jsAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
		jsConfirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
		jsPrompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
		result = driver.findElement(By.id("result"));
		
		//clicking Alert buttion
		jsAlert.click();
		//switching driver focus to alert
		Alert alert = driver.switchTo().alert();
		//Asserting if the message is as expected
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		// accepting the alert
		alert.accept();
		
		//clicking confirm button
		jsConfirm.click();
		//switching driver focus to alert
		alert = driver.switchTo().alert();
		//Asserting if the message is as expected
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		// accepting the alert
		alert.accept();
		
		jsPrompt.click();
		//switching driver focus to alert
		alert = driver.switchTo().alert();
		//Asserting if the message is as expected
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		//sending text into required field
		alert.sendKeys(textToSend);
		//accepting the alert
		alert.accept();
		//checking if the data entered in displayed or not
		Assert.assertEquals(result.getText(), "You entered: " + textToSend);
		
	}
	

	@Test()
	public void jsErrorTest1() throws IOException, InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		String script = "console.clear();";
	
		js.executeScript(script);
		boolean flag = false;
		//Driver navigating to the URL
				driver.get("http://localhost:7080/javascript_error");
				String expectedHomePageURL = "Page with JavaScript errors on load";
				//checking if driver landed on expected page
				Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
				//getting all the logentries 
			    LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
			    //splitting multiple entries to one by one scaning
			    java.util.List<LogEntry> logs= logEntries.getAll();
			    Assert.assertTrue(logs.get(1).getMessage().contains("Cannot read property 'xyz' of undefined")||logs.get(0).getMessage().contains("Cannot read property 'xyz' of undefined"));
				
		
	}
	
	@Test()
	public void LoginFailureTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/login");
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys("tomsmith123");
		lp.getpassword().sendKeys("SuperSecretPassword!123");
		lp.getLogin().click();
		System.out.println(driver.findElement(By.xpath("//div[@id='flash']")).getText());
		String actualTextLoggedIn = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		Assert.assertEquals(actualTextLoggedIn, "Your username is invalid!\n" + "×");
		
	}
	
	
	@Test()
	public void LoginSuccessTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/login");
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys("tomsmith");
		lp.getpassword().sendKeys("SuperSecretPassword!");
		lp.getLogin().click();
		System.out.println(driver.findElement(By.xpath("//div[@id='flash']")).getText());
		String actualTextLoggedIn = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		Assert.assertEquals(actualTextLoggedIn, "You logged into a secure area!\n" + "×");
		lp.getLogout().click();		
		actualTextLoggedIn = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		Assert.assertEquals(actualTextLoggedIn, "You logged out of the secure area!\n" + "×");
		
	}
	
	@Test()
	public void MouseHoverTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/hovers");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		
		//action object is created
		Actions action = new Actions(driver);
		WebElement hoverElement1 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]"));
		WebElement ExpectedHoverElement1 = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
		//performing hover on element
		action.moveToElement(hoverElement1).perform();
		//checking if the text is displayed
		Assert.assertTrue(ExpectedHoverElement1.isDisplayed());
		
		WebElement hoverElement2 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]"));
		WebElement ExpectedHoverElement2 = driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]"));
		//performing hover on element
		action.moveToElement(hoverElement2).perform();
		//checking if the text is displayed
		Assert.assertTrue(ExpectedHoverElement2.isDisplayed());
		
		WebElement hoverElement3 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[3]"));
		WebElement ExpectedHoverElement3 = driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]"));
		//performing hover on element
		action.moveToElement(hoverElement3).perform();
		//checking if the text is displayed
		Assert.assertTrue(ExpectedHoverElement3.isDisplayed());
	}
	
	@Test()
	public void NotificationMsgTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/notification_message_rendered");
		
		WebElement clickHere, flashMeassage;
		for(int i=0; i<4 ; i++)
		{
			clickHere = driver.findElement(By.xpath("//a[contains(text(),'Click here')]"));
			//Clicking on webelement to check the flash message
			clickHere.click();
			flashMeassage = driver.findElement(By.id("flash"));
			Boolean check = false;
			//checking if the flash message contains one of the multiple messages
			if (flashMeassage.getText().contains("Action successful\n" + 
					"×") || flashMeassage.getText().contains("Action unsuccesful, please try again\n" + 
							"×") || flashMeassage.getText().contains("Action Unsuccessful\n"
			+ "×"))
			{
				//changing to true as message is found in the flash message
				check = true;
			}
			Assert.assertTrue(check);
		}
		
	}
	
	
	@Test()
	public void OpenNewTabTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/windows");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		WebElement newWindow;
		WebElement clickHere= driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
		//click here element clicking
		clickHere.click();
		//getting all tabs into array list
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		//switching to new tab
	    driver.switchTo().window(tabs2.get(1));
		newWindow = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/h3[1]"));
		//checking if the driver focus is changed to new tab
		Assert.assertEquals(driver.getTitle(), "New Window");
		Assert.assertEquals(newWindow.getText(), "New Window");
	    //switching to back to first tab
	    driver.switchTo().window(tabs2.get(0));
	}

}
