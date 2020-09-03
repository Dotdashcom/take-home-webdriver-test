package newTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import TestBase.BaseClass;

public class DragAndDrop extends BaseClass {
	
	public static void main(String[] args){
	
	setUp("drag_and_drop");
	
	Actions action= new Actions(driver);
	
	WebElement A= driver.findElement(By.id("column-a"));
	
	WebElement B= driver.findElement(By.id("column-b"));
	
	action.dragAndDrop(A, B).perform();
	action.click(B);
	
	driver.quit();
	
	
	
	

	}
}
