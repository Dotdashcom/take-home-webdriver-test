import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {

	@Test
	public static void mouseHoverTest() {
	
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:7080/hovers");
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[@class='example']//div[1]//img[1]"))).build().perform();

		driver.quit();
	}

}
