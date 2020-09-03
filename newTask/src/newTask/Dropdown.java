package newTask;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import TestBase.BaseClass;

public class Dropdown extends BaseClass{
	
	public static void main(String[] args) {
		setUp("dropdown");
		
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		
		dropdown.selectByVisibleText("Option 1");
		dropdown.selectByVisibleText("Option 2");
		
		
	}

}
