package Test;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Util.MainClass;

public class DynamicContentTest  extends MainClass{

	@Before
    public void Setup()
	{
		startBrowser();
	}
    @Test 
    public void Verify_DynamicContent() throws Exception 
    {   
    	driver.get("http://localhost:7080/dynamic_content");
    	
    	
     	WebElement content = driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]"));
     	String ContnetBeforRefresh = content.getText();
     	//First refresh
     	driver.navigate().refresh();
     	
     	WebElement content1 = driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]"));
     	String ContnetAfterFirstRefresh = content1.getText();

     	assertTrue(!ContnetBeforRefresh.equals(ContnetAfterFirstRefresh));
     	
     	//Second refresh
        driver.navigate().refresh();
        
     	WebElement content2 = driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]"));
     	String ContnetAfterSecondRefresh = content2.getText();

     	assertTrue(!ContnetAfterFirstRefresh.equals(ContnetAfterSecondRefresh));
        

    }

    @After 
    public void tearDown() 
    {
    	closeBrowser();
    }

}
