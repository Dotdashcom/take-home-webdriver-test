package iframe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Iframe {

	static String url = "http://localhost:7080/hovers";
	static WebDriver driver;

	@BeforeTest
	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void iframe() throws InterruptedException {
		WebElement mainMenu0 = driver.findElement(By.xpath("//*[@id=\"content\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(mainMenu0);

		WebElement subMenu1 = driver.findElement(By.xpath("//div[@class='example']//div[1]//img[1]"));
		actions.moveToElement(subMenu1);

		WebElement subMenu2 = driver.findElement(By.xpath("//div[@class='row']//div[2]//img[1]"));
		actions.moveToElement(subMenu2);

		WebElement subMenu3 = driver.findElement(By.xpath("//div[@class='row']//div[3]//img[1]"));
		actions.moveToElement(subMenu3);

		actions.click().build().perform();

		WebElement element = driver.findElement(By.xpath("//a[@href='/users/1']"));
		
		Assert.assertEquals("user2",element.getText());
		

	}

    @AfterTest
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
