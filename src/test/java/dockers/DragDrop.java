package dockers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragDrop {
    
	@Test
    public void DragDrop() {
		
		String url = "http://localhost:7080/drag_and_drop";
		LoginWebDriver loginWebDriver = new LoginWebDriver();
		WebDriver driver = loginWebDriver.Login(url);
		
		//driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		WebElement fromColumnA = driver.findElement(By.xpath("//div[@id='column-a']"));
		//int width = fromColumnA.getSize().getWidth();
		//System.out.println(width);
		WebElement toColumnB = driver.findElement(By.xpath("//div[@id='column-b']"));
		actions.dragAndDrop(fromColumnA, toColumnB).build().perform();
		//actions.dragAndDropBy(fromColumnA, 200, 0).build().perform();
		
		//actions.clickAndHold(fromColumnA).moveByOffset(200, 0).moveToElement(toColumnB).release(toColumnB).build();
		//actions.perform();
		
		//actions.clickAndHold(fromColumnA).moveToElement(toColumnB).release().perform();
		
		driver.close();

	}
}
