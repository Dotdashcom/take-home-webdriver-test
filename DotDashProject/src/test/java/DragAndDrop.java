import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	@Test	
	public void DragDrop() {

		/*WebDriverManager.firefoxdriver().setup();;
		WebDriver driver = new FirefoxDriver();
		*/
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:7080/drag_and_drop");
		driver.manage().window().maximize(); // to maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		//inspecting the element that i want to drag
		WebElement source = driver.findElement(By.xpath("//div[@id='column-a']"));
		
		//inspecting the element where i want to drop it
		WebElement target = driver.findElement(By.xpath("//div[@id='column-b']"));
		
		Actions ac = new Actions(driver);
		
		//this will perfrom the drag and drop
	    ac.dragAndDrop(source, target).build().perform();

	}

}
