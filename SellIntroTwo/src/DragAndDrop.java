import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {

	
	@Test
	public static void DragAndDropTest() {
	
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:7080/drag_and_drop");
		
		Actions a=new Actions(driver);
		WebElement source=driver.findElement(By.cssSelector("#column-a"));

		WebElement target=driver.findElement(By.cssSelector("#column-b"));
		a.dragAndDrop(source, target).build().perform();

	}

}
