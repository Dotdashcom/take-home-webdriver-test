package webDriverTest;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import basePackage.BaseClass;
import pomPackage.PomContextMenu;

public class ContextMenuTest extends BaseClass {
	
	PomContextMenu rightclick ;
	
	public ContextMenuTest() {
		super();
		
	}
	
       @BeforeMethod
	
	   public void initsetup() {
		
    	initiation();
	
		
		rightclick = new PomContextMenu(); 
		
		driver.get("http://localhost:7080/context_menu");	
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
       
       @Test
       
       
       public void righclickonbox() throws InterruptedException {
    	   
    	 rightclick.rightclickoncontextmenu();
    	  
    	  
    	 
         String message=	 rightclick.alert();
    	 
         		
    	 
    	 Assert.assertEquals(message, "You selected a context menu", "Alert successfull");
    	  
    	   
    	   
       }
       
       @AfterMethod
       
   		public void teardown() {
      		
      		driver.quit();
      	}
      	
       
       
	

}
