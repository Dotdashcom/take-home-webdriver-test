package internet;


import java.io.File;
import java.time.Duration;
import java.util.Arrays;
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
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import page_object.LoginPage;
import resources.BaseClass;

public class Tests extends BaseClass{
public WebDriver driver;
public WebDriverWait wait;

	@BeforeMethod
	public void setup()
	
	{
		driver=openBrowser();
		wait =new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	@AfterMethod
	public void teardown()
	{
		closeDriver(driver);
	}
	

	@Test
	public void loginTest()
	{
		
		driver.get("http://localhost:7080/login");
		LoginPage lp=new LoginPage(driver);
		lp.userName().sendKeys("tomsmith");
		lp.passWord().sendKeys("SuperSecretPassword!");
		lp.loginButton().click();
		String expected="You logged into a secure area";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
		String actual= driver.findElement(By.id("flash")).getText().split("!")[0];
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	@Test 
	public void loginFail()
	{
		driver.get("http://localhost:7080/login");
		LoginPage lp=new LoginPage(driver);
		lp.userName().sendKeys("toms");
		lp.passWord().sendKeys("SuperPassword");
		lp.loginButton().click();
		String expected="Your username is invalid";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
		String actual= driver.findElement(By.id("flash")).getText().split("!")[0];
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	@Test 
	public void checkBoxes()
	{
		driver.get("http://localhost:7080/checkboxes");
		//checking checkbox 1
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[1]")).isSelected());
		driver.findElement(By.xpath("//input[1]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[1]")).isSelected());
		driver.findElement(By.xpath("//input[1]")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[1]")).isSelected());
		
		//Checking checkbox 2
		Assert.assertTrue(driver.findElement(By.xpath("//input[2]")).isSelected());
		driver.findElement(By.xpath("//input[2]")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[2]")).isSelected());
		driver.findElement(By.xpath("//input[2]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[2]")).isSelected());	
	}
	@Test
	public void contextMenu()
	{
		driver.get("http://localhost:7080/context_menu");
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.id("hot-spot"))).build().perform();
		String expected=driver.switchTo().alert().getText();
		String actual = "You selected a context menu";
		Assert.assertEquals(actual, expected);
		driver.switchTo().alert().accept();
		
	}
	@Test 
	public void dragAndDrop()
	{
		driver.get("http://localhost:7080/drag_and_drop");
		//Before drag and drop
		WebElement a =driver.findElement(By.id("column-a"));
		WebElement b=driver.findElement(By.id("column-b"));
		Assert.assertEquals(a.getText(),"A");
		Assert.assertEquals(b.getText(),"B");
		Actions action = new Actions(driver);
		action.dragAndDrop(b, a).build().perform();
		//After drag and drop
	wait.until(ExpectedConditions.textToBePresentInElement(a, "B"));
		Assert.assertTrue(a.getText().equalsIgnoreCase("B"));
		Assert.assertTrue(b.getText().equalsIgnoreCase("A"));
	}
	@Test 
	public void dropdown()
	{
		driver.get("http://localhost:7080/dropdown");
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		dropdown.selectByVisibleText("Option 1");
		wait.until(ExpectedConditions.textToBePresentInElement(dropdown.getFirstSelectedOption(), "Option 1"));
		Assert.assertTrue(dropdown.getFirstSelectedOption().getText().equalsIgnoreCase("Option 1"));
		dropdown.selectByVisibleText("Option 2");
		wait.until(ExpectedConditions.textToBePresentInElement(dropdown.getFirstSelectedOption(), "Option 2"));
		Assert.assertTrue(dropdown.getFirstSelectedOption().getText().equalsIgnoreCase("Option 2"));
		
	}
	
	@Test 
	public void dynamicContent()
	{
		driver.get("http://localhost:7080/dynamic_content");
		String first =driver.findElement(By.xpath("(//div[@class='large-10 columns'])[1]")).getText();
		String second = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[2]")).getText();
		String Third = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();
		driver.navigate().refresh();
		String first1 =driver.findElement(By.xpath("(//div[@class='large-10 columns'])[1]")).getText();
		String second1 = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[2]")).getText();
		String Third1 = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();
		
		Assert.assertNotEquals(first, first1);
		Assert.assertNotEquals(second, second1);
		Assert.assertNotEquals(Third, Third1);
		
		driver.navigate().refresh();
		
		String first2 =driver.findElement(By.xpath("(//div[@class='large-10 columns'])[1]")).getText();
		String second2 = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[2]")).getText();
		String Third2 = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();
		
		Assert.assertNotEquals(first1, first2);
		Assert.assertNotEquals(second1, second2);
		Assert.assertNotEquals(Third1, Third2);
		
	}
	@Test 
	public void dynamicControls()
	{
		driver.get("http://localhost:7080/dynamic_controls");
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("checkbox"))));
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).getText().equalsIgnoreCase("It's gone!"));
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("checkbox"))));
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).getText().equalsIgnoreCase("It's back!"));
		
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@type='text']"))));
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).getText().equalsIgnoreCase("It's enabled!"));
		driver.findElement(By.xpath("//button[text()='Disable']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id='message']")));
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).getText().equalsIgnoreCase("It's disabled!"));
		
	}
	
	@Test 
	public void dynamicLoading()
	{
		driver.get("http://localhost:7080/dynamic_loading/2");
		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
		Assert.assertTrue(driver.findElement(By.id("finish")).getText().contentEquals("Hello World!"));
	}
	@Test 
	public void fileDownload() throws InterruptedException
	{
		driver.get("http://localhost:7080/download");
		driver.findElement(By.cssSelector("a[href='download/some-file.txt']")).click();
		Thread.sleep(2000);
		File f =new File(dPath+"/some-file.txt");
       Assert.assertTrue(f.exists());


        

	
	    
	}
	@Test 
	public void uploadFile() throws InterruptedException
	{
		driver.get("http://localhost:7080/upload");
		driver.findElement(By.id("file-upload")).sendKeys(dPath+"/some-file.txt");
		Thread.sleep(1000);
		driver.findElement(By.id("file-submit")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='File Uploaded!']")));
		String actual ="some-file.txt";
		String expected = driver.findElement(By.id("uploaded-files")).getText();
		Assert.assertEquals(actual, expected);
	}
	@Test 
	public void floatingMenu() throws InterruptedException
	{
		driver.get("http://localhost:7080/floating_menu");
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");          //TO SCROLL
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("menu"))));
		
		Assert.assertTrue(driver.findElement(By.id("menu")).isDisplayed());
		
	}

	@Test 
	public void iFrame()
	{
		driver.get("http://localhost:7080/iframe");
		driver.switchTo().frame("mce_0_ifr");
		String expected ="iFrame Test";
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys(expected);
		String actual = driver.findElement(By.id("tinymce")).getText();
		Assert.assertEquals(actual, expected);
		driver.switchTo().defaultContent();
	}
	@Test 
	public void mouseHover()
	{
		driver.get("http://localhost:7080/hovers");
		Actions action = new Actions(driver);
		Assert.assertFalse(driver.findElement(By.xpath("(//div[@class='figcaption'])[1]")).isDisplayed());
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='figure'])[1]"))).build().perform();
		
	Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='figcaption'])[1]")).isDisplayed());
	
	action.moveToElement(driver.findElement(By.xpath("(//div[@class='figure'])[2]"))).build().perform();
	Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='figcaption'])[2]")).isDisplayed());
	
	action.moveToElement(driver.findElement(By.xpath("(//div[@class='figure'])[3]"))).build().perform();
	Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='figcaption'])[3]")).isDisplayed());
	
		
	}
	@Test 
	public void javascriptAlerts()
	{
		driver.get("http://localhost:7080/javascript_alerts");
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		String alertText=driver.switchTo().alert().getText();
		Assert.assertEquals(alertText, "I am a JS Alert");
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		String confirmText=driver.switchTo().alert().getText();
		Assert.assertEquals(confirmText, "I am a JS Confirm");
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		String expected ="JavaScript Test";
        driver.switchTo().alert().sendKeys(expected);
        driver.switchTo().alert().accept();
        String promptText=driver.findElement(By.xpath("//p[@id='result']")).getText().split(":")[1].trim();
        Assert.assertEquals(promptText, expected);
        
		
		
		
	}
	@Test 
	public void javascriptError()
	{
		driver.get("http://localhost:7080/javascript_error");
		 LogEntries log=   driver.manage().logs().get(LogType.BROWSER);
		 
	       List<LogEntry> logs = log.getAll();
	       String expected = "Cannot read properties of undefined (reading 'xyz')";
	       for(LogEntry e:logs)
	       {
	    	  System.out.println( e.getMessage());
	    	  Assert.assertTrue( e.getMessage().contains(expected)); 
	       }
	      
	}
	
	@Test 
	public void newWindow() 
	{
		driver.get("http://localhost:7080/windows");
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
	
		
		Set<String> windows =driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		it.next();
		
		driver.switchTo().window(it.next());
		
		String actual=driver.getTitle();
		String expected ="New Window";
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		
		
	}
	@Test 
	public void notificationMessage() {
		driver.get("http://localhost:7080/notification_message_rendered");
		driver.findElement(By.xpath("//a[text()='Click here']")).click();
		
	
		
		
		String a1= driver.findElement(By.id("flash")).getText().split("×")[0].strip();
		
	
		List<String> expected = Arrays.asList("Action successful","Action unsuccesful, please try again","Action Unsuccessful");
		
		if(expected.contains(a1))
		{
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
		
		driver.findElement(By.xpath("//a[text()='Click here']")).click();
		String a2= driver.findElement(By.id("flash")).getText().split("×")[0].strip();
		
		if(expected.contains(a2))
		{
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
		
		driver.findElement(By.xpath("//a[text()='Click here']")).click();
		String a3= driver.findElement(By.id("flash")).getText().split("×")[0].strip();
		
		if(expected.contains(a3))
		{
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
		
		
		
		
	}
	
	
}
