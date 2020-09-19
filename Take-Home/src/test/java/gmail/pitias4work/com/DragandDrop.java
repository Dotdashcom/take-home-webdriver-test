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
			logger.info("Title is :"+driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			WebElement Atext = driver.findElement(By.xpath("//header[contains(text(),'A')]"));
			WebElement Btext = driver.findElement(By.xpath("//header[contains(text(),'B')]"));
			String Atext1 = Atext.getText();
			// String Btext1 = Btext.getText();

			WebElement ABox = driver.findElement(By.id("column-a"));
			WebElement BBox = driver.findElement(By.xpath("//div[@id='column-b']"));

			lib.dragandDrop(ABox, BBox);

			// String btext2 = Btext.getText();
			// String atext2 = Atext.getText();

			assertEquals(Atext1, "A");
			// assertEquals(Btext1,atext2);

		} catch (Exception e) {
			logger.error(e.getMessage());
			test.error(e.getMessage());
		}
}}