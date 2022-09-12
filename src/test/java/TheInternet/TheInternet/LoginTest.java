package TheInternet.TheInternet;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.io.File;
import java.io.FileFilter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class LoginTest
{
	
	Login login=new Login();
	WebDriverWait wait = new WebDriverWait(login.driver,30);
	
	
	@Test
    public void verifydragAndDrop() {
		openWebPage("http://localhost:7080/drag_and_drop");
		JavascriptExecutor js = (JavascriptExecutor)login.driver;
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
                        + "simulateHTML5DragAndDrop(source,destination);", login.elementA, login.elementB);
        Assert.assertEquals(login.elementA.getText(), "B");
        
    	
    }
    
	@Test
    public void verifyLogin() {
		openWebPage("http://localhost:7080/login");
    	login.username.sendKeys("tomsmith");
    	login.password.sendKeys("SuperSecretPassword!");
    	login.login.click();
        Assert.assertEquals(verifyDisplayedText("You logged into a secure area!"), true);
    	
    }
	
	@Test
    public void verifyLoginWithInvalidCreds() {
		openWebPage("http://localhost:7080/login");
    	login.username.sendKeys("tomsmithInvalid");
    	login.password.sendKeys("SuperSecretPassword!Invalid");
    	login.login.click();
        Assert.assertEquals(verifyDisplayedText("Your username is invalid!"), true);
        
    	
    }
	
	@Test
    public void verifyCheckboxes() {
		openWebPage("http://localhost:7080/checkboxes");
        Assert.assertEquals(login.checkbox1.isSelected(), false);
        Assert.assertEquals(login.checkbox2.isSelected(), true);
        login.checkbox1.click();
        login.checkbox2.click();
        Assert.assertEquals(login.checkbox1.isSelected(), true);
        Assert.assertEquals(login.checkbox2.isSelected(), false);
        
    	
    }
	
	@Test
    public void verifyContextMenu() {
		openWebPage("http://localhost:7080/context_menu");
		Actions actions = new Actions(login.driver);
		actions.contextClick(login.contextBox).perform();		
		Alert alert = login.driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "You selected a context menu");
		alert.accept();
        
    	
    }
    	
     @Test
     public void verifyDropdown() {
    	 openWebPage("http://localhost:7080/dropdown");
    	 Select select=new Select(login.dropdown);
    	 select.selectByVisibleText("Option 1");
    	 Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
    	 select.selectByVisibleText("Option 2");
    	 Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
            
        	
        }
     
     @Test
     public void verifyDynamicContent() {
    	 openWebPage("http://localhost:7080/dynamic_content");
    	 String beforeRefresh=login.driver.getPageSource();
    	 login.driver.navigate().refresh();
    	 String afterRefresh=login.driver.getPageSource();
    	 Assert.assertNotEquals(beforeRefresh, afterRefresh);
            
        	
        }
     
     @Test
     public void verifyDynamicControls() throws InterruptedException {
    	 openWebPage("http://localhost:7080/dynamic_controls");
    	 login.swapCheckboxButton.click();
    	 wait.until(ExpectedConditions.visibilityOf(login.addButton));
    	 Assert.assertEquals(verifyDisplayedText("gone!"), true);
    	 Thread.sleep(2000);
    	 login.swapCheckboxButton.click();
    	 wait.until(ExpectedConditions.visibilityOf(login.dynamicControlsCheckbox));
    	 Assert.assertEquals(verifyDisplayedText("back!"), true);
    	 Thread.sleep(2000);
    	 login.swapInputButton.click();
    	 wait.until(ExpectedConditions.visibilityOf(login.enableButton));
    	 Assert.assertEquals(verifyDisplayedText("enabled!"), true);
    	 Thread.sleep(2000);
    	 login.swapInputButton.click();
    	 wait.until(ExpectedConditions.elementToBeClickable(login.dynamicControlsBar));
    	 Assert.assertEquals(verifyDisplayedText("disabled!"), true);
            
        	
        }
     
     @Test
     public void verifyDynamicLoading() {
    	 openWebPage("http://localhost:7080/dynamic_loading/2");
    	 login.startButton.click();
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Hello World!']")));
    	 Assert.assertEquals(verifyDisplayedText("Hello World!"), true);
        	
        }
     @Test
     public void verifyFileDownload() {
    	 openWebPage("http://localhost:7080/download");
    	 login.fileDownloadLink.click();
    	 File getLatestFile = getLatestFilefromDir("C:\\Users\\mehar\\Downloads");
 	    String fileName = getLatestFile.getName();
 	    System.out.println("The value"+ fileName);
 	    Assert.assertTrue(fileName.startsWith("some-file"), "Downloaded file name is not matching with expected file name");
     	
        }
     
     @Test
     public void verifyFileUpload() {
    	 openWebPage("http://localhost:7080/upload");
    	 login.fileUpload.sendKeys(System.getProperty("user.dir")+"\\pom.xml");
    	 login.fileUploadButton.click();
    	 Assert.assertTrue(verifyDisplayedText("File Uploaded!"), "Error in uploading the file");
                  	
        }
     
     @Test
     public void verifyIframe() throws InterruptedException {
    	 openWebPage("http://localhost:7080/iframe");
    	 String text="Verifying the iframe";
    	 login.closeButton.click();
    	 Thread.sleep(2000);
    	 login.driver.switchTo().frame(login.iframe);
    	 login.iframeParagraphBox.clear();
    	 login.iframeParagraphBox.sendKeys(text);
    	 Assert.assertTrue(login.iframeParagraphBox.getText().contentEquals(text), "Text in the iframe is not correct");
                  	
        }
     
     @Test
     public void verifyScrolling() {
    	 openWebPage("http://localhost:7080/floating_menu"); 
    	 Assert.assertTrue(login.floatingMenu.isDisplayed(), "Floating Menu is not displayed");
    	 JavascriptExecutor jse = (JavascriptExecutor)login.driver;
         jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
         Assert.assertTrue(login.floatingMenu.isDisplayed(), "Floating Menu is not displayed");
                  	
        }
     
     @Test
     public void verifyMouseHover() {
    	 openWebPage("http://localhost:7080/hovers"); 
    	 int userId=0;
    	 List<WebElement> images=login.driver.findElements(By.xpath("//img[@alt='User Avatar']"));
    	 Actions actions = new Actions(login.driver);
    	 for(int x=0;x<images.size();x++) {
    	    userId=x+1;
    		actions.moveToElement(images.get(x)).perform();
    		Assert.assertTrue(verifyDisplayedText("name: user"+userId), "Hovering over the element is not displaying information");
    	 }          	
        }
     
     @Test
     public void verifyJavascriptErrors() {
    	 openWebPage("http://localhost:7080/javascript_error"); boolean flag=false;
    	 LogEntries logEntries = login.driver.manage().logs().get(LogType.BROWSER);
         List<LogEntry> lg = logEntries.filter(Level.ALL);
         for(LogEntry logEntry : lg) {
        	 System.out.println(logEntry);
        	if(logEntry.getMessage().contains("Cannot read properties of undefined (reading 'xyz')")) {
        		Assert.assertTrue(true, "The log message wasn't displayed");
        		flag=true;
        		break;
        	}
         }
         if(flag==false) {
        	 Assert.assertTrue(false, "The log message wasn't displayed");
         }
                  	
        }
     
     @Test
     public void verifyOpenNewTab() {
    	 openWebPage("http://localhost:7080/windows");
    	 Assert.assertTrue(login.driver.getWindowHandles().size() == 1, "There's more than one ");
    	 login.clickHereButton.click();
    	 wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    	 Assert.assertTrue(login.driver.getWindowHandles().size() == 2, "A new window wasn't opened");
                  	
        }
     
     @Test
     public void verifyNotificationMessage() throws InterruptedException {
    	 openWebPage("http://localhost:7080/notification_message_rendered");
    	 String[] status= {"Action successful", "Action unsuccessful", "Action unsuccesful, please try again"};
    	 List<String> statusList = Arrays.asList(status); 
    	 for(int x=0;x<10;x++) {
    	 login.clickHereLink.click();
    	 Thread.sleep(1000);   
    	 String flashMessage=login.flashMessage.getText();
    	 Assert.assertTrue(statusList.contains(flashMessage.replace("\n", "").replace("\r", "").trim().substring(0, flashMessage.length() - 2)), "The status was different");
    	 }
    	 
                  	
        }
     
     @Test
     public void verifyJavascriptAlerts() throws InterruptedException {
    	 openWebPage("http://localhost:7080/javascript_alerts");
    	 String toVerify="This value has to be verified";
    	 login.jsAlertButton.click();
    	 Alert alert = login.driver.switchTo().alert();
    	 Assert.assertEquals(alert.getText(), "I am a JS Alert");
    	 alert.accept();
    	 Thread.sleep(2000);
    	 System.out.println("TILLL HERER");
    	 login.jsAlertConfirm.click();
    	 Assert.assertEquals(alert.getText(), "I am a JS Confirm");
    	 alert.accept();
    	 Thread.sleep(2000);
    	 login.jsAlertPrompt.click();   
    	 alert.sendKeys(toVerify);
    	 alert.accept();
    	 Assert.assertTrue(verifyDisplayedText("You entered: This value has to be verified"), "The javascript alert wasn't properly verified");
        }
     
     @AfterClass
     public void closeBrowser() {
    	 login.driver.quit();
     }
            
	
	public boolean verifyDisplayedText(String text) {
		String xpath="//*[contains(text(),'"+text+"')]";
		List<WebElement> elements=login.driver.findElements(By.xpath(xpath));
		if(elements.size()>0) 
			return true;
		else
			return false;
		
		
	}
	
	public void openWebPage(String url) {
		
		login.driver.get(url);
    	login.driver.manage().window().maximize();
    	try {
    		Thread.sleep(4000);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    	
	}
	
	private File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }

	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
}
