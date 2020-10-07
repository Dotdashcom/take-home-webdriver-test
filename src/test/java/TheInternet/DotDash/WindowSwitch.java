package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class WindowSwitch extends base {
	
	@Test
	public void WindowSwitchTest() {
		driver.get(URL + "windows ");
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		ArrayList<String> tabIndexes = new ArrayList<String>(driver.getWindowHandles());
		int Size = tabIndexes.size();
		driver.switchTo().window(tabIndexes.get(Size - 1));
		String Message = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
		assertTrue(Message.contains("New Window"));
		driver.quit();

	}

}
