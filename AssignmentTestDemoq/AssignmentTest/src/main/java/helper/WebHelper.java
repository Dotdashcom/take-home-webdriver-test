package helper;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebHelper {
	
	
		private WebDriver driver;	
		Actions action;
		

		public WebHelper (Browser browser,boolean isHeadless, long max_wait) throws InterruptedException {
			switch (browser) {
			
			case CHROME:		
				DesiredCapabilities capabilitiesChrome = new DesiredCapabilities();
				
				ChromeOptions options = new ChromeOptions();
				if(isHeadless) {
					options.addArguments("--headless", "--window-size=1920,1200");
				}
				
				capabilitiesChrome.setCapability(ChromeOptions.CAPABILITY, options);
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
				break;			
				
			default:
				throw new IllegalArgumentException(browser.toString());
			}
			
			driver.manage().timeouts().implicitlyWait(max_wait, TimeUnit.SECONDS);	
			
		}
	 
	 public void closeAll(){
			if(driver!=null)
			{				
				this.driver.quit();
			}		
	    }
			
	public void closeBrowser() {
				this.driver.quit();
			
		}
			
	public WebDriver getDriver() {
				return this.driver;
			}
			
	public void maximizeWindows() {
				this.driver.manage().window().maximize();
			}
	
	public WebElement waitForElementToBeClickable(By locator, int timeOutInSeconds) {
		return new WebDriverWait((this.driver), 10).until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public Boolean waitForElementTextAppears(By locator, int timeOutInSeconds, String message) {
		return new WebDriverWait((this.driver), 10).until(ExpectedConditions.textToBe(locator, message));
	}

	public void contextClick(By by) {
		action= new Actions(this.driver);		
		action.contextClick(this.waitForElementToBeClickable(by, 5)).perform();
	}
	
	public void DoubleClick(By by) {
		action= new Actions(this.driver);		
		action.doubleClick(this.waitForElementToBeClickable(by, 5)).perform();
	}
	
	public String GetalertText() {
		return new WebDriverWait(this.driver, 15).until(ExpectedConditions.alertIsPresent()).getText();

	}
	
	public void AcceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public boolean  JsLogEntry(String actual) {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for(LogEntry entry : logEntries){
		if(entry.getMessage().contains(actual)) {
			return true;
		}	
	}
		return false;
}
	
	public void SwitchWindowHandles() {		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	}
	
   public void DragAndDrop(WebElement source,WebElement target) throws InterruptedException {
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	final String java_script =
			"var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
			                "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
			                "ction(format,data){this.items[format]=data;this.types.append(for" +
			                "mat);},getData:function(format){return this.items[format];},clea" +
			                "rData:function(format){}};var emit=function(event,target){var ev" +
			                "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
			                "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
			                "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
			                "'drop',tgt);emit('dragend',src);";
			        
			        js.executeScript(java_script, source,target);
			        Thread.sleep(2000);
	}
   
   public void selectFromDropDown(By by, String value) {
		WebElement element = waitForElementToBeClickable(by, 5);
		Select sc = new Select(element);
		try {
			sc.selectByValue(value);
		} catch (Exception e) {
			sc.selectByVisibleText(value);
		}
	}
   
   public String getselectedText(By by) {
		WebElement element = waitForElementToBeClickable(by, 5);
		Select sc = new Select(element);
		return sc.getFirstSelectedOption().getText();
	}
   
   public void RefreshPage() {
	   this.driver.navigate().refresh();
   }
   
   public void VerifyFileName (String fileName) {
	   
	   String path = System.getProperty("user.home");
	   
	   String downloadPath = path + "\\Downloads\\";
	   
	   File folder = new File(downloadPath);
		File[] listOfFiles = folder.listFiles();
		boolean value = false;

		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileNameSample = listOfFile.getName();
				if (fileNameSample.contains(fileName)) {

					value = true;
				}
			}
		}
		Assert.assertTrue(value, "Invalid File");
   }
   
   
   public String GetFilePath (String fileName) {
	   
       String path = System.getProperty("user.dir");
	   
	   String uploadPath = path + "\\Files\\"+fileName;
	   
	   return uploadPath;
	   
   }
   
   public void ScrollDown () {
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}  
  

}
