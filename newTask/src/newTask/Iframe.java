package newTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TestBase.BaseClass;

public class Iframe extends BaseClass{

	public static void main(String[] args) {

		setUp("iframe");
		
		driver.switchTo().frame("mce_0_ifr");
		WebElement txt=driver.findElement(By.xpath("//body[@id='tinymce']"));
		txt.clear();
		txt.sendKeys("New York");
		
		driver.quit();
		
	}
}