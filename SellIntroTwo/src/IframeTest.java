import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeTest {

	@Test
	public static void iframeTest() {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:7080/iframe");
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("#mce_0_ifr")));
		
		driver.findElement(By.cssSelector("body p")).sendKeys("Helo");
		

	}

}
