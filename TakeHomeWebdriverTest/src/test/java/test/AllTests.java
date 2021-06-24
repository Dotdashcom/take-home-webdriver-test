package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import testBase.TestBase;

public class AllTests extends TestBase {
	LoginPage lp;
	
	public AllTests() {
		super();
		lp = new LoginPage();
	}
	
	@BeforeTest
	public void beforeAllTests() {
		setup();
	}

	@AfterTest
	public void afterAllTests() {
		teardown();
	}
	
	//Login Success Test
	@Test(priority = 1)
	public void loginSuccessTest() {
		driver.get("http://localhost:7080/login");
		lp.inputUsername("tomsmith");
		lp.inputPassword("SuperSecretPassword!");
		lp.clickLoginBtn();
		Assert.assertEquals(driver.findElement(By.xpath("//h4[contains(text(),'Welcome to the Secure Area.')]")).getText(), "Welcome to the Secure Area. When you are done click logout below.");
	}
	
	//Login Failure Test
	@Test(priority = 2)
	public void loginFailureTest() {
		driver.get("http://localhost:7080/login");
		lp.inputUsername("username");
		lp.inputPassword("password");
		lp.clickLoginBtn();
		WebElement actualFlashMsg = driver.findElement(By.id("flash"));
		Assert.assertTrue(actualFlashMsg.getText().contains("Your username is invalid!"));
	}
	
	//CheckBoxes Test
	@Test(priority = 3)
	public void checkBox1Test() {
		driver.get("http://localhost:7080/checkboxes");
		WebElement checkbox1 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[1]"));
		checkbox1.click(); //checkbox 1 "checked" click
		Assert.assertEquals(true, checkbox1.isSelected());
		checkbox1.click(); // checkbox 1 "unchecked click;
		Assert.assertEquals(false, checkbox1.isSelected());
	}
	
	@Test(priority = 4)
	public void checkBox2Test() {
		WebElement checkbox2 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]"));
		checkbox2.click(); //check box 2 "unchecked" click
		Assert.assertEquals(false, checkbox2.isSelected());
		checkbox2.click(); //check box 2 "checked click;
		Assert.assertEquals(true, checkbox2.isSelected());
	}
	
	//ContextMenu Test
	@Test(priority = 5)
	public void contextMenuTest()  {
		driver.get("http://localhost:7080/context_menu");
		Actions action = new Actions(driver);
		WebElement contextMenu = driver.findElement(By.id("hot-spot"));
		action.contextClick(contextMenu).build().perform();
		Alert alert = driver .switchTo().alert();
		String alertText = alert.getText();
		Assert.assertEquals(alertText, "You selected a context menu");
	}
	
	//Drag and Drop Test
	@Test(priority = 6)
	//Test for some reason fails because the dragAndDrop function does not work even though I put the correct location for the source and destination
	public void DragAndDropTest()  {
	driver.get("http://localhost:7080/drag_and_drop");
	WebElement elementA = driver.findElement(By.id("column-a"));
	WebElement elementB = driver.findElement(By.id("column-b"));
	Actions action = new Actions(driver);
		action.dragAndDrop(elementA, elementB); //Drag and Drop not working automatically only manually
		Assert.assertEquals(elementA.getText(), "B");
	}
	

	//Drop down Test
	@Test(priority = 7)
	public void option2Test() {
		driver.get("http://localhost:7080/dropdown");
		WebElement selectOption = driver.findElement(By.id("dropdown"));
		Select select = new Select(selectOption);
		select.selectByVisibleText("Option 2");
		String SelectedOptionText = select.getFirstSelectedOption().getText();
		Assert.assertEquals(SelectedOptionText, "Option 2");
	}
	
	@Test(priority = 8)
	public void option1Test() {
		WebElement selectOption = driver.findElement(By.id("dropdown"));
		Select select = new Select(selectOption);
		select.selectByVisibleText("Option 1");
		String SelectedOptionText = select.getFirstSelectedOption().getText();
		select.selectByVisibleText("Option 1");
		Assert.assertEquals(SelectedOptionText, "Option 1");
	}
	
	//Dynamic Content Test
	@Test(priority = 9)
	public void dynamicContentTest() {
		driver.get("http://localhost:7080/dynamic_content");		
		for (int i = 0; i < 3; i++) {
			  String old1stTxtBlock = driver.findElement(By.xpath("//div[@id='content']")).getText();
			  driver.navigate().refresh();
			  String new1stTxtBlock = driver.findElement(By.xpath("//div[@id='content']")).getText();
			  Assert.assertNotEquals(old1stTxtBlock, new1stTxtBlock);
			}

	}
	
	//Dynamic Controls Test
	@Test(priority = 10)
	public void DynamicControlsTest() {
		driver.get("http://localhost:7080/dynamic_controls");		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement removeBtn = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
		removeBtn.click();
		WebElement goneMsg = driver.findElement(By.xpath("//p[contains(text(),'gone!')]"));
		wait.until(ExpectedConditions.visibilityOf(goneMsg));
		Assert.assertEquals(goneMsg.getText(), "It's gone!");
		
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		WebElement checkBox = driver.findElement(By.id("checkbox"));
		wait.until(ExpectedConditions.visibilityOf(checkBox));
		Assert.assertEquals(true, checkBox.isDisplayed());
		
		WebElement enableBtn = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
		enableBtn.click();
		WebElement enabledMsg = driver.findElement(By.xpath("//p[contains(text(),'enabled!')]"));
		wait.until(ExpectedConditions.visibilityOf(enableBtn));
		Assert.assertEquals(true, enabledMsg.isDisplayed());
		
		WebElement disableBtn = driver.findElement(By.xpath("//button[contains(text(),'Disable')]"));
		disableBtn.click();
		WebElement disabledMsg = driver.findElement(By.xpath("//p[@id='message'][contains(text(),'disabled!')]"));
		wait.until(ExpectedConditions.visibilityOf(disabledMsg));
		Assert.assertEquals(true, disabledMsg.isDisplayed());
	}
	
	//Dynamic Loading Test
	@Test(priority=11)
	public void dynamicLoading() {
	driver.get("http://localhost:7080/dynamic_loading");	
	driver.findElement(By.xpath("//a[contains(text(),'Example 1: Element on page that is hidden')]")).click();
	driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h4[contains(text(),'Hello World!')]")));
	Assert.assertEquals(driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).getText(), "Hello World!");
	
	driver.navigate().back();
	driver.findElement(By.xpath("//a[contains(text(),'Example 2: Element rendered after the fact')]")).click();
	WebElement startBtn2 = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));
	startBtn2.click();
	WebElement helloWorldMsg = driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]"));
	wait.until(ExpectedConditions.visibilityOf(helloWorldMsg));
	Assert.assertEquals(true, helloWorldMsg.isDisplayed());
	}
	
	//File Upload Test
	@Test(priority=12)
	public void fileUploadTest() {
		driver.get("http://localhost:7080/upload");		
		WebElement uploadInput = driver.findElement(By.id("file-upload"));
		uploadInput.sendKeys("C:\\Users\\abdul\\eclipse-workspace\\TakeHomeWebdriverTest\\src\\test\\java\\resources\\test.txt"); //Must change path of test.txt file depending on computer where test is run.
		driver.findElement(By.id("file-submit")).click();
		WebElement uploadedFilesInfo = driver.findElement(By.id("uploaded-files"));
		Assert.assertEquals(uploadedFilesInfo.getText(), "test.txt");
	}
	
	//Floating Menu test
	@Test(priority = 13)
	public void floatingMenuTest() {
		driver.get("http://localhost:7080/floating_menu");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebElement floatingMenu = driver.findElement(By.id("menu"));
		Assert.assertEquals(true, floatingMenu.isDisplayed());
	}
	
	//Iframe Test
	@Test (priority = 14)
	public void iframeTest() {
		driver.get("http://localhost:7080/iframe");
		driver.switchTo().frame("mce_0_ifr"); //Switching to iframe using ID
		WebElement contentBox = driver.findElement(By.xpath("//body[@id='tinymce']"));
		Actions act = new Actions(driver);
		act.moveToElement(contentBox).click().build().perform();
		contentBox.sendKeys(Keys.CONTROL,"a");
		contentBox.sendKeys(Keys.BACK_SPACE);
		contentBox.sendKeys("test123");
		String actualTypedText = contentBox.getText();
		Assert.assertEquals(actualTypedText, "test123");
	}
	
	//JavaScript Alerts Test
	@Test(priority = 15)
	public void javaScriptAlertsTest() {
		driver.get("http://localhost:7080/javascript_alerts");		
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		Alert alert = driver.switchTo().alert();
		String firstAlertText = alert.getText();
		Assert.assertEquals(firstAlertText, "I am a JS Alert");
		alert.accept();
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		String secondAlertText = alert.getText();
		Assert.assertEquals(secondAlertText, "I am a JS Confirm");
		alert.accept();
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		alert.sendKeys("test123");
		alert.accept();
		String jsPromptResult = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(jsPromptResult, "You entered: test123");
	}
	
	//JavaScript Error Test
	@Test(priority = 16)
	public void javaScriptErrorTest() {
		driver.get("http://localhost:7080/javascript_error");		
		String jsErrorMsg = driver.findElement(By.xpath("//body//p")).getText();
		Assert.assertEquals(jsErrorMsg, "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.");
	}
	
	//Mouse Hover Test
	@Test(priority = 17)
	public void mouseOverTest() {
	driver.get("http://localhost:7080/hovers");
	Actions act = new Actions(driver);
	WebElement img1 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/img[1]"));
	WebElement img2 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/img[1]"));
	WebElement img3 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[3]/img[1]"));
	act.moveToElement(img1).build().perform();
	String user1Txt = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]")).getText();
	Assert.assertEquals(user1Txt, "name: user1");
	act.moveToElement(img2).build().perform();
	String user2Txt = driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]")).getText();
	Assert.assertEquals(user2Txt, "name: user2");
	act.moveToElement(img3).build().perform();
	String user3Txt = driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]")).getText();
	Assert.assertEquals(user3Txt, "name: user3");
	}
	
	//New Tab Test
	@Test(priority = 18)
	public void newTabTest() {
		driver.get("http://localhost:7080/windows");
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		driver.switchTo().window(it.next()); //Switches to parent/original tab
		System.out.println("Parent/Original Tab Handle: "+driver.getWindowHandle());
		driver.switchTo().window(it.next()); //Switches to child/new tab
		System.out.println("Child/New Tab Handle: "+driver.getWindowHandle());
		String newWindowTxt = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
		Assert.assertEquals(newWindowTxt, "New Window");
	}
	
	//Notification Message test
	@Test(priority = 19)
	public void notificationMsgTest() {
		driver.get("http://localhost:7080/notification_message_rendered");
		
		for (int i = 0; i < 20; i++) {
			WebDriverWait wait = new WebDriverWait(driver, 6);
			WebElement clickHereMsgLoader = driver.findElement(By.linkText("Click here"));
			 clickHereMsgLoader.click();
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
			 WebElement notificationMsg = driver.findElement(By.xpath("//div[@id='flash']"));
			String notificationMsgTxt = notificationMsg.getText();
			 
			 if(notificationMsgTxt.contains("Action successful") || notificationMsgTxt.contains("Action unsuccesful")) {
				 Assert.assertTrue(true);
			 }
				 else {
					 Assert.assertTrue(false);
				 }
		}
	}

	
}
	


