import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.LoginPage;

public class DemoTest {

	WebDriver driver;

	@Before
	public void laucnhBrowser() {
		driver = new ChromeDriver();
		driver.get("http:localhost:7080/");
	}

	@Test
	public void firstTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/login");
		LoginPage login = new LoginPage(driver);
		login.login();
	}

	@Test
	public void secondTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/login");
		LoginPage login = new LoginPage(driver);
		login.login();
	}

	@Test
	public void ThirdTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/checkboxes");
		LoginPage login = new LoginPage(driver);
		login.checkChexBoxes();
	}
	@Test
	public void FourthTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/context_menu");
		LoginPage login = new LoginPage(driver);
		login.rightClick();
	}
	@Test
	public void FifthTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/drag_and_drop");
		LoginPage login = new LoginPage(driver);
		login.dragAndDrop();
	}
	@Test
	public void SixthTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/dropdown");
		LoginPage login = new LoginPage(driver);
		login.selectDropDown();
	}

	@Test
	public void SeventhTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/dynamic_content?with_content=static");
		LoginPage login = new LoginPage(driver);
		login.staticContent();
	}
	@Test
	public void EighthTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/dynamic_controls");
		LoginPage login = new LoginPage(driver);
		login.handleAjax();
	}
	@Test
	public void NinethTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/dynamic_loading/2");
		LoginPage login = new LoginPage(driver);
		login.handleDynamicLoad();
	}

	@Test
	public void TenthTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/download");
		LoginPage login = new LoginPage(driver);
		login.fileHandle();
	}

	@Test
	public void EleventhTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/upload");
		LoginPage login = new LoginPage(driver);
		login.fileUpload();
	}
	@Test
	public void TwelthTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/floating_menu#about");
		LoginPage login = new LoginPage(driver);
		login.floatingMenu();
	}
	@Test
	public void Thirteenth()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/iframe");
		LoginPage login = new LoginPage(driver);
		login.iframeHandle();
		
	}
	@Test
	public void FoyrteenTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/hovers");
		LoginPage login = new LoginPage(driver);
		login.imageHover();
		
	}
	@Test
	public void FifTeenthTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/javascript_alerts");
		LoginPage login = new LoginPage(driver);
		login.jsAlert();
		
	}

	@Test
	public void SixteenthTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/javascript_error");
		LoginPage login = new LoginPage(driver);
		login.jsError();
		
	}
	@Test
	public void SeventeenthTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/windows");
		LoginPage login = new LoginPage(driver);
		login.windowHandles();
		
	}
	@Test
	public void EighteenthTest()  {
		System.out.println(driver.getTitle());
		driver.get("http:localhost:7080/notification_message_rendered");
		LoginPage login = new LoginPage(driver);
		login.notificationMessage();
		
	}


	@After
	public void closeBrowser() {
		driver.quit();
	}

}
