package com.dotdashcom.pom;
import org.openqa.selenium.Alert;
import org.apache.log4j.BasicConfigurator;  
import org.apache.log4j.LogManager;  
import org.apache.log4j.Logger;   
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.dotdashcom.pom.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class PageActions {
	private WebDriver driver;
	static Logger log = LogManager.getLogger(PageActions.class.getName());  
	public PageActions() {
		BasicConfigurator.configure();  
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		
		log.info("Opened the browser with option --disable-notifications");
	}
	public void navigateUrl(String URL) {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		log.info("Navigated to "+URL+" and maximized browser.");
		
	}
	public void loginAction(String username, String password) {
		navigateUrl(Constants.LOGIN);
		
		WebElement usrElem = driver.findElement(By.id(Locators.loginUserBoxId));
		WebElement pswElem = driver.findElement(By.id(Locators.loginPassBoxId));
		usrElem.sendKeys(username);
		log.info("Typed "+username+" in text box");
		pswElem.sendKeys(password);
		log.info("Typed "+password+" in passwordbox");
		WebElement login = driver.findElement(By.tagName(Locators.loginButtonTag));
		login.click();
		log.info("Clicked login button");
		
	}
	public String checkLoginFail() {
		String successText="";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			WebElement el = wait.until(ExpectedConditions.
					presenceOfElementLocated(By.id(Locators.loginFailureId)));
			successText = el.getText();
			log.info("checking login fail:"+successText);
		}catch(Exception e) {
			successText = "error, no element";
			log.info("checking login fail, something gone wrong:"+successText);
		}
		return successText;
	}
	public String checkLoginSuccess() {
		String successText = "";
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		try {
			WebElement h2 = wait.until(
					ExpectedConditions.presenceOfElementLocated
					(By.tagName(Locators.loginSuccessTag)));
			successText = h2.getText();
			log.info("checking login success:"+successText);
		}catch(Exception e){
			successText="Error, no element";
			log.info("checking login success, something gone wrong:"+successText);
		}
		
		return successText;
	}
	public void navigateCheckBox() {
		navigateUrl(Constants.CHECK_BOXES);
	}
	public void checkBoxAction(int chNo) {
		
		List<WebElement> checkboxes = driver.findElements(By.tagName(Locators.checkBoxTag));
		checkboxes.get(chNo).click();
		log.info("clicked on checkbox number "+(chNo+1));
	}
	public boolean getCheckboxStatus(int chNo) {
		List<WebElement> checkboxes = driver.findElements(By.tagName(Locators.checkBoxTag));
		log.info("checkbox number status "+(chNo+1)+" is "+checkboxes.get(chNo).isSelected());
		return checkboxes.get(chNo).isSelected();
	}
	
	
	public void navigateClickContextMenu() {
		navigateUrl(Constants.CONTEXT_MENU);
		WebElement el = driver.findElement(By.id(Locators.contextMenuId));
		Actions actions = new Actions(driver);
		actions.contextClick(el).perform();
		log.info("Clicked on context menu");
	}
	public String validatePopupText() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.dismiss();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement el= driver.findElement(By.tagName("p"));
		el.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		log.info("dismissed alert and extracted text from popup: "+text);
		return text;
	}
	public void navigateDragDrop() {
		navigateUrl(Constants.DRAG_AND_DROP);
	}
	public String[] getDragDropGetText() {
		String[] cols = new String[2];
		WebElement el = driver.findElement(By.xpath(Locators.colAHeader));
		WebElement el2 = driver.findElement(By.xpath(Locators.colBHeader));
		cols[0] = el.getText();
		cols[1] = el2.getText();
		
		return cols;
	}
	public void dragDrop() {
		
		
		WebElement from = driver.findElement(By.xpath(Locators.fromDrag));
		WebElement to = driver.findElement(By.xpath(Locators.toDrag));
		int xoffset = to.getLocation().getX();
		int yoffset = to.getLocation().getY();
		Actions act = new Actions(driver);
		act.dragAndDropBy(from, xoffset+xoffset/3, yoffset+4).perform();
	}
	
	
	public void navigateSelect() {
		navigateUrl(Constants.DROPDOWN);
	}
	public String selectOption(String optionVal) {
		WebElement el = driver.findElement(By.id(Locators.selectId));
		Select options = new Select(el);
		options.selectByVisibleText(optionVal);
		WebElement sel = options.getFirstSelectedOption();
		String selText = sel.getText();
		log.info("the selected value is "+selText);
		return selText;
	}
	public String getDynamicText() {
		navigateUrl(Constants.DYNAMIC_CONTENT);
		List<WebElement> elements = driver.findElements(By.xpath(Locators.dynamicContent));
		String text = elements.get(0).getText();
		log.info("the dynamic text value is "+text);
		return text;
	}
	
	
	public void navigateDynamicControl() {
		navigateUrl(Constants.DYNAMIC_CONTROLS);
	}
	public boolean clickRemoveButton() {
		WebElement elem = driver.findElement(By.xpath(Locators.removeButton));
		elem.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			WebElement el = wait.until(
					ExpectedConditions.presenceOfElementLocated(
							By.xpath(Locators.addButton))
					
					);
			WebElement cb = driver.findElement(By.xpath(Locators.dynamicCheckbox));
			return false;
		}catch(Exception e) {
			return true;
		}
		
	}
	public boolean clickAddButton() {
		WebElement elem = driver.findElement(By.xpath(Locators.addButton));
		elem.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			WebElement el = wait.until(
					ExpectedConditions.presenceOfElementLocated(
							By.xpath(Locators.removeButton))
					
					);
			WebElement cb = driver.findElement(By.xpath(Locators.dynamicCheckbox));
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	public boolean clickEnableButton() {
		WebElement elem = driver.findElement(By.xpath(Locators.enableButton));
		elem.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath(Locators.disableButton)));
			WebElement tbox = driver.findElement(By.xpath(Locators.dynamicTextBox));
			
			return tbox.isEnabled();
		}catch(Exception e) {
			return false;
		}
		
	}
	public boolean clickDisableButton() {
		WebElement elem = driver.findElement(By.xpath(Locators.disableButton));
		elem.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath(Locators.enableButton)));
			WebElement tbox = driver.findElement(By.xpath(Locators.dynamicTextBox));
			
			return !tbox.isEnabled();
		}catch(Exception e) {
			return false;
		}
		
	}
	public String dynamicLoading() {
		navigateUrl(Constants.DYNAMIC_LOADING);
		driver.findElement(By.xpath(Locators.dynamicLoadingStart)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.id(Locators.dynamicLoadingDivId)));
		WebElement text = driver.findElement(By.xpath(Locators.dynamicLoadingText));
		return text.getText();
	}
	public void fileDownload() {
		navigateUrl(Constants.DOWNLOAD_FILE);
		driver.findElement(By.xpath(Locators.fileDownload)).click();
	}
	
	public void fileUpload() {
		navigateUrl(Constants.FILEUPLOAD);
		String fName=System.getProperty("user.dir")+"\\upload_file\\abc.txt";
		Actions builder = new Actions(driver);
		
		builder.moveToElement(driver.findElement(By.id(Locators.uploadButtonId))).click().build().perform();
		driver.switchTo()
        .activeElement()
        .sendKeys(
                fName);
		
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			System.out.println("exception");
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		driver.findElement(By.id(Locators.uploadButtonSubmit)).click();
		
		
	}
	public String getFileUploadText() {
		String text="";
		WebElement el = driver.findElement(By.tagName("h3"));
		text = el.getText();
		return text;
	}
	public void navigateFloatingMenu() {
		navigateUrl(Constants.FLOATINGMENU);
	}
	public boolean floatingMenu() {
		
		WebElement elem = driver.findElement(By.tagName(Locators.floatingMenuUlTag));
		return elem.isDisplayed();
	}
	public void scrollFloatingMenu() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
	}
	
	public String checkIFrame(String text) {
		navigateUrl(Constants.IFRAME);
		driver.switchTo().frame(Locators.iframe);
		WebElement el = driver.findElement(By.xpath(Locators.iframeContent));
		el.clear();
		el.sendKeys(text);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		el = driver.findElement(By.xpath(Locators.iframeContent));
		return el.getText();
	}
	
	public boolean hoverEachElement() {
		navigateUrl(Constants.MOUSE_HOVER);
		String names[] = new String[] {"name: user1","name: user2","name: user3"};
		String prof = "View profile";
		List<WebElement> elems = driver.findElements(By.xpath(Locators.imageOverFig));
		Actions act = new Actions(driver);
		int len = elems.size();
		for(int i =0 ;i<len; i++) {
			act.moveToElement(elems.get(i)).perform();
			WebElement h5 = driver.findElements(By.xpath(Locators.figCaptionH5)).get(i);
			WebElement a =  driver.findElements(By.xpath(Locators.figCaptionA)).get(i);
			if(!h5.getText().equals(names[i]))
				return false;
			if(!a.getText().equals(prof))
				return false;
		}
		
		
		return true;
	}
	public void navigateAlert() {
		navigateUrl(Constants.JSALERTS);
	}
	public String clickJSAlert() {
		String text="";
		driver.findElement(By.xpath(Locators.jsAlert)).click();
		Alert alert = driver.switchTo().alert();
		text = alert.getText();
		alert.accept();
		
		return text;
	}
	public String clickJSConfirm() {
		String text="";
		driver.findElement(By.xpath(Locators.jsConfirm)).click();
		Alert alert = driver.switchTo().alert();
		text = alert.getText();
		alert.accept();
		
		return text;
	}
	public String clickPrompt(String inp) {
		driver.findElement(By.xpath(Locators.jsPrompt)).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(inp);
		alert.accept();
		WebElement res = driver.findElement(By.xpath(Locators.promptResult));
		return res.getText();
		
	}
	public String jsError() {
		WebElement el = driver.findElement(By.tagName("p"));
		return el.getText();
	}
	
	public String checkNewTab() {
		navigateUrl(Constants.NEWWINDOW);
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		if(browserTabs.size() > 1) {
			return "Already 2 windows";
		}
		driver.findElement(By.xpath(Locators.clickHere)).click();
		browserTabs = new ArrayList<String> (driver.getWindowHandles());
		if(browserTabs.size() == 1) {
			return "No two windows";
		}
		driver.switchTo().window(browserTabs.get(1));
		WebElement el = driver.findElement(By.tagName("h3"));
		String text = el.getText();
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
		return text;
		
	}
	public void navigateNotif() {
		navigateUrl(Constants.NOTIF);
	}
	public boolean clickNotif() {
		int plt = 0, suc = 1;
		int br = 0;
		while(true) {
			driver.findElement(By.xpath(Locators.clickHere)).click();
			WebElement fl = driver.findElement(By.xpath(Locators.notif));
			String txt = fl.getText();
			br += 1;
			if(txt.contains("please try again")) {
				plt += 1;
			}
			if(txt.contains("Action successful")) {
				suc += 1;
			}
			if(plt > 0 && suc > 0) {
				return true;
			}
			if(br==10) {
				return false;
			}
		}
		
	}
	
	public void killBrowser() {
		driver.quit();
	}
	public static void main(String[] args) {
		
	}
	
}
