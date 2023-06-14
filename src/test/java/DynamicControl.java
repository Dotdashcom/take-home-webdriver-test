import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicControl {

	private ChromeDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\AssementDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dynamic_controls");
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	
	@Test
	public void check() {
		WebElement button = driver.findElement(By.id("checkbox-example")).findElement(By.tagName("button"));
		Actions action = new Actions(driver);
		WebElement checkbox = driver.findElement(By.id("checkbox"));	
		action.click(button).perform();

		new WebDriverWait(driver, Duration.ofMillis(3000)).until(ExpectedConditions.elementToBeClickable(button));

		try{
			checkbox = driver.findElement(By.id("checkbox"));		
		}catch(Exception e ) {
			checkbox = null;
		}
		assert checkbox == null;
		action.click(button).perform();

		new WebDriverWait(driver, Duration.ofMillis(3000)).until(ExpectedConditions.elementToBeClickable(button));
		try{
			checkbox = driver.findElement(By.id("checkbox"));		
		}catch(Exception e ) {
			checkbox = null;
		}
		assert checkbox != null;

		WebElement inputButton = driver.findElement(By.id("input-example")).findElement(By.tagName("button"));
		WebElement input = driver.findElement(By.id("input-example")).findElement(By.tagName("input"));

		action.click(inputButton).perform();
		new WebDriverWait(driver, Duration.ofMillis(3000)).until(ExpectedConditions.elementToBeClickable(inputButton));
		assert input.getAttribute("disabled") == null;

		action.click(inputButton).perform();
		new WebDriverWait(driver, Duration.ofMillis(3000)).until(ExpectedConditions.elementToBeClickable(inputButton));
		assert input.getAttribute("disabled") != null;


	}
	
}
