package testSet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import drivers.BrowserFactory;
import pageObjects.CheckBoxes_page;
import pageObjects.ContextMenu_page;
import pageObjects.DragAndDrop_page;
import pageObjects.DropDown_page;
import pageObjects.LogIn_page;

public class TestCases 
{
	@Test
	public void login_secuence()
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://localhost:7080/login");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		LogIn_page login_page = PageFactory.initElements(driver, LogIn_page.class);
		login_page.Enter_username("tomsmith");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		login_page.Enter_password("SuperSecretPassword!");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		login_page.Click_Login();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String expectedurl = "http://localhost:7080/secure";
		String actualurl =  driver.getCurrentUrl();
		Assert.assertEquals(actualurl, expectedurl);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.quit();
		
	}
	
	@Test
	
	public void failed_Login_sequence()
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://localhost:7080/login");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		LogIn_page login_page = PageFactory.initElements(driver, LogIn_page.class);
		login_page.Enter_username("tomsmith");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		login_page.Enter_password("SuperSecretPassword");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		login_page.Click_Login();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement errormsg = driver.findElement(By.xpath("//*[@id='flash' and contains(text(), 'Your password is invalid!')]"));
		if(errormsg.isDisplayed()) 
		{
			System.out.println("Failed Login correct");
			driver.quit();
		}
		else {
			System.out.println("Failed Login incorrect");
			driver.quit();
		}
	}
	
	@Test
	public void checkboxes()
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://localhost:7080/checkboxes");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		CheckBoxes_page checkboxes = PageFactory.initElements(driver, CheckBoxes_page.class);
		if(!checkboxes.checkbox1.isSelected())
		{
			checkboxes.checkbox1.click();
		}
		if(checkboxes.checkbox2.isSelected())
		{
			checkboxes.checkbox2.click();
		}
		driver.quit();
	}
	
	@Test
	public void contextAlert()
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://localhost:7080/context_menu");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		ContextMenu_page contextMenu = PageFactory.initElements(driver, ContextMenu_page.class);
		
		Actions actions = new Actions(driver);
		actions.contextClick(contextMenu.contextRectangle).perform();
		WebDriverWait w = new WebDriverWait(driver, 3);
		if(w.until(ExpectedConditions.alertIsPresent())==null)
		{  
			System.out.println("Alert not exists");
			driver.quit();
		}
		      else
		      {
		    	  System.out.println("Alert exists");  
		    	  driver.switchTo().alert().accept();
		      }
		      
		
		      driver.quit();
		
	}
	
	@Test
	public void dragAnddrop()
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://localhost:7080/drag_and_drop");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		DragAndDrop_page dragandDropPage = PageFactory.initElements(driver, DragAndDrop_page.class);
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(dragandDropPage.Square_A, dragandDropPage.Square_B);
		actions.build().perform();
				
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String draggedcolumn = driver.findElement(By.xpath("//*[@id=\"column-b\"]/header")).getText();
		System.out.println(draggedcolumn);
		String expectedValue = "A";
		Assert.assertEquals(draggedcolumn, expectedValue);
		driver.quit();
	}
	
	@Test
	public void Dropdown()
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://localhost:7080/dropdown");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		DropDown_page dropDownPage = PageFactory.initElements(driver, DropDown_page.class);
		Assert.assertTrue(dropDownPage.nullSelection.isDisplayed());
		dropDownPage.select_Option("Option 1");
		Assert.assertTrue(dropDownPage.option1.isDisplayed());
		dropDownPage.select_Option("Option 2");
		Assert.assertTrue(dropDownPage.option2.isDisplayed());
		driver.quit();
	}
	
	@Test
	public void dynamicContent() throws Exception
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://localhost:7080/dynamic_content");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement textcontainer1 = driver.findElement(By.xpath("//div[@class='large-10 columns']"));
		int count = 0;
		int refresh_tries = 5;
		while(true) 
		{
			String text1 = textcontainer1.getText();
			System.out.println(textcontainer1);
			String text2 = "";
			try
			{
				if(!text1.equalsIgnoreCase(text2))
				{
				text1=text2;
				driver.navigate().refresh();
				Thread.sleep(2000);
				}
				else {
					System.out.println("Got first match");
					driver.quit();
				}
			}
			catch(Exception e) {
				if(++count == refresh_tries) throw e;
			}
			driver.quit();
		}
	}
	@Test
	public void downloadFile()
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://localhost:7080/download");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement link = driver.findElement(By.xpath("//a[@href='download/some-file.txt']"));
		String location = link.getAttribute("href");
		String command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + location;
		try 
		{
			Process exec = Runtime.getRuntime().exec(command);
			int exitVal = exec.waitFor();
			System.out.println("Exit value: " + exitVal);
		}
		catch (InterruptedException | IOException ex)
		{
			
		}
		driver.quit();
	}
	@Test
	public void uploadFile()
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://localhost:7080/upload");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement uploadbutton = driver.findElement(By.xpath("//input[@id='file-upload']"));
		uploadbutton.sendKeys("C:\\some-file.txt");
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();
		WebElement success = driver.findElement(By.xpath("//div[@id='uploaded-files']"));
		Assert.assertTrue(success.isDisplayed());
		driver.quit();
	}
	@Test
	public void floating_menu() throws InterruptedException
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://localhost:7080/floating_menu");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		WebElement Home = driver.findElement(By.xpath("//a[@href='#home']"));
		WebElement News = driver.findElement(By.xpath("//a[@href='#news']"));
		WebElement Contact = driver.findElement(By.xpath("//a[@href='#contact']"));
		WebElement About = driver.findElement(By.xpath("//a[@href='#about']"));
		Assert.assertTrue(Home.isDisplayed());
		Assert.assertTrue(News.isDisplayed());
		Assert.assertTrue(Contact.isDisplayed());
		Assert.assertTrue(About.isDisplayed());
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void iframe()
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://localhost:7080/iframe");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		driver.findElement(By.xpath("//button[@class='tox-notification__dismiss tox-button tox-button--naked tox-button--icon']")).click();
		System.out.println("Total number of iframes are " + iframeElements.size());
		driver.switchTo().frame(0);
		WebElement displayedtext = driver.findElement(By.xpath("//p[contains(text(), 'Your content goes here')]"));
		String text = displayedtext.getText();
		Assert.assertEquals(text, "Your content goes here.");
		driver.quit();
		
		
	}
	
	@Test
	public void mouse_over()
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://localhost:7080/hovers");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement User1 = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
		WebElement User1name = driver.findElement(By.xpath("//h5[contains(text(), 'user1')]"));
		WebElement ViewUser1Profile = driver.findElement(By.xpath("//a[@href='/users/1']"));
		WebElement User2 = driver.findElement(By.xpath("(//div[@class='figure'])[2]"));
		WebElement User2name = driver.findElement(By.xpath("//h5[contains(text(), 'user2')]"));
		WebElement ViewUser2Profile = driver.findElement(By.xpath("//a[@href='/users/2']"));
		WebElement User3 = driver.findElement(By.xpath("(//div[@class='figure'])[3]"));
		WebElement User3name = driver.findElement(By.xpath("//h5[contains(text(), 'user3')]"));
		WebElement ViewUser3Profile = driver.findElement(By.xpath("//a[@href='/users/3']"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(User1).perform();
		Assert.assertTrue(User1name.isDisplayed());
		Assert.assertTrue(ViewUser1Profile.isDisplayed());
		
		builder.moveToElement(User2).perform();
		Assert.assertTrue(User2name.isDisplayed());
		Assert.assertTrue(ViewUser2Profile.isDisplayed());
		
		builder.moveToElement(User3).perform();
		Assert.assertTrue(User3name.isDisplayed());
		Assert.assertTrue(ViewUser3Profile.isDisplayed());
		
		driver.quit();
		
	}
	
	@Test
	public void jsAlerts() throws InterruptedException
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://localhost:7080/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement JSAlert_button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		WebElement JSConfirm_button = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		WebElement JSPrompt_button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		WebElement Result = driver.findElement(By.xpath("//p[@id='result']"));
		
		JSAlert_button.click();
		Thread.sleep(2000);
		String message = Result.getText();
		Alert alert = driver.switchTo().alert();
		String AlertMessage = alert.getText();
		Assert.assertEquals(AlertMessage, "I am a JS Alert");
		alert.accept();
		Thread.sleep(2000);
		Assert.assertEquals(message, "You successfuly clicked an alert");
		
		JSConfirm_button.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		AlertMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(AlertMessage, "I am a JS Confirm");
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		message = Result.getText();
		Assert.assertEquals(message, "You clicked: Ok");
		
		JSPrompt_button.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		AlertMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(AlertMessage, "I am a JS Confirm");
		driver.switchTo().alert().sendKeys("Accepting Alert");
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		message = Result.getText();
		Assert.assertEquals(AlertMessage, "You entered: Accepting Alert");
		
		driver.quit();
		
	}
	@Test
	public void NewTab()
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://localhost:7080/windows");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement button = driver.findElement(By.xpath("//*[contains(text(), 'Click Here')]"));
		button.click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    WebElement text = driver.findElement(By.xpath("//h3[contains(text(), 'New Window')]"));
	    Assert.assertTrue(text.isDisplayed());
	    driver.quit();
	}
	
	@Test
	public void Notification_message()
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://localhost:7080/notification_message_rendered");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement button = driver.findElement(By.xpath("//a[contains(text(), 'Click here')]"));
		button.click();
		WebElement Flash_Message = driver.findElement(By.xpath("//div[@id='flash']"));
		String message = Flash_Message.getText();
		System.out.println(message);
		if(message.contains("Action unsuccesful, please try again"))
		{
			System.out.println("Success");
			driver.quit();
		}
		else if(message.contains("Action Successful")) 
		{
			System.out.println("Success");
			driver.quit();
		}
		else if(message.contains("Action Unsuccessful"))
		{
			System.out.println("Success");
			driver.quit();
		}
		
		
		driver.quit();
		
	}
	

}
