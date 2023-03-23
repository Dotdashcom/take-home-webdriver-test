package shakilTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest_5 extends TestBase {
	
	@Test
	public void dragAndDropTest() {
		Actions actions = new Actions(driver);
		driver.get("http://localhost:7080/drag_and_drop");
		
		// Find the source and target elements using their IDs
		WebElement sourceElement = driver.findElement(By.id("column-a"));
		WebElement targetElement = driver.findElement(By.id("column-b"));
		
		// Perform the drag and drop operation using the Actions class
		actions.dragAndDrop(targetElement, sourceElement).build().perform();
		
		// Get the text of the source and target elements after the drag and drop
		String sourceText = sourceElement.getText();
		String targetText = targetElement.getText();
		
		// Verify that the text on the source and target elements has been switched
		Assert.assertEquals(sourceText, "A");
		Assert.assertEquals(targetText, "B");
	}
}
