package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Base.dotDashBase;
import com.POM.NotificationMsgPage;

public class NotificationMsgTest {
	public class NewTabTest extends dotDashBase {
		public WebDriver driver;

		@BeforeTest
		public void Driver() throws InterruptedException {

			driver = setupDriver();
			driver.get("http://localhost:7080/notification_message_rendered");//to launch the browser
		}


		public void msg(){
			NotificationMsgPage message = new NotificationMsgPage(driver);
			message.Message();
		}

		@AfterTest
		public void quit() {
			//driver.close();
			driver.quit();
		}			
	}
}
