import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FloatingMenu {

	
		@Test	
		public void Floating() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); // to maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
	driver.get("http://localhost:7080/floating_menu");
    
	//the is to check even if i scroll down, does the menus still visible or not. 
	//So to perform scroll down i am using javaScrpt executer. 
    JavascriptExecutor js = ( JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); // here i am scroll down all the way

}
	}

