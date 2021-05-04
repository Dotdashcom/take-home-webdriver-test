package com.arthi.pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import com.arthi.automation.common.PageBase;

public class NewWindowOpenPage  extends PageBase{
	
	private static final String Base_Url="http://localhost:7080/windows";
	private static final String newWindowURL ="http://localhost:7080/windows/new";
	
	@FindBy(xpath="//div[@class='example']//a")
	 private WebElement clickHereBtn ;
	
	public NewWindowOpenPage(WebDriver driver) {
		super(driver);	
	}

	
	public NewWindowOpenPage navigateToNewWindowOpenPage() {
		driver.get(Base_Url);
		return this;
		
		
	}
	
       
    public void checkWindowEvents() throws AWTException {
        
    String currentHandle= driver.getWindowHandle();
    clickHereBtn.click();
        
        
        Robot r = new Robot();        
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_T);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_T);
        
        //getting all the handles currently available
        Set<String> handles=driver.getWindowHandles();
        for(String actual: handles)
        {
            
         if(actual.equalsIgnoreCase(currentHandle))
         {
             //switching to the opened tab
             driver.switchTo().window(actual);
             
             //opening the URL saved.
             driver.get(newWindowURL);
         }
        }
        
        driver.switchTo().window(currentHandle);
	
       }
	
	
	

}
