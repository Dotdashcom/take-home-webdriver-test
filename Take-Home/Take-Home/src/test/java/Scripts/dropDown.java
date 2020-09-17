package Scripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Library.Base;

public class dropDown extends Base{


	@Test
	public void logger() {
		
		try {
			driver.get("http://localhost:7080/dropdown");
			System.out.println(driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");
			
			WebElement dropdown =driver.findElement(By.cssSelector("#dropdown"));
			Select sel = new Select(dropdown);
		       sel.selectByIndex(1);
			
		    //Assertion Method   
		    String selectedText = sel.getFirstSelectedOption().getText();
			assertEquals(selectedText, "Option 1");
			
			Thread.sleep(3000);
			
			
      }catch(Exception e) {
	System.out.println(e.getMessage());}
		
		
		
     }
}
