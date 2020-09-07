package dockers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBox {
	
	@Test
	public void CheckBoxesSelected() {

		String url = "http://localhost:7080/checkboxes";
		LoginWebDriver loginWebDriver = new LoginWebDriver();
		WebDriver driver = loginWebDriver.Login(url);
		
		// use parent relationship
		WebElement checkBox1 = driver.findElement(By.xpath("//div[@id='content']/div/form/input[1]"));
		WebElement checkBox2 = driver.findElement(By.xpath("//div[@id='content']/div/form/input[2]"));

		// check checkBox1
		checkBox1.click();
		Assert.assertTrue(checkBox1.isSelected());

		// uncheck checkBox1
		checkBox1.click();
		Assert.assertFalse(checkBox1.isSelected());
		driver.close();
	}

}
