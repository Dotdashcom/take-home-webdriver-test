import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowTest {

	@Test
	public static void windowTest() {

		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:7080/windows");
		
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		it.next();
		String newId=it.next();
		
		driver.switchTo().window(newId);
		
		driver.quit();

	}

}
