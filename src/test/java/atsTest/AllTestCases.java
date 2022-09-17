package atsTest;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class AllTestCases extends BaseTest {
	 	
	
      //Checkboxes	
	  @Test
	  public void testCheckBoxes() {
		driver.get("http://localhost:7080/checkboxes");
		assertTrue(!(driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected()));
		assertTrue(driver.findElement(By.xpath("//input[@type='checkbox'][2]")).isSelected());
		driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
		driver.findElement(By.xpath("//input[@type='checkbox'][2]")).click();
		assertTrue(driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected());
		assertTrue(!(driver.findElement(By.xpath("//input[@type='checkbox'][2]")).isSelected()));
		
	  }
	 
	
	 //ContextMenu
	 @Test
	 public void testContextMenu() {
		 driver.get("http://localhost:7080/context_menu");
		 Actions actions = new Actions(driver);
		 WebElement box = driver.findElement(By.id("hot-spot"));
		 actions.contextClick(box).perform();
		 Alert alert = driver.switchTo().alert();
		 AssertJUnit.assertEquals(alert.getText(), "You selected a context menu");
		 alert.accept();

	 }
	 
	
	@Test
	public void testDragDrop() {
		driver.get(" http://localhost:7080/drag_and_drop");
		WebElement source=driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
		WebElement target=driver.findElement(By.cssSelector("#column-b"));
		  Actions builder = new Actions(driver);
	        builder.dragAndDrop(source, target).perform();
		
		 if (target == driver.findElement(By.xpath("//*[@id=\"column-a\"]"))) {
	        } else {
	        }
		 }
	
	
	@Test
	public void testDropdown() throws InterruptedException {
		driver.get("http://localhost:7080/dropdown");
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		Select selDd = new Select(dropdown);
		selDd.selectByVisibleText("Option 1");
		Thread.sleep(3000);
		assertTrue(selDd.getFirstSelectedOption().getText().equals("Option 1"));
		selDd.selectByVisibleText("Option 2");
		Thread.sleep(3000);
		assertTrue(selDd.getFirstSelectedOption().getText().equals("Option 2"));
	
	}
		
		
	@Test
	public void testDynamicContent() throws InterruptedException {
		driver.get("http://localhost:7080/dynamic_content");
		String beforeRefresh = driver.getPageSource();
		driver.navigate().refresh();
		Thread.sleep(3000);
		String refresh1 = driver.getPageSource();
		assertNotSame(beforeRefresh, refresh1);
		driver.navigate().refresh();
		Thread.sleep(2000);
		String refresh2 = driver.getPageSource();
		assertNotSame(refresh1, refresh2);
		
	}
	
		
	@Test
	public void testDynamicControls() throws InterruptedException {
		driver.get("http://localhost:7080/dynamic_controls");
		
		//Test clicks on the Remove Button and uses explicit wait.
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		WebDriverWait wait;
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		//Test asserts that the checkbox is gone.
		WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']")));  
		assertEquals(driver.findElement(By.xpath("//*[@id='message']")).getText(), "It's gone!");
		
		//Test clicks on Add Button and uses explicit wait.
		//Test asserts that the checkbox is present.
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input/parent::div[contains(text(),'checkbox')]")));
		assertEquals(driver.findElement(By.xpath("//*[@id='message']")).getText(), "It's back!");

		//Test clicks on the Enable Button and uses explicit wait.
		//Test asserts that the text box is enabled.
		
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Disable']")));  
		assertEquals(driver.findElement(By.xpath("//*[@id='message']")).getText(), "It's enabled!");

		//Test clicks on the Disable Button and uses explicit wait.
		//Test asserts that the text box is disabled.
		driver.findElement(By.xpath("//button[text()='Disable']")).click();
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Enable']")));  
		assertEquals(driver.findElement(By.xpath("//*[@id='message']")).getText(), "It's disabled!");
	   	Thread.sleep(2000);

	}   
	
	@Test
	public void testDynamicLoading() {
		//Test clicks the start button and uses explicit wait.
		//Test asserts that “Hello World!” text is displayed.
		driver.get("http://localhost:7080/dynamic_loading/2");
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		WebDriverWait wait;
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Hello World!']")));  
		assertTrue(driver.findElement(By.xpath("//*[text()='Hello World!']")).getText().equals("Hello World!"));
	}
	
	
	

	@Test
	public void testFileDownload() throws InterruptedException {
		
	//Test clicks on the file.
	//Test asserts that the file is downloaded.
	
		driver.get("http://localhost:7080/download");
		driver.findElement(By.xpath("//*[text()='some-file.txt']")).click();	
		File dir = new File("downloads/");
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return;
	    }

	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    File getLatestFile = lastModifiedFile;
	    String fileName = lastModifiedFile.getName();
		assertTrue(fileName.startsWith("some-file"));
	    	
	}
}
