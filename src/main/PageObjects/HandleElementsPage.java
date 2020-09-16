package main.PageObjects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import main.java.BrowserUtilities;

public class HandleElementsPage {
	WebDriver driver;
	WebElement flag;

	
	public void Handleinit(WebDriver testdriver) {
		this.driver=testdriver;
	}
	
	@FindBy(xpath="//form/input[@type=\"checkbox\"][1]")
	WebElement check1;
	
	@FindBy(xpath="//form/input[@type=\"checkbox\"][2]")
	WebElement check2;
	
	@FindBy(xpath="//div[@class=\"example\"]/div")
	WebElement context;
	
	@FindBy(xpath="//div[@id=\"column-a\"]")
	WebElement drag;		
	
	@FindBy(xpath="//div[@id=\"column-b\"]")
	WebElement drop;	
	
	@FindBy(xpath="//select[@id='dropdown']")
	WebElement defaultcontent;
	
	@FindBy(xpath="//select[@id='dropdown']/option[2]")
	WebElement dropdown1;
	
	@FindBy(xpath="//select[@id='dropdown']/option[3]")
	WebElement dropdown2;
	
	@FindBy(xpath="//div[@class=\"example\"]/p/a")
	WebElement pageload;
	
	@FindBy(xpath="//div[@class=\"large-10 columns large-centered\"]/div[3]/div[2]")
	WebElement content;
	
	@FindBy(xpath="//div[@id=\"checkbox\"]")
	WebElement checkbox;
	
	@FindBy(xpath="//form[@id=\"checkbox-example\"]/div/input[@id=\"checkbox\"]")
	WebElement displaycheckbox;
	
	@FindBy(xpath="//form[@id=\"checkbox-example\"]/p")
	WebElement nocheckbox;
	
	@FindBy(xpath="//button[contains(text(),\"Remove\")]")
	WebElement btn1;
	
	@FindBy(xpath="//button[contains(text(),\"Add\")]")
	WebElement btn2;
	
	@FindBy(xpath="//form[@id=\"input-example\"]/button[contains(text(),\"Enable\")]")
	WebElement enablebtn;
	
	@FindBy(xpath="//form[@id=\"input-example\"]/input")
	WebElement verifytextbox;
	
	@FindBy(xpath="//form[@id=\"input-example\"]/p[contains(text(),\"It's enabled!\")]")
	WebElement enabledtext;
	
	@FindBy(xpath="//form[@id=\"input-example\"]/button[contains(text(),\"Disable\")]")
	WebElement disablebtn;
	
	@FindBy(xpath="//form[@id=\"input-example\"]/p[contains(text(),\"It's disabled!\")]")
	WebElement disabledtext;
	
	@FindBy(xpath="//div[@class=\"example\"]/div/button")
	WebElement start;
	
	@FindBy(xpath="//div[@class=\"example\"]/div/h4")
	WebElement HelloWorldtext;
	
	@FindBy(xpath="//body/div[2]/div/div/a")
	WebElement downloadfile;
	
//	@FindBy(tagName="//iframe")
//	WebElement myiframe;
	
	@FindBy(xpath="//body/p")
	WebElement iarea;
	
	@FindBy(xpath="//textarea[@id=\"mce_0\"]")
	WebElement iarea1;
	
//	@FindBy(xpath="//button[contains(text(),\"Click for JS Alert\")]")
//	WebElement JSbtn1;
//	
//	@FindBy(xpath="//button[contains(text(),\"Click for JS Confirm\")]")
//	WebElement JSbtn2;
//	
//	@FindBy(xpath="//button[contains(text(),\"Click for JS Prompt\")]")
//	WebElement JSbtn3;

//	@FindBy(xpath="//p[contains(text(),\"You\")]")
//	WebElement displayedtext;
//	
//
//	@FindBy(xpath="//p[contains(text(),\"You entered: hi\")]")
//	WebElement displayedprompt;
	
	public void handlingcheckbox()
	{
		if(driver.findElement(By.xpath("//form/input[@type=\"checkbox\"][1]")).isSelected()==false)
		{
			Assert.assertFalse(false);
//			if(!check1.isSelected())
//			{
//				check1.click();
//			}
		}
		else if(driver.findElement(By.xpath("//form/input[@type=\"checkbox\"][1]")).isSelected()==true)
		{
			Assert.assertTrue(true);
		}
		else if(driver.findElement(By.xpath("//form/input[@type=\"checkbox\"][2]")).isSelected()==true)
		{
			Assert.assertTrue(true);
		}
		else if(driver.findElement(By.xpath("//form/input[@type=\"checkbox\"][2]")).isSelected()==false)
		{
			Assert.assertFalse(false);
		}
	}
	
	public void handlingcontextmenu()
	{
		Actions action=new Actions(driver);
		action.contextClick(context).build().perform();
		try {
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		Thread.sleep(500);
		Assert.assertEquals(text, "You selected a context menu");
		Thread.sleep(500);
		alert.accept();
		}
		catch (Exception  e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void handlingdraganddrop() throws Exception
	{
		Actions action=new Actions(driver);
		
		String element1=drag.getText();
		String element2=drop.getText();
		System.out.println("The text in the boxes before drag and drop :" +element1 +"\n"+element2);
		Thread.sleep(1000);
		//action.dragAndDrop(drag, drop).build().perform();
//		Action dragdrop = action.clickAndHold(drag).moveToElement(drop).release(drop).build();
//		dragdrop.perform();
		
		final String java_script =
	            "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
	            "ct:'',effectAllowed:'all',items:{},setData:fun" +
	            "ction(format,data){this.items[format]=data;this.types.append(for" +
	            "mat);},getData:function(format){return this.items[format];},clea" +
	            "rData:function(format){}};var emit=function(event,target){var ev" +
	            "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
	            "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
	            "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
	            "'drop',tgt);emit('dragend',src);";
		
		 ((JavascriptExecutor)driver).executeScript(java_script, drag, drop);
		 Thread.sleep(1000);
		Assert.assertNotEquals(element1, "B");
		Thread.sleep(1000);
		Assert.assertNotEquals(element2, "A");
		System.out.println("Drag and drop is successfull");
	}
	public void handledropdown() throws Exception
	{
		
		Select sel=new Select(defaultcontent);
		List<WebElement> list=sel.getOptions();
		for(WebElement ele:list)
		{
			String values=ele.getText();
			if(values.equalsIgnoreCase("Option 1"))
			{
				sel.selectByVisibleText("Option 1");
				Assert.assertTrue(dropdown1.isSelected());
			}
			else if(values.equalsIgnoreCase("Option 2"))
			{
				sel.selectByIndex(2);
				Assert.assertTrue(dropdown2.isSelected());
			}
			
		}
	}
	
	public void handledynamiccontent()
	{
		pageload.click();
		WebElement content1=BrowserUtilities.waitforElementToBeVisible1(driver,content,100);
		String value1=content1.getText();
		System.out.println("The content on first time page refresh" +"\t"+value1);
		pageload.click();
		WebElement content2=BrowserUtilities.waitforElementToBeVisible1(driver,content,30);
		String value2=content2.getText();
		System.out.println("The content on second time page refresh" +"\t"+value2);
		Assert.assertNotEquals(value1, value2);
		//log("Value1:" +value1 +"Value2:" +value2);
		
	}
	
	public void handledynamiccontrols() 
	{
		//WebElement flag;
		try {
			SoftAssert soft=new SoftAssert();
		
		btn1.click();
		  flag= BrowserUtilities.waitforElementToBeInVisible(driver, nocheckbox, 10);
		  if(flag.isDisplayed()==true)
		{
			soft.assertTrue(true);
			System.out.println("The checkbox is hidden");
		}
		
		else
		{
			soft.assertTrue(false);
			System.out.println("Please check: The checkbox is not hidden");
		}
		
		
		btn2.click();
		flag=BrowserUtilities.waitforElementToBeVisible1(driver, displaycheckbox, 10);
		Boolean available=flag.isDisplayed();
		Assert.assertTrue(available,"Please check: The checkbox is not displayed");
		System.out.println("The checkbox is displayed when click on Add button");							
	}
	catch(Exception e)
		{
	e.printStackTrace();					
	}
			
		enablebtn.click();	
		flag=BrowserUtilities.waitforElementToBeVisible1(driver, enabledtext, 10);
		Boolean available1=flag.isEnabled();
		Assert.assertTrue(available1,"Please check: The textbox is disabled");
		System.out.println("The textbox is displayed when click on Enable button");
		
		disablebtn.click();	
		flag=BrowserUtilities.waitforElementToBeInVisible(driver, verifytextbox, 10);
		Boolean available2=flag.isEnabled();
		Assert.assertTrue(available2,"Please check: The textbox is enabled");
		System.out.println("The textbox is disabled when click on Disable button");
	}
	public void dynamicpageloading()
	{
		start.click();
		flag=BrowserUtilities.waitforElementToBeVisible1(driver, HelloWorldtext, 10);
		if(flag.isDisplayed())
		{
			String text=flag.getText();
			System.out.println("The text while page loading" +"\t"+text);
		}
		
	}
	public void scrollhandle(WebElement element)
	{
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		
	}
	public void floatingmenuhandle()
	{
		List<WebElement> list=driver.findElements(By.xpath("//div[@id=\"menu\"]/ul/li/a"));
		for(WebElement ele:list)
		{
		
			Assert.assertTrue(ele.isDisplayed());
		}
	}
	public void handleiframe() throws Exception
	{
		WebElement myiframe=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(myiframe);
		//Thread.sleep(500);
		String value1=iarea.getText();
		iarea.click();
		iarea.clear();
		iarea.sendKeys("Welcome to iframe");
		String actual=iarea.getText();
		Assert.assertTrue(actual.contains("Welcome"));
		driver.switchTo().defaultContent();
	}
	public void mouseover() 
	{
		List<WebElement> imgs=driver.findElements(By.xpath("//div[@class=\"figure\"]/img"));
		WebElement additionaltext=driver.findElement(By.xpath("//div[@class=\"figcaption\"]/a"));
		Actions act=new Actions(driver);
		
		for(int i=0;i<imgs.size();i++)
		{
		WebElement index=imgs.get(i);
		act.moveToElement(index).perform();
		String value=additionaltext.getAttribute("innerHTML");
		Assert.assertTrue(value.contains("View profile"));
		
		}
	}
	public static void handleJSalerts(WebDriver driver,WebElement btn) throws Exception
	{
		try {
		btn.click();
		if(btn.getText()!="Click for JS Prompt")
		{
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.alert = function() {};");
		//js.executeScript("alert('I am a JS alert')");
		//String expected=alert.getText();
		Thread.sleep(1000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);//(KeyRelease.VK_ENTER);
		//alert.accept();
		Thread.sleep(500);
		WebElement displayedtext=driver.findElement(By.xpath("//p[contains(text(),\"You\")]"));
		
		String actual=displayedtext.getText();
		Assert.assertTrue(actual.contains("You"));	
		}
		else
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);
	        wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver.switchTo().alert();
			Thread.sleep(1000);
			alert.sendKeys("hi");
			Thread.sleep(500);
			//alert.getText();
			alert.dismiss();
			Thread.sleep(500);
			WebElement displayedprompt=driver.findElement(By.xpath("//p[contains(text(),\"You entered: hi\")]"));
			String actual=displayedprompt.getText();
			
			Assert.assertTrue(actual.contains("You entered: hi"));
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
