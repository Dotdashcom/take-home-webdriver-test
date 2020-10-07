package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class dropDown extends base {

	@Test
	public void DropDownTest() {
		driver.get(URL+"dropdown ");
		WebElement Dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select option = new Select(Dropdown);
		option.selectByVisibleText("Option 1");
		String Text1 = driver.findElement(By.xpath("//select[@id='dropdown']")).getText();
		assertTrue(Text1.contains("1"));
		option.selectByVisibleText("Option 2");
		String Text2 = driver.findElement(By.xpath("//select[@id='dropdown']")).getText();
		assertTrue(Text2.contains("2"));
	}
}
