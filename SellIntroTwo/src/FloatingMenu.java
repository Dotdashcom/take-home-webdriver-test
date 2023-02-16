import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatingMenu {

	@Test
	public static void floatingMenuTest() {
	
		WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:7080/floating_menu");

        WebElement floatingMenu = driver.findElement(By.cssSelector("a[href='#news']"));
        
        Actions actions = new Actions(driver);

        actions.moveToElement(floatingMenu).build().perform();

        Assert.assertTrue(floatingMenu.isDisplayed());

        driver.quit();

	}

}
