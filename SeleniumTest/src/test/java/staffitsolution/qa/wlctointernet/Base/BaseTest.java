package staffitsolution.qa.wlctointernet.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import staffitsolution.qa.wlctointernet.factory.DriverFactory;
import staffitsolution.qa.wlctointernet.pages.ContextMenu;
import staffitsolution.qa.wlctointernet.pages.DragAndDrop;
import staffitsolution.qa.wlctointernet.pages.LoginPage_Invalid;
import staffitsolution.qa.wlctointernet.pages.LoginPage_Valid;

public class BaseTest {

	public DriverFactory df;

	public WebDriver driver;

	public LoginPage_Valid loginPage_Valid;

	public LoginPage_Invalid loginPage_Invalid;

//	public ContextMenu contextmenu;
//	
//	public DragAndDrop draganddrop;

	public Properties prop;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginPage_Valid = new LoginPage_Valid(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
