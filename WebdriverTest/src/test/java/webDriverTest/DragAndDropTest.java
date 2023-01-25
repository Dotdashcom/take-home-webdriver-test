package webDriverTest;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import basePackage.BaseClass;
import pomPackage.PomContextMenu;
import pomPackage.PomDragAndDrop;

public class DragAndDropTest extends BaseClass {
	
	PomDragAndDrop drag;
	
	
	public DragAndDropTest() {
		super();
		
	}
	
	@BeforeMethod
	
	   public void initsetup() throws InterruptedException {
		
		initiation();
 	
		drag = new PomDragAndDrop();
				
		driver.get("http://localhost:7080/drag_and_drop");	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
	}
	@Test
	public void varifydrag() throws InterruptedException {
		
		drag.draganddrop();
		
	String a=	drag.varifydraganddrop();
		
		Assert.assertEquals(a, "A", "box A switched");
		
	}
	
	 @AfterMethod
     
	   	public void teardown() {
	      		
	      		driver.quit();
	      	}
	      	
}
