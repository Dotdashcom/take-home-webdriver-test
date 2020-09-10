package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class pageObjectModel {
	public WebDriver driver;
	
	public pageObjectModel(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);  
	}
	
	
	//Locator for logIn Page
	@FindBy(xpath="//input[@id='username']")
	public WebElement username; 
	@FindBy(xpath="//input[@id='password']")
	public WebElement password; 
	@FindBy(xpath="//button[@type='submit']")
	public WebElement logIn; 	
	@FindBy(xpath="//div[@id='flash']")
	public WebElement logInSuccess; 

	public String getLogin(String usrname, String passwrd) {;
		username.sendKeys(usrname);	
		password.sendKeys(passwrd);		
		logIn.click();	
		return logInSuccess.getText();
	}
	
	//check uncheck locator
	@FindBy(xpath="//input[@type='checkbox']")
	public WebElement checkbox; 	
	public boolean getIsCheck() {
		boolean isChecked = checkbox.isSelected();
		return isChecked;
	}
	
	//ContextMenu
	@FindBy(xpath="//div[@oncontextmenu='displayMessage()']")
	public WebElement conTextmenu; 	
	public void getcontextmenuk() throws InterruptedException{
		Actions action = new Actions(driver);
		action.contextClick(conTextmenu).build().perform();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.switchTo().parentFrame().close();
		driver.navigate().refresh();
		
	}
	
	//Drag and Drop 
	@FindBy(xpath="//div[@id='column-a']")
	public WebElement from; 
	@FindBy(xpath="//div[@id='column-b']")
	public WebElement to; 
		
	public void dragAndDrop() throws InterruptedException{
		Actions action = new Actions(driver);
		action.dragAndDrop(from, to).build().perform();
		Thread.sleep(3000);
		action.click().build().perform();
	}
	
	//Select
	@FindBy(xpath="//select[@id='dropdown']")
	public WebElement all; 
	
	@FindBy(xpath="//option[contains(text(),'Option 1')]")
	public WebElement opt1;
	
	//option[contains(text(),'Option 1')]
			
	public void selectElement(){
		Select sel = new Select(all);
		sel.selectByVisibleText("Option 1");
		
		opt1.click();
	}
	
	//Dynamic Content	
		@FindBy(xpath="")
		public WebElement abc;

		
	//WebDriverWait wait = new WebDriverWait(driver,30);
		
	public void DynamicContent() throws InterruptedException{
		//rem.click();

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add')]']")));
		//Thread.sleep(3000);
		//add.click();
	}
	
	
	//Dynamic Control	
	@FindBy(xpath="//button[contains(text(),'Remove')]']")
	public WebElement rem;
	
	@FindBy(xpath="//button[contains(text(),'Add')]']")
	public WebElement add;

	
	public void DynamicControl() throws InterruptedException{
	
	}
	
	
	//Dynamic Load	
	@FindBy(xpath="")
	public WebElement efg;
		
		
	public void DynamicLoad() throws InterruptedException{
	
	}
	
	
	//Download
	@FindBy(xpath="//a[contains(text(),'some-file.txt')]")
	public WebElement download;

			
	public void Download() throws InterruptedException{
		download.click();
		Thread.sleep(1500);
	}
	
	//Upload
	@FindBy(xpath="//input[@id='file-upload']")
	public WebElement upload;
	
	@FindBy(xpath="//input[@id='file-submit']")
	public WebElement submit;
	

				
	public void Upload() throws InterruptedException{
		upload.sendKeys(System.getProperty("user.dir") + "/Feature/test.feature");
		submit.click();
	}
	
	//IFrame
	@FindBy(xpath="//iframe[@id='mce_0_ifr']")
	public WebElement iframe;
	@FindBy(xpath="//body[@id='tinymce']")
	public WebElement text;

					
	public void IFrame() throws InterruptedException{
		
		driver.switchTo().frame(iframe);

		text.sendKeys("Hello");
;
		driver.switchTo().parentFrame();
		
	}
	
	
	//Mouse Hover
	@FindBy(xpath="//div[@class='example']//div[1]//img[1]")
	public WebElement MouseHoverFrom;
	
	@FindBy(xpath="//div[@class='row']//div[2]//img[1]")
	public WebElement MouseHoverTo;

						
	public void MouseHover() throws InterruptedException{
		
		Actions ac = new Actions(driver);
		
		ac.moveToElement(MouseHoverFrom).moveToElement(MouseHoverTo).click().build().perform();
		
	}
	
	//JavaScript Alerts
	@FindBy(xpath="")
	public WebElement o;

							
	public void JavaScriptAlerts() throws InterruptedException{
						
	}
	
	//JavaScript Error
	@FindBy(xpath="")
	public WebElement p;

							
	public void JavaScriptError() throws InterruptedException{
						
	}
	
	//Open in New Tab
	@FindBy(xpath="//a[contains(text(),'Click Here')]")
	public WebElement openWindow;

							
	public void OpeninNewTab() throws InterruptedException{
						
		openWindow.click();
	}
	
	//Notification Message
	@FindBy(xpath="")
	public WebElement r;

								
	public void NotificationMessage() throws InterruptedException{
							
	}
	
	
	
	
}
