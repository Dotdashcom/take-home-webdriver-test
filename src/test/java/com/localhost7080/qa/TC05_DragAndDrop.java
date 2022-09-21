package com.localhost7080.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TC05_DragAndDrop {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/drag_and_drop");
		
		WebElement a = driver.findElement(By.xpath("//header[contains(text(),'A')]"));
		WebElement b = driver.findElement(By.xpath("//header[contains(text(),'B')]"));
		
		//Not work :(
		Actions act = new Actions(driver);
		act.dragAndDrop(a, b).build().perform();
//		Action dragAndDrop = act.clickAndHold(a).moveToElement(b).release(b).build();
//		dragAndDrop.perform();
		
	}

}
