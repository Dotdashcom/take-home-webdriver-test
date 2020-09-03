package newTask;

import java.awt.Desktop.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import TestBase.BaseClass;

public class ContextMenu extends BaseClass {


	public static void main(String[] args) {

		setUp("context_menu");
		
		Actions action= new Actions(driver);
		
		WebElement box= driver.findElement(By.id("hot-spot"));
		
		action.contextClick(box).perform();
		
		Alert alert= driver.switchTo().alert();
		
		String text=alert.getText();
		
		if(text.equals("the-internet")) {
			System.out.println("Test case passed");
		}else {
			System.out.println("Test case failed");
		}
		alert.accept();
		
		driver.quit();
	}
}
