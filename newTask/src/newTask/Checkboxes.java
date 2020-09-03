package newTask;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import TestBase.BaseClass;

public class Checkboxes extends BaseClass{

	public static void main(String[] args){

		setUp("checkboxes");
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
		for (WebElement checkbox : checkboxes) {
			checkbox.click();
			
		}
		driver.quit();
		
	}
}
