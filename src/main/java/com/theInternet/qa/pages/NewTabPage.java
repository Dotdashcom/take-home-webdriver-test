package com.theInternet.qa.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NewTabPage {

	WebDriver driver;

    @FindBy(linkText = "Click Here")
     WebElement clickHere;

    @FindBy(xpath = "//h3[text()='New Window']")
     WebElement newWindow_txt;
    
    @FindBy(xpath = "//h3[text()='Opening a new window']")
    WebElement openingNewWindow_txt;

    public NewTabPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    
    
    public void verifyNewTabDisplay()
    {
    	String parentWindowHandle = driver.getWindowHandle(); 
    	clickHere.click();
    	Set<String> set_of_window_handles=driver.getWindowHandles();
    	  for (String child_window_handle : set_of_window_handles)
          {
              if (!parentWindowHandle.equals(child_window_handle))
              {
            	  driver.switchTo().window(child_window_handle);
            	  Assert.assertEquals(newWindow_txt.getText(),"New Window");
            	  
              }
    	
    }
    	  driver.switchTo().window(parentWindowHandle);
    	  Assert.assertEquals(openingNewWindow_txt.getText(),"Opening a new window");
}
}
