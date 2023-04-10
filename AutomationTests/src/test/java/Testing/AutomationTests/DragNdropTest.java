package Testing.AutomationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import pageobjects.DragNDropPage;
import resources.base;

public class DragNdropTest extends base{

		public WebDriver driver;
		DragNDropPage dragndrop;


		@BeforeMethod
		public void initialize() throws IOException {
			driver= initializeDriver();		
			driver.get(prop.getProperty("dragNdropUrl"));

		}


		@Test
		public void validateDragNDrop() throws IOException, InterruptedException {	

			dragndrop= new DragNDropPage(driver);
			dragndrop.dragNdrop(dragndrop.getBox("a"), dragndrop.getBox("b"));
				 AssertJUnit.assertEquals(dragndrop.getBox("a").getText(), "B");
				 AssertJUnit.assertEquals(dragndrop.getBox("b").getText(), "A");

		}


		@AfterMethod
		public void closeBrowser() {

			driver.close();
		}



	}

