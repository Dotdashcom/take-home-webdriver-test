package baseClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseutils {
	
	//for generating logs
	public Logger logger = LogManager.getLogger(this.getClass());
	
	public static WebDriver driver;
	
	public void initBrowser(String pathUrl) {
		//initialize chrome driver
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				
				//open url 
				String baseUrl="http://localhost:7080";
				driver.get(baseUrl+pathUrl);
				
				driver.manage().window().maximize();
				//driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		
	}
	
	//method to capture scheenshots
	public void captureSrceenshot(WebDriver driver, String testName) throws IOException {
		//capturing the screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source =  ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\screenshots\\"+testName+".png");
		//to copy and paste
		FileUtils.copyFile(source, target);
		logger.info("Screenshot captured successfully");
	}
	
	//enter values in the field
	public void EnterInInputField(WebElement element, String ValueToEnter, String FieldName) {
		element.clear();
		element.sendKeys(ValueToEnter);
		System.out.println("Text entered in " + FieldName + " is : " + ValueToEnter);
	}
	
	//click on the element
	public void clickOnElement(WebElement element, String FieldName) {
		element.click();
		System.out.println("Clicked on " + FieldName);
	}
	
	//element is displayed
	public boolean ElementDisplayed(WebElement element, String elementName) {
		if(element.isDisplayed()==true) {
		System.out.println(elementName + " is displayed");
		}else {
		System.out.println(elementName + " is not displayed");
		}
	return element.isDisplayed();
	}
	
	//element is enabled/disabled
	public boolean elementEnabled(WebElement element, String fieldName){
		if(element.isEnabled()==true){
			System.out.println(fieldName + " button is enabled");
		}else {
			System.out.println(fieldName + " button is disabled");
		}
		return element.isEnabled();
	}
	
	//get message
	public String getMessageText(WebElement element, String FieldName) {
		String messageText = element.getText();		
		System.out.println("Text dislayed in the "+ FieldName + " is : "+ messageText);
		return messageText;
	}
	
	//dataManupulation-substring
	public String messageToRetrieve(WebElement element, int endIndexVal) {
		String val = element.getText();
		String retrivedMsg = val.substring(0, endIndexVal);
		System.out.println("Message retrived is : "+ retrivedMsg);
		return retrivedMsg;
	}
	
	//clicking checkbox
	public boolean handlingCheckbox(WebElement element, String CheckboxName) {
		boolean status1 = element.isSelected();
		element.click();
		if(status1 == true) {
			System.out.println(CheckboxName +" is already selected before clicking");
		} else if (status1 == false) {
			System.out.println(CheckboxName +" is not selected before clicking");
		}
		boolean status2 = element.isSelected();
		if (status2 == true ) {
			System.out.println(CheckboxName +" is selected after clicking");
		} else if (status2 == false) {
			System.out.println(CheckboxName +" is not selected after clicking" );
		}
		return status2;
	}
	
	//mouse over operation for rightClick
	public void rightClick(WebDriver driver, WebElement element, String FieldName) {
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
		System.out.println("Right clicked on the : " + FieldName);
	}
	
	//moveto element
	public void moveToElement_click(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		//System.out.println("clicked on Element");
		//act.click(element).build().perform();
		
	}
	
	//handling dynamic contents and check after resfereshing
	public boolean handlingDynamicContents(WebElement element,WebElement element1, String elementName) {
		boolean status = true;
		String TextBefore = getMessageText(element, elementName);
		
		//clicking on refresh
		clickOnElement(element1, "refresh");
		
		String TextAfter = getMessageText(element, elementName);
		if(TextBefore.equalsIgnoreCase(TextAfter)) {
			status = true;
		}else {
			status = false;
		}
		return status;
	}
	
	//webdriverwait for element
	public void waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//wait till element is clickable
	public void ElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//to get the alert message
	public String HandlingAlert(WebDriver driver, WebElement element, String AlertName) {
		//clickOnElement(element, AlertName);
		String alertMsg = driver.switchTo().alert().getText();
		System.out.println("Alert message displayed is : "+alertMsg);
		return alertMsg;
	}
	
	//to click on the alert ok
	public void AcceptAlert(WebDriver driver) {

		driver.switchTo().alert().accept();
	}
	
	//to enter text in the alert
	public String EnterInalert(WebDriver driver,String TextToEnter) {
		driver.switchTo().alert().sendKeys(TextToEnter);
		System.out.println("text entered in Alert is :" + TextToEnter);
		return TextToEnter;
	}
		

}
