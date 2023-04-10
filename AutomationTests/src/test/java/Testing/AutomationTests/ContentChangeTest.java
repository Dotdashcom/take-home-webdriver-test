package Testing.AutomationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import pageobjects.ContentChangePage;
import resources.base;

public class ContentChangeTest extends base {

		public WebDriver driver;
		ContentChangePage contentChange;


		@BeforeMethod
		public void initialize() throws IOException {
			driver= initializeDriver();		
			driver.get(prop.getProperty("dynamiccontUrl"));

		}


		@Test
		public void validateDynamicContent() throws IOException, InterruptedException {	

			contentChange= new ContentChangePage(driver);
			for(int i=0; i<5; i++) {
				String fpold = contentChange.getfirstPara().getText();
				String spold = contentChange.getsecondPara().getText();
				String tpold = contentChange.getthirdPara().getText();
				driver.navigate().refresh();
				AssertJUnit.assertNotSame(contentChange.getfirstPara().getText(), fpold);
				AssertJUnit.assertNotSame(contentChange.getsecondPara(), spold);
				AssertJUnit.assertNotSame(contentChange.getthirdPara().getText(), tpold);
			}

		}


		@AfterMethod
		public void closeBrowser() {

			driver.close();
		}


}
