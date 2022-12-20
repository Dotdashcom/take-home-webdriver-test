package com.dotdashcom.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Dragdrop {

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		 
		driver.get("http://localhost:7080/drag_and_drop");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void dragDropAction() {
		
		WebElement source = driver.findElement(By.id("column-a"));
		String sourceText = source.getText();
		
		WebElement target = driver.findElement(By.id("column-b"));
		
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

		((JavascriptExecutor)driver).executeScript(java_script, source, target);
		
		Assert.assertEquals(target.getText(), sourceText);
		
		/*Actions actionBuilder = new Actions(driver);
		
		  actionBuilder.clickAndHold(source)
				.moveToElement(target)
				.release(target)
				.build()
				.perform();

				//Performing the drag and drop action
				//dragAndDrop.perform();*/
				
		//actionBuilder.dragAndDrop(source, target).perform();
		//System.out.println("After="+target.getText());
	}
}
