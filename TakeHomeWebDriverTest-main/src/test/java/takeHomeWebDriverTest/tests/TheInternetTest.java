package takeHomeWebDriverTest.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
import takeHomeWebDriverTest.pageObjects.LoginPage;
import takeHomeWebDriverTest.testComponents.BaseTest;

public class TheInternetTest extends BaseTest{
		
	@Test(priority = 1)
	public void test1_LoginSuccess()
	{
		String userName = "tomsmith";
		String password = "SuperSecretPassword!";
		driver.get(url + "/login");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginApplication(userName, password);
		String loginMessage = loginPage.getLoginMessage().replace("\n", "").replace("×", "");
		System.out.println("Login Message : " + loginMessage);
		Assert.assertTrue(loginMessage.equals("You logged into a secure area!"), "Login was unsuccessful");
	}
	
	@Test(priority = 2)
	public void test2_LoginFailure()
	{
		String userName = "invalidUser";
		String password = "WrongPassword!";
		driver.get(url + "/login");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginApplication(userName, password);
		String loginMessage = loginPage.getLoginMessage().replace("\n", "").replace("×", "");;
		System.out.println("Login Message : " + loginMessage);
		Assert.assertTrue(loginMessage.equals("Your username is invalid!"), "Login was successful");
	}
	
	@Test(priority = 3)
	public void test3_CheckBoxes()
	{
		driver.get(url + "/checkboxes");
				
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		int i = 1;
		for (WebElement checkBox : checkBoxes)
		{
			if(checkBox.isSelected())
			{
				System.out.println("Checkbox " + i + " is checked");
				
				checkBox.click();
				
				Assert.assertTrue(!checkBox.isSelected(), "The checkbox was not unchecked");
			}
			else
			{
				System.out.println("Checkbox " + i + " is unchecked");
				
				checkBox.click();
				
				Assert.assertTrue(checkBox.isSelected(), "The checkbox was not checked");
			}
			
			i++;
		}
	}
	
	@Test(priority = 4)
	public void test4_ContextMenu()
	{
		driver.get(url + "/context_menu");
		WebElement contextMenuWindow = driver.findElement(By.id("hot-spot"));
		Actions actions = new Actions(driver);
		actions.contextClick(contextMenuWindow).perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.alertIsPresent());
		
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("The alert message says : " + alertMessage);
		Assert.assertTrue(alertMessage.equals("You selected a context menu"));
		
		driver.switchTo().alert().accept();
			
	}
	
	@Test(priority = 5)
	public void test5_DragAndDrop() 
	{
		// Open Issue as drag and drop is not working on HTML 5 elements. 
		//https://github.com/SeleniumHQ/selenium/issues/3269
		//Alternative is to use a JavaScriptExecutor to work on the elements instead
		
		driver.get(url + "/drag_and_drop");
		WebElement eleA = driver.findElement(By.id("column-a"));
		WebElement eleB = driver.findElement(By.id("column-b"));
		String eleAText = eleA.getText(), eleBText = eleB.getText();
		
		System.out.println("Element " + eleAText + " is present first and then Element " + eleBText);
		
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
				                    + "simulateHTML5DragAndDrop(source,destination);", eleA, eleB);
				
		System.out.println("After drag and drop, the Element " + eleA.getText() + " is present first and then Element " + eleB.getText());
		
		Assert.assertTrue(eleA.getText().equals(eleBText) && eleB.getText().equals(eleAText), "Drag and Drop wasn't performed correctly" );
		
		
	}	
	
	@Test(priority = 6)
	public void test6_Dropdown()
	{
		driver.get(url + "/dropdown");
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		
		System.out.println("Current selected value : " + dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByValue("1");
		
		Assert.assertTrue(dropdown.getFirstSelectedOption().getText().equals("Option 1"), "'Option 1' is not selected");
		
		dropdown.selectByValue("2");
		
		Assert.assertTrue(dropdown.getFirstSelectedOption().getText().equals("Option 2"), "'Option 2' is not selected");
		
	}
	
	@Test(priority = 7)
	public void test7_DynamicContent()
	{
		driver.get(url + "/dynamic_content");
		
		List<WebElement> images = driver.findElements(By.cssSelector(".large-2 img"));
		
		List<WebElement> texts = driver.findElements(By.cssSelector(".large-centered .large-10"));
		
		String[] imgSrcs = new String[images.size()];
		String[] textValues = new String[texts.size()];

		for(int i = 0; i < images.size(); i++)
		{
			imgSrcs[i] = images.get(i).getAttribute("src");
			textValues[i] = texts.get(i).getText();
		}
		
		for (int i=1; i < 5 ; i++)
		{
			driver.navigate().refresh();
			images = driver.findElements(By.cssSelector(".large-2 img"));
			texts = driver.findElements(By.cssSelector(".large-centered .large-10"));
			System.out.println("*************Run " + i + "*****************");
			
			for (int j = 0 ; j < images.size() ; j++)
			{
				String tempImgSrc = images.get(j).getAttribute("src");
				String tempTextValue = texts.get(j).getText();
				
				System.out.println("--------------------------------------------------------");
				System.out.println("Previous Image Src in row " + j + " \t: \t" + imgSrcs[j]);
				System.out.println("Image Src after refresh in row " + j + "  : \t" + tempImgSrc);
				
				System.out.println("--------------------------------------------------------");
				System.out.println("Previous text value in row " + j + " \t: \t" + textValues[j]);
				System.out.println("Text value after refresh in row " + j + "  : \t" + tempTextValue);
				
				System.out.println("--------------------------------------------------------");
				
				//Warning :
				//The image does not always change on refresh. This will lead to test failure.
				//If the checking of images is not required, comment the below assert
				Assert.assertTrue(!imgSrcs[j].equals(tempImgSrc), "The image source after refresh is the same");
				Assert.assertTrue(!textValues[j].equals(tempTextValue), "The text value after refresh is the same");
				
				imgSrcs[j] = tempImgSrc;
				textValues[j] = tempTextValue;
			}
		}
	}
	
	@Test(priority = 8)
	public void test8_DynamicControls()
	{
		driver.get(url + "/dynamic_controls");
		
		WebElement addRemoveButton = driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']"));
						
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		addRemoveButton.click();
		
		System.out.println("---------------------------------------------");
		System.out.println("Verify Removing and Adding of CheckBox");
		System.out.println("Clicking on Remove button and verifying");
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
				
		Assert.assertTrue(driver.findElements(By.cssSelector("input[type='checkbox']")).size() == 0, "Checkbox is not removed");
		
		addRemoveButton.click();
		System.out.println("Clicking on Add button and verifying");
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
				
		Assert.assertTrue(driver.findElements(By.cssSelector("input[type='checkbox']")).size() == 1, "Checkbox is not added");
		
		System.out.println("---------------------------------------------");
		System.out.println("Verify Enabling and Disabling of Input Text");
		System.out.println("Clicking on Enable button and verifying");
		WebElement inputText = driver.findElement(By.cssSelector("input[type='text']"));
		
		
		System.out.println("The textbox is currently Enabled : " + inputText.isEnabled());
		WebElement enableDisableButton = driver.findElement(By.cssSelector("button[onclick='swapInput()']"));
		
		enableDisableButton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		
		Assert.assertTrue(inputText.isEnabled(), "The input text is not enabled after clicking on enable button");
		
		System.out.println("Clicking on Disable button and verifying");
		enableDisableButton.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("message")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		
		Assert.assertTrue(!inputText.isEnabled(), "The input text is not disabled after clicking on disable button");
		
	}
	
	@Test(priority = 9)
	public void test9_DynamicLoading()
	{
		driver.get(url + "/dynamic_loading/2");
		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
		
		Assert.assertTrue(driver.findElement(By.id("finish")).getText().equals("Hello World!"), "Hello World! is not displayed");
			
	}
	
	@Test(priority = 10)
	public void test10_FileDownload() throws InterruptedException
	{
		driver.get(url + "/download");
		
		String home = System.getProperty("user.home");
		
		File file = new File(home+"/Downloads/some-file.txt");
		
		if(file.exists())
			file.delete();
		
		driver.findElement(By.cssSelector("a[href='download/some-file.txt']")).click();
		
		Thread.sleep(2000);
		
		Assert.assertTrue(file.exists(), "File is not downloaded");
				
	}
	
	@Test(priority = 11)
	public void test11_FileUpload() throws IOException
	{
		driver.get(url + "/upload");
		
		File file = new File("dummyFileUpload.txt");
		
		if(!file.exists())
			file.createNewFile();
		
		driver.findElement(By.id("file-upload")).sendKeys(file.toPath().toAbsolutePath().toString());
				
		driver.findElement(By.id("file-submit")).click();
		
		Assert.assertTrue(driver.findElement(By.id("uploaded-files")).getText().equals(file.toString()), "File is not uploaded");
		
		file.delete();
	}
	
	@Test(priority = 12)
	public void test12_FloatingMenu() throws InterruptedException
	{
		driver.get(url + "/floating_menu");
		
		WebElement menu = driver.findElement(By.id("menu"));
		int x = menu.getLocation().x;
		int y = menu.getLocation().y;
				
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
				
		//Verify not only that the menu is displayed, but also that the object has moved down along with scroll
		Assert.assertTrue(menu.isDisplayed() && menu.getLocation().y > y && menu.getLocation().x == x , "Menu is not displayed after scrolling down");				
	}
	
	@Test(priority = 13)
	public void test13_Iframe()
	{
		driver.get(url + "/iframe");
		
		WebElement frame = driver.findElement(By.id("mce_0_ifr"));
		driver.switchTo().frame(frame);
		
		WebElement innerFrameText = driver.findElement(By.id("tinymce"));
		String textToEnter = "Validating if this text is typed in frame.";
		innerFrameText.clear();
		innerFrameText.sendKeys(textToEnter);
		System.out.println("Text after typing in frame : " + innerFrameText.getText());
		Assert.assertTrue(innerFrameText.getText().equals(textToEnter), "The typed text is not the same as what is displayed");
				
	}
	
	@Test(priority = 14)
	public void test14_MouseHover() 
	{
		driver.get(url + "/hovers");
		
		Actions action = new Actions(driver);
		
		
		List<WebElement> profileImages = driver.findElements(By.cssSelector(".example img"));
		
		for(int i = 0; i < profileImages.size() ; i ++)
		{
			int j = i + 1;
			action.moveToElement(profileImages.get(i)).build().perform();
			
			WebElement infoElement = driver.findElement(By.xpath("(//div[@class='figure']/img)["+j+"]/following-sibling::div[@class='figcaption']"));
			Assert.assertTrue(infoElement.isDisplayed(),
					"Additional Information of Profile " + i + "is not displayed after hovering over the image");
			
			System.out.println("Additional Information of Profile : " + j);
			System.out.println(infoElement.findElement(By.tagName("h5")).getText());
			System.out.println(infoElement.findElement(By.tagName("a")).getAttribute("href"));
			System.out.println("----------------------------------------------------------------");
		}
	}
	
	@Test(priority = 15)
	public void test15_JavaScriptAlerts()
	{
		driver.get(url + "/javascript_alerts");
		
		driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
		
		driver.switchTo().alert().dismiss();
		
		System.out.println("Alert Message after Accepting JsAlert : " + driver.findElement(By.id("result")).getText());
		
		Assert.assertTrue(driver.findElement(By.id("result")).getText().equals("You successfuly clicked an alert"), "The alert message is not as expected");
		
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		
		driver.switchTo().alert().accept();
		
		System.out.println("Alert Message after Accepting JsConfirm : " + driver.findElement(By.id("result")).getText());
		
		Assert.assertTrue(driver.findElement(By.id("result")).getText().equals("You clicked: Ok"), "The alert message is not as expected");
		
		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		
		String textToEnter = "Entering text in prompt";
		
		driver.switchTo().alert().sendKeys(textToEnter);
		driver.switchTo().alert().accept();
		
		System.out.println("Alert Message after Accepting JsConfirm : " + driver.findElement(By.id("result")).getText());
		
		Assert.assertTrue(driver.findElement(By.id("result")).getText().equals("You entered: " + textToEnter), "The alert message is not as expected");
		
	}
	
	@Test(priority = 16)
	public void test16_JavaScriptError()
	{
		driver.get(url + "/javascript_error");
		
		LogEntries errorLogs = driver.manage().logs().get(LogType.BROWSER);
		
		
		boolean bErrorFound = false;
		
		for (LogEntry error : errorLogs.getAll())
		{
			System.out.println("Error Message : " + error.getMessage());
			if(error.getMessage().contains("Cannot read properties of undefined (reading 'xyz')"))
			{
				bErrorFound = true;
				break;
			}
		}
		
		Assert.assertTrue(bErrorFound, "The expected JavaScript error is not present");
	}
	
	@Test(priority = 17)
	public void test17_OpenInNewTab()
	{
		driver.get(url + "/windows");
		
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		Iterator<String> it = windowHandles.iterator();
		
		String parentHandle = it.next();
		String childHandle = it.next();
		
		driver.switchTo().window(childHandle);
		Assert.assertTrue(driver.getTitle().equals("New Window"), "The title does not match New Window");
		
		driver.close();
		driver.switchTo().window(parentHandle);
		
	}
	
	@Test(priority = 18)
	public void test18_NotificationMessage()
	{
		driver.get(url + "/notification_message_rendered");
		
		ArrayList<String> expectedActionMessages = new ArrayList<String>();
		expectedActionMessages.add("Action successful");
		expectedActionMessages.add("Action unsuccesful, please try again");
		expectedActionMessages.add("Action Unsuccessful");
		
		for (int i = 1 ; i <= 20 ; i++)
		{
			driver.findElement(By.linkText("Click here")).click();
			String alertMessage = driver.findElement(By.id("flash")).getText().trim().replace("\n","").replace("×","");
			
			System.out.println("Alert message after clicking " + i + " times : " + alertMessage);
			Assert.assertTrue(expectedActionMessages.contains(alertMessage), "Invalid Alert Message displyed");
		}
		
	}
	

}
