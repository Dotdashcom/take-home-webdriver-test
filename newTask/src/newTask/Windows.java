package newTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TestBase.BaseClass;

public class Windows extends BaseClass{

	public static void main(String[] args) {
		
		setUp("windows");
		
		WebElement ClickHere= driver.findElement(By.xpath("//a[text()='Click Here']"));
		
		ClickHere.click();
		
		String handle=driver.getWindowHandle();
		
		driver.switchTo().window(handle);
		
		System.out.println(handle);
		driver.quit();
		
	}
}
