package com.TestCases;

import org.testng.annotations.Test;

import com.Pages.BaseClass;
import com.Pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestCases extends BaseClass{


	LoginPage objLoginPage;
	//Actions action = new Actions(this.driver);
	//CheckBox Locators
	By checkBox_1=By.xpath("//input[@type='checkbox'][1]");
	By checkBox_2=By.xpath("//input[@type='checkbox'][2]");

	//context Menu locators
	By internetBox=By.id("hot-spot");

	// Drag and Drop Locators
	By boxA=By.id("column-a");
	By boxB=By.id("column-b");

	// Drop down Locators
	By dropDownMenu=By.id("dropdown");

	// Dynamic Content Locators
	By image1Content=By.xpath("(//div[@class='large-10 columns'])[1]");
	By image2Content=By.xpath("(//div[@class='large-10 columns'])[2]");

	// Dynamic Controls Locators
	By checkBox=By.xpath("//input[@type='checkbox']");
	By removeButton=By.xpath("//button[contains(text(),'Remove')]");
	By addButton=By.xpath("//button[contains(text(),'Add')]");
	By enableDisableField= By.xpath("//input[@type='text']");
	By enableButton= By.xpath("//button[contains(text(),'Enable')]");
	By disableButton=By.xpath("//button[contains(text(),'Disable')]");

	//Dynamic Loading Locators
	By startButton= By.cssSelector("div#start button");
	By helloWorldText=By.cssSelector("div#finish");

	//File Download Locators
	By fileDownloadLink =By.linkText("some-file.txt");

	//File Upload Locators
	By chooseFile= By.id("file-upload");
	By uploadButton=By.id("file-submit");
	By uploadedFile=By.id("uploaded-files");


	// Floating Menu Locators
	By homeMenu= By.xpath("//a[@href='#home']");
	By newsMenu=By.xpath("//a[@href='#news']");
	By contactMenu=By.xpath("//a[@href='#contact']");

	// iframe Locators
	By iframeBox=By.id("mce_0_ifr");
	By textBox=By.xpath("//body[@id='tinymce']");

	// hover locators
	By hoverImage1=By.xpath("(//img[@src='/img/avatar-blank.jpg'])[1]");
	By hoverImage2=By.xpath("(//img[@src='/img/avatar-blank.jpg'])[2]");
	By hoverImage3=By.xpath("(//img[@src='/img/avatar-blank.jpg'])[3]");

	By userText1=By.xpath("(//div/h5)[1]");
	By userText2=By.xpath("(//div/h5)[2]");
	By userText3=By.xpath("(//div/h5)[3]");
	By userProfile1= By.xpath("//a[@href='/users/1']");
	By userProfile2= By.xpath("//a[@href='/users/2']");
	By userProfile3= By.xpath("//a[@href='/users/3']");

	// JavaScript Alert Locators

	By jsAlertButton=By.xpath("//button[contains(text(),'Click for JS Alert')]");
	By jsConfirmButton=By.xpath("//button[contains(text(),'Click for JS Confirm')]");
	By jsPromptButton=By.xpath("//button[contains(text(),'Click for JS Prompt')]");
	By jsEnteredText=By.id("result");

	// New Window Locators
	By clickHereLink=By.linkText("Click Here");
	By newWindowText=By.cssSelector("h3");

	//Notification Message Locators
	By clickhereLink=By.linkText("Click here");
	By headerMessage= By.id("flash"); 

	@BeforeMethod
	public void setUp() {
		startBrowser();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


	// verify Login Login Success
	@Test
	public void testLoginSuccesfully() {
		objLoginPage=new LoginPage();
		driver.get(prop.getProperty("loginUrl"));
		String actualLoginPageTitle=objLoginPage.getLoginPageHeader();
		assertEquals(actualLoginPageTitle, "Login Page");;
		objLoginPage.loginCred(prop.getProperty("userName"), prop.getProperty("password"));
		String loginSuccessMessage=objLoginPage.getSecureHeaderText();	
		assertEquals(loginSuccessMessage, "Welcome to the Secure Area. When you are done click logout below.");
	}
	// verify Login Failure
	@Test
	public void testLoginFailure() {
		objLoginPage=new LoginPage();
		driver.get(prop.getProperty("loginUrl"));
		String actualLoginPageTitle=objLoginPage.getLoginPageHeader();
		assertEquals(actualLoginPageTitle, "Login Page");
		objLoginPage.loginCred(prop.getProperty("invalidUserName"), prop.getProperty("invalidPassword"));
		String actualText=objLoginPage.getInvalidUserText();
		assertEquals(actualText.contains("Your username is invalid!"), true);

	}

	@Test
	public void testCheckBox() {
		driver.get(prop.getProperty("checkBoxUrl"));
		//check checkbox1
		waitforElementLocated(checkBox_1);
		driver.findElement(checkBox_1).click();
		//uncheck checkbox2
		driver.findElement(checkBox_2).click();
		//verify checkbox 1 is selected
		assertEquals(driver.findElement(checkBox_1).isSelected(), true);
		//verify checkbox 2 is Notselected
		assertEquals(driver.findElement(checkBox_2).isSelected(), false);

	}

	@Test
	public void testContextMenu() {
		driver.get(prop.getProperty("contextMenuUrl"));
		// to verify we are on context Menu Page
		waitforElementLocated(internetBox);
		Actions action = new Actions(driver);
		//right click on element
		action.contextClick(driver.findElement(internetBox)).perform();
		Alert alert=driver.switchTo().alert();
		//verify JavaScript alert text on menu
		assertEquals(alert.getText(), "You selected a context menu");
		alert.accept();


	}
	@Test
	public void testDragAndDrop() throws InterruptedException{
		driver.get(prop.getProperty("dragAndDrop"));
		// to verify we are on Drag & drop Page
		Actions action = new Actions(driver);
		waitforElementLocated(boxA);
		action.clickAndHold(driver.findElement(boxA)).moveToElement(driver.findElement(boxB)).build();
		action.dragAndDrop(driver.findElement(boxA), driver.findElement(boxB)).build().perform();



	}

	@Test
	public void testDropDown() throws InterruptedException{
		driver.get(prop.getProperty("dropDownUrl"));
		// to verify we are on drop dowm page

		waitforElementLocated(dropDownMenu);
		Select select =new Select(driver.findElement(dropDownMenu));

		// Select and Verify Option 1 is selected
		select.selectByVisibleText("Option 1");
		assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
		// Select and Verify Option 2 is selected
		select.selectByVisibleText("Option 2");
		assertEquals(select.getFirstSelectedOption().getText(), "Option 2");


	}

	@Test
	public void testDynamicContent()

	{
		driver.get(prop.getProperty("dynamicContentUrl"));
		waitforElementLocated(image1Content);
		//Get the content before refresh
		String text1BeforeRefresh=driver.findElement(image1Content).getText();
		String text2BeforeRefresh=driver.findElement(image2Content).getText();
		//refresh the page
		driver.navigate().refresh();
		//Again fetch the content and compare they are not equal, they have changed

		String text1AfterRefresh_1=driver.findElement(image1Content).getText();
		String text2AfterRefresh_1=driver.findElement(image2Content).getText();
		assertEquals(text1AfterRefresh_1.contains(text1BeforeRefresh), false);
		assertEquals(text2AfterRefresh_1.contains(text2BeforeRefresh), false);

		// refresh 2nd time
		driver.navigate().refresh();

		String text1AfterRefresh_2=driver.findElement(image1Content).getText();
		String text2AfterRefresh_2=driver.findElement(image2Content).getText();

		assertEquals(text1AfterRefresh_1.contains(text1AfterRefresh_2), false);
		assertEquals(text2AfterRefresh_1.contains(text2AfterRefresh_2), false);


	}
	@Test
	public void testDynamicControls() {
		driver.get(prop.getProperty("dynamicControlUrl"));
		WebDriverWait wait = new WebDriverWait(driver, 15);
		//Verify to check element is present
		wait.until(ExpectedConditions.presenceOfElementLocated(checkBox));
		Assert.assertTrue(driver.findElements(checkBox).size() > 0);
		// remove the element and verify element is no more visible 
		driver.findElement(removeButton).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(checkBox)));
		Assert.assertTrue(driver.findElements(checkBox).size() == 0);

		// click add button and verify element is visible 
		driver.findElement(addButton).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(checkBox));
		Assert.assertTrue(driver.findElements(checkBox).size() >=1);

		// Test clicks on the Enable Button and uses explicit wait.
		Assert.assertEquals(driver.findElement(enableDisableField).isEnabled(), false);
		driver.findElement(enableButton).click();
		//verify field got enabled and enable button disappeared 
		wait.until(ExpectedConditions.invisibilityOfElementLocated(enableButton));
		Assert.assertEquals(driver.findElement(enableDisableField).isEnabled(), true);

		//click on Disable button and verify it got disable
		driver.findElement(disableButton).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(disableButton));
		Assert.assertEquals(driver.findElement(enableDisableField).isEnabled(), false);

	}
	@Test
	public void testDynamicLoading()
	{
		driver.get(prop.getProperty("dynamicLoadingUrl"));
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(startButton));
		driver.findElement(startButton).click();
		//verify text appeared after click
		wait.until(ExpectedConditions.presenceOfElementLocated(helloWorldText));
		Assert.assertEquals(driver.findElement(helloWorldText).getText(), "Hello World!");

	}

	@Test
	public void testfileDownload() throws InterruptedException{
		//clean up before download
		File file = new File(projectLocation+"\\src\\main\\resources\\download\\some-file.txt"); 
		if(file.delete()) {
			System.out.println("File deleted");
		}
		else {
			System.out.println("File Not Present");
		}

		driver.get(prop.getProperty("fileDownloadUrl"));
		waitforElementLocated(fileDownloadLink);
		driver.findElement(fileDownloadLink).click();
		Thread.sleep(2000);
		// verify downloaded file
		if(file.exists()) {
			Assert.assertTrue(true,"Downloaded File verified successfully");
		}
		else {
			Assert.assertTrue(false,"File Doesn't exits");
		}

	}
	@Test
	public void testUploadFile() {
		driver.get(prop.getProperty("fileUplaodUrl"));
		String fileName="some-file.txt";
		driver.findElement(chooseFile).sendKeys(projectLocation+"\\src\\main\\resources\\Files\\"+fileName);
		driver.findElement(uploadButton).click();
		waitforElementLocated(uploadedFile);
		Assert.assertEquals(driver.findElement(uploadedFile).getText().trim(), fileName);
	}

	@Test
	public void testFloatingMenu() {
		driver.get(prop.getProperty("floatingMenuUrl"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1400)", "");
		Assert.assertEquals(driver.findElement(homeMenu).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(newsMenu).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(contactMenu).isDisplayed(), true);
	}
	@Test
	public void testIframe() {
		driver.get(prop.getProperty("frameUrl"));
		driver.switchTo().frame(driver.findElement(iframeBox));
		driver.findElement(textBox).clear();
		String textToType="Iframe Test in box";
		driver.findElement(textBox).sendKeys(textToType);
		Assert.assertEquals(driver.findElement(textBox).getText().trim(), textToType);

	}

	@Test
	public void testMouseHover(){
		driver.get(prop.getProperty("hoverUrl"));
		Actions action = new Actions(driver);

		// Hover on first Image and verify other details
		action.moveToElement(driver.findElement(hoverImage1)).perform();
		Assert.assertEquals(driver.findElement(userText1).getText().trim(), "name: user1");
		Assert.assertEquals(driver.findElement(userProfile1).getText().trim(), "View profile");

		// Hover on Second Image and verify other details
		action.moveToElement(driver.findElement(hoverImage2)).perform();
		Assert.assertEquals(driver.findElement(userText2).getText().trim(), "name: user2");
		Assert.assertEquals(driver.findElement(userProfile2).getText().trim(), "View profile");

		// Hover on Third Image and verify other details
		action.moveToElement(driver.findElement(hoverImage3)).perform();
		Assert.assertEquals(driver.findElement(userText3).getText().trim(), "name: user3");
		Assert.assertEquals(driver.findElement(userProfile3).getText().trim(), "View profile");
	}

	@Test
	public void testJavaScriptAlert() {
		driver.get(prop.getProperty("javaScriptUrl"));
		waitforElementLocated(jsAlertButton);
		//click on JS Alert Button and asserts alert message.
		driver.findElement(jsAlertButton).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS Alert");	
		alert.accept();

		//click JS confirm Button and clicks ok on alert.
		driver.findElement(jsConfirmButton).click();
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");	
		alert.accept();
		//clicks on JS Prompt Button and types a message on Prompt.
		driver.findElement(jsPromptButton).click();
		String typeMessage="To verify we are on JS prompt";
		alert.sendKeys(typeMessage);
		alert.accept();
		Assert.assertEquals(driver.findElement(jsEnteredText).getText(), "You entered: "+typeMessage);



	}

	@Test
	public void testJavaScriptError() {
		driver.get(prop.getProperty("javaScriptErrorUrl"));
		LogEntries logEnt=driver.manage().logs().get(LogType.BROWSER);
		String combinedString = "";
		for(LogEntry entry:logEnt) {
			combinedString=combinedString+entry.getMessage();
		}

		if(combinedString.contains("Cannot read properties of undefined (reading 'xyz')")){
			Assert.assertTrue(true, "page contains respective javascript error:");
		}
		else {
			Assert.assertTrue(false, "page doesn't respective contains javascript error:");
		}
	}
	@Test
	public void testNewTab() {
		driver.get(prop.getProperty("newTabUrl"));
		waitforElementLocated(clickHereLink);
		driver.findElement(clickHereLink).click();
		String parent=driver.getWindowHandle();

		Set<String> allWindows=driver.getWindowHandles();
		Iterator<String> itr = allWindows.iterator();
		while (itr.hasNext()) {
			String ChildWindow = itr.next();
			if (!parent.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:7080/windows/new");
				Assert.assertEquals(driver.findElement(newWindowText).getText(), "New Window");
				driver.close();

			}
		}
		driver.switchTo().window(parent);
	}

	@Test
	public void testNotificationMessage() {
		driver.get(prop.getProperty("notificationMessageUrl"));
		waitforElementLocated(clickhereLink);
		driver.findElement(clickhereLink).click();
		String actualHeaderMessage=driver.findElement(headerMessage).getText().trim();
		if(actualHeaderMessage.contains("Action successful")||actualHeaderMessage.contains("Action unsuccesful, please try again")||actualHeaderMessage.contains("Action Unsuccessful")) {
			Assert.assertTrue(true, "One of the Message verified successfully");
		}
		else {
			Assert.assertTrue(false, "Message verification failed");
		}

	}
}