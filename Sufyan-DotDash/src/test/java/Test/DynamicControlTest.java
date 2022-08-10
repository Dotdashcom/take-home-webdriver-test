package Test;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Util.BrowserFactory;

public class DynamicControlTest   extends BrowserFactory{

	@Before
    public void Setup()
	{
		startBrowser();
	}
	
	@Test
	public void verify_DynamicControls()
	{
		driver.get("http://localhost:7080/dynamic_controls");
		WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));

		removeButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		
		//asserts that the check box is gone.
		Boolean isACheckBoxPresent = driver.findElements(By.xpath("//div[@id='checkbox']/input")).size()== 0;
		assertTrue(isACheckBoxPresent);
		    
		WebElement addButton = driver.findElement(By.xpath("//button[1]"));
		addButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='checkbox']")));
		
		//asserts that the check box is present.
		Boolean isPresent1 = driver.findElements(By.xpath("//input[@id='checkbox']")).size()== 0;
		assertTrue(!isPresent1);
	    

		
	    WebElement enableButton = driver.findElement(By.xpath("//*[@id='input-example']/button"));
	    enableButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-example']//descendant::p")));
        
        // asserts that the text box is enabled
        String disableAttribute = driver.findElement(By.xpath("//*[@id='input-example']/input")).getAttribute("disabled");
        if(disableAttribute == null|| disableAttribute==""||disableAttribute==" ")assertTrue(true);
	       else assertTrue(false);
    
        WebElement disableButton = driver.findElement(By.xpath("//*[@id='input-example']/button"));
        disableButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-example']//descendant::p")));
        
        
        //asserts that the text box is disabled.
        boolean IsTextBoxEnabled = driver.findElement(By.xpath("//*[@id='input-example']/input")).isEnabled();
        if(!IsTextBoxEnabled) assertTrue(true);
        else assertTrue(false);
        
	    

	}
    @After 
    public void tearDown() 
    {
    	closeBrowser();
    }

}
