package Testing.AutomationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.MouseHoversPage;
import resources.base;

public class MouseHoverTest extends base{
	

		public WebDriver driver;
		MouseHoversPage mouseHover;
		

		@BeforeMethod
		public void initialize() throws IOException {
			driver= initializeDriver();		
			driver.get(prop.getProperty("hoversUrl"));

		}

		@Test
		public void validateMouseHover() throws IOException, InterruptedException {				
			mouseHover= new MouseHoversPage(driver);
			mouseHover.hoverAndVerifyCaption("firstavatar");
			mouseHover.hoverAndVerifyCaption("secondavatar");
			mouseHover.hoverAndVerifyCaption("thirdavatar");

		}


		@AfterMethod
		public void closeBrowser() {

			driver.close();
		}
}
