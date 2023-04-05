package dotdash.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import dotdash.pageobjects.DragNDropPage;
import dotdash.resources.base;

public class DragNDropTest extends base{
	
	public WebDriver driver;
	DragNDropPage d;
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("dragNdropUrl"));
		
	}
	
	
	@Test
	public void validateDragNDrop() throws IOException, InterruptedException {	
		
			 d= new DragNDropPage(driver);
			 d.dragNdrop(d.getBox("a"), d.getBox("b"));
			 Assert.assertEquals(d.getBox("a").getText(), "B");
			 Assert.assertEquals(d.getBox("b").getText(), "A");
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	


}
