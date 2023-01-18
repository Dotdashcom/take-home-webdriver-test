package checkbox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxes {

	static String url = "http://localhost:7080/checkboxes";
	static  WebDriver driver;
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
    public void checkTheBoxes() throws InterruptedException {
		List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int i = 0; i < elements.size(); i++) {

			if (elements.get(i).isEnabled()) {
				elements.get(i).click();
			} else if (elements.get(i).isSelected()) {

				elements.get(i).click();
				Assert.assertEquals("null",elements.get(i).getAttribute("checked"));
			}else {
				elements.get(i).click();
				Assert.assertEquals("true",elements.get(i).getAttribute("checked"));
			}
		}
		

		
	}
     @AfterTest
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	

}
