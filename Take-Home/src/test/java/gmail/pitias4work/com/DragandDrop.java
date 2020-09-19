package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.library.pitias.Base;

public class DragandDrop extends Base {
	Logger logger = Logger.getLogger(Base.class);

	
	public void dragandDrop() {

		try {
			driver.get("http://localhost:7080/drag_and_drop");
			logger.info("Title is :" + driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			WebElement ABox = driver.findElement(By.id("column-a"));
			WebElement BBox = driver.findElement(By.id("column-b"));

			// Actions class method to drag and drop
			// Perform drag and drop

			lib.dragandDrop(ABox, BBox);

			lib.customWait(3);
			// verify text changed in to 'Drop here' box

			String textB = BBox.getText();
			if (textB.equals("A")) {
				
				logger.info("PASS: File dropped successfull");
				//assertTrue(false);
			} else {
				
				logger.info("FAIL: File doesn't doped as expected");
				//assertTrue(false);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			test.error(e.getMessage());
		}
	}
}