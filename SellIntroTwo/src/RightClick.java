import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RightClick {

	@Test
	public static void rightClickTest() {
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:7080/context_menu");
		
		driver.manage().window().maximize();
		Actions a=new Actions(driver);
		
		WebElement rightClickElement=driver.findElement(By.id("hot-spot"));
		a.contextClick(rightClickElement).perform();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertEquals(alert.getText(), "You selected a context menu");
		
		alert.accept();
		
		driver.quit();

	}

}
