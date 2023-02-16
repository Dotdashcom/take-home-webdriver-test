import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicContent {

	@Test
	public static void DynamicContentTest() {
	
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:7080/dynamic_content");
		
		String firstLoad=driver.findElement(By.cssSelector("body div[class='row'] div[id='content'] div[id='content'] div:nth-child(1) div:nth-child(2)")).getText();
		
		driver.navigate().refresh();
		
		String secondLoad=driver.findElement(By.cssSelector("body div[class='row'] div[id='content'] div[id='content'] div:nth-child(1) div:nth-child(2)")).getText();
		
		driver.quit();
		
		System.out.println(firstLoad);
		System.out.println(secondLoad);
		
		
		

	}

}
