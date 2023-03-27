package org.ithaka.portico.demo.ui.pages;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
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

public class ContextMenuPage {
	
	public  WebDriver driver;
	
	public ContextMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ContextMenuPage() {}
	
	
	//context menu elements
	@FindBy(id="hot-spot")
	public WebElement context_menu;
	
	@FindBy(xpath="//h3")
	public WebElement webpage;

	
	//drag and drop elements
	@FindBy(id="column-a")
	public WebElement column_a;
	
	
	@FindBy(id="column-b")
	public WebElement column_b;
	
	
	//dropdown elements
	@FindBy(xpath="//select[@id='dropdown']")
	public WebElement dropdown;
	
	
	//dynamic content
	//@FindBy(xpath="//div[contains(@class,'large-10')][1]")
	@FindBy(className="large-10")
	public WebElement dynamic_column_10;
	
	
	@FindBy(xpath="//button[contains(text(),'Remove')]")
	public WebElement button_remove;
	
	@FindBy(xpath="//button[contains(text(),'Add')]")
	public WebElement button_add;
	
	@FindBy(xpath="//button[contains(text(),'Enable')]")
	public WebElement button_enable;
	
	@FindBy(xpath="//button[contains(text(),'Disable')]")
	public WebElement button_disable;
	
	@FindBy(id="checkbox")
	public WebElement dynamic_checkbox;
	
	@FindBy(xpath="//form[@id='input-example']/input")
	public WebElement dynamic_textbox;
	
	
	//dynamic loading exercise 2
	@FindBy(xpath="//div[@id='finish']")
	public WebElement helloworld_txt;
	
	@FindBy(xpath="//button[contains(text(),'Start')]")
	public WebElement button_start;
	
	//File Downloader
	@FindBy(xpath="//a[@href='download/some-file.txt']")
	public WebElement file_link;
	
	
	//File Uploader
	@FindBy(xpath="//div[@class='example']")
	public WebElement upload_success_msg;
	
	
	@FindBy(xpath="//input[@id='file-upload']")
	public WebElement choose_file_input;		
	
	@FindBy(xpath="//input[@id='file-submit']")
	public WebElement upload_file_btn;	
	
	
	//Floating Menu Test Elements
	@FindBy(xpath="//a[@href='#home']")
	public WebElement menu_home;
	
	@FindBy(xpath="//a[@href='#news']")
	public WebElement menu_news;
	
	@FindBy(xpath="//a[@href='#contact']")
	public WebElement menu_contact;
	
	@FindBy(xpath="//a[@href='#about']")
	public WebElement menu_about;
	
	
	//iframe test
	@FindBy(xpath="//iframe[@id='mce_0_ifr']")
	public WebElement iframe_element;	
	
	
	//hovers test
	@FindBy(xpath="//div[@class=\"figure\"][1]")
	public WebElement hovers_figcaption_1;
	
	@FindBy(xpath="//div[@class=\"figure\"][2]")
	public WebElement hovers_figcaption_2;
	
	@FindBy(xpath="//div[@class=\"figure\"][3]")
	public WebElement hovers_figcaption_3;
	
	
	//Button for js alerts
	@FindBy(xpath="//li[1]/button")
	public WebElement alert_btn_1;
	
	@FindBy(xpath="//li[2]/button")
	public WebElement alert_btn_2;
	
	@FindBy(xpath="//li[3]/button")
	public WebElement alert_btn_3;
	
	@FindBy(xpath="//p[@id='result']")
	public WebElement result_txt;
	
	
	@FindBy(xpath="//p[contains(text(),'error')]")
	public WebElement js_err;
	
	//window tests
	@FindBy(xpath="//a[@href='/windows/new']")
	public WebElement window_link;
	
	
	//notifications
	@FindBy(xpath="//a[@href='/notification_message']")
	public WebElement notification_link;
	
	@FindBy(xpath="//div[@class='example']/p/a")
	public WebElement notification_anchor;
	
	
	@FindBy(xpath="//div[@class='flash notice']")
	public WebElement flash_msg;
	
	
	
	public void rightClickTheContextMenu() {
		
		driver.get("http://localhost:7080/context_menu");
		
		
		//Instantiate Action Class
		   Actions actions = new Actions(driver);
		   actions.contextClick(context_menu).perform();
		   
		   Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());

		   driver.switchTo().alert().accept();
		  

	}
	
	
	public void performDragDrop() {
		
		driver.get("http://localhost:7080/drag_and_drop");
		
		//Here, getting x and y offset to drop source object on target object location
				//First, get x and y offset for from object
				int xOffsetfrom = column_a.getLocation().getX();
				int yOffsetfrom =  column_a.getLocation().getY();
				
				
				int xOffsetto = column_b.getLocation().getX();
				int yOffsetto =  column_b.getLocation().getY();
				
		
		Actions actions = new Actions(driver);
		   actions.dragAndDropBy(column_a, xOffsetto-xOffsetfrom,yOffsetto-yOffsetfrom ).perform();
		   
		   //actions.dragAndDrop(column_a,column_b);
		   
		   Assert.assertEquals("A", column_a.getText());
		   
	}
	

	public void dropDownTest() {
		
		driver.get("http://localhost:7080/dropdown");
		
		Select select = new Select(dropdown);
		select.selectByIndex(1);
		
		
		select.selectByValue("2");
		
	}
	
	public void dynamicContent1() {
		
		driver.get("http://localhost:7080/dynamic_content");
		
		String originalText = dynamic_column_10.getText();
		
		driver.navigate().refresh();
		
		
		Assert.assertFalse("Dynamic Content is not refreshing", dynamic_column_10.getText().equalsIgnoreCase(originalText));
		
	}
	
	
	public void dynamicContentWithExplicitWait() {
		
		driver.get("http://localhost:7080/dynamic_controls");
		
		Assert.assertNotNull(dynamic_checkbox);
		
		
		
		if(button_remove.isDisplayed())
			button_remove.click();
		
		
		
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(button_add));
		
		button_add.click();
		
		Assert.assertNotNull(dynamic_checkbox);
		
		
		
	}
	
	
	public void dynamicContentWithExplicitWait2() {
		
		driver.get("http://localhost:7080/dynamic_controls");
		
		//Textbox handling
		
				Assert.assertFalse(dynamic_textbox.isEnabled());
				
				if(button_enable.isEnabled())
					button_enable.click();
				
				
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOf(button_disable));
				
				Assert.assertTrue(dynamic_textbox.isEnabled());
				

	}
	
	public void dynamicLoadingExercise2() {
		
		driver.get("http://localhost:7080/dynamic_loading/2");
		
		button_start.click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(helloworld_txt));
		
		
		Assert.assertTrue(helloworld_txt.isDisplayed());
		
	}
	
	public void fileDownloader() {
		
		driver.get("http://localhost:7080/download");
		
		file_link.click();
		
		//Actions actions = new Actions(driver);
		
		//actions.sendKeys("Save");
	}
	
	
	public void fileUploader() {
		
		
		driver.get("http://localhost:7080/upload");
		
		//choose_file_input.click();
		choose_file_input.sendKeys("//Users/lmilton/some-file.txt");
		
		
		
		//Actions actions = new Actions(driver);
		//actions.click(button_add)
		
		upload_file_btn.click();
	
		
		Assert.assertTrue(upload_success_msg.isDisplayed());
		
		
	}
	
	public void scrollAndCheckMenu() {
		
		driver.get("http://localhost:7080/floating_menu");
		
		Assert.assertTrue(menu_home.isDisplayed());
		Assert.assertTrue(menu_news.isDisplayed());
		Assert.assertTrue(menu_contact.isDisplayed());
		Assert.assertTrue(menu_about.isDisplayed());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		
		Assert.assertTrue(menu_home.isDisplayed());
		Assert.assertTrue(menu_news.isDisplayed());
		Assert.assertTrue(menu_contact.isDisplayed());
		Assert.assertTrue(menu_about.isDisplayed());
		
		js.executeScript("window.scrollBy(0,-250)", "");
		
		
	}
	
	
	public void iframeExists() {
		
		driver.get("http://localhost:7080/iframe");
		
		Assert.assertTrue(iframe_element.isDisplayed());
		
	}
	
	public void hoversTest() {
		
		driver.get("http://localhost:7080/hovers");
		
		//Instantiate Action Class
		   Actions actions = new Actions(driver);
		   actions.moveToElement(hovers_figcaption_1);
		   
		   actions.moveToElement(hovers_figcaption_2);
		   
		   actions.moveToElement(hovers_figcaption_3);
		   

	}

	
	public void javascriptAlerts() {
		
		driver.get("http://localhost:7080/javascript_alerts");
		
		
		//Instantiate Action Class
		   Actions actions = new Actions(driver);
		   actions.click(alert_btn_1).perform();
		   Assert.assertEquals("I am a JS Alert", driver.switchTo().alert().getText());
		   driver.switchTo().alert().accept();
		   Assert.assertEquals("You successfuly clicked an alert",result_txt.getText());
		   
		   
		   actions.click(alert_btn_2).perform();
		   Assert.assertEquals("I am a JS Confirm", driver.switchTo().alert().getText());
		   driver.switchTo().alert().accept();
		   Assert.assertEquals("You clicked: Ok",result_txt.getText());
		   
		   
		   actions.click(alert_btn_3).perform();
		   driver.switchTo().alert().sendKeys("Hello World!");
		   Assert.assertEquals("I am a JS prompt", driver.switchTo().alert().getText());
		   driver.switchTo().alert().accept();
		   Assert.assertEquals("You entered: Hello World!",result_txt.getText());
		   
	}
	
	
	public void jsError() {
		
		driver.get("http://localhost:7080/javascript_error");
		
		Assert.assertEquals("Cannot read property 'xyz' of undefined", js_err.getText().equals( "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques."));
		
	}
	
	public void newWindow() {
		
		driver.get("http://localhost:7080/windows");
		
		Assert.assertTrue(window_link.isDisplayed());
		
		window_link.click();
		
		//Actions actions = new Actions(driver);
	
		//driver.switchTo().window("New Window");
		
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();
		String tab1 = it.next();
		String tab2 = it.next();
		driver.switchTo().window(tab1);
		
	
		driver.switchTo().window(tab2);
		Assert.assertTrue(driver.getTitle().equals("New Window"));
		
	}
	
	public void notifications() {
		
		driver.get("http://localhost:7080/notification_message_rendered");
		
		
		WebElement notification_anchor = driver.findElement(By.xpath("//div[@class='example']/p/a"));
		
				
		//driver.findElement(By.xpath("//a[@href='/notification_message']"));
		
		//driver.findElement(By.cssSelector("//a[@href='/notification_message']"));
		
		//notification_link.click();
		
		
		
		notification_anchor.click();
		
		System.out.println("I clicked on anchor 1");
		
				
		Assert.assertTrue(flash_msg.getText().contains("Action"));
		
		System.out.println(flash_msg.getText() + "the actual text");
		
		driver.navigate().refresh();
		
		notification_anchor = driver.findElement(By.xpath("//div[@class='example']/p/a"));
		
		
		notification_anchor.click();
		
		System.out.println("I clicked on anchor 2");
		
		
		Assert.assertTrue(flash_msg.getText().contains("Action"));
		
		
		driver.navigate().refresh();
		
		notification_anchor = driver.findElement(By.xpath("//div[@class='example']/p/a"));
		
		
		notification_anchor.click();
		
		System.out.println("I clicked on anchor 3");
		
		
		Assert.assertTrue(flash_msg.getText().contains("Action"));
		
	}
	
	

}
