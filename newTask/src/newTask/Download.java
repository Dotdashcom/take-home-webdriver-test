package newTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TestBase.BaseClass;

public class Download extends BaseClass{
	public static void main(String[] args) {
		
		setUp("download");
		
		WebElement download= driver.findElement(By.xpath("//a[text()='some-file.txt']"));
		download.click();
		
		driver.quit();
	}

}
