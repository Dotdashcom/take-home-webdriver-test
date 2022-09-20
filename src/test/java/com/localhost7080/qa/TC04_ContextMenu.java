package com.localhost7080.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TC04_ContextMenu {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/context_menu");
		
		//Do a right click on ContextMenu
		Actions actions = new Actions(driver);
		WebElement contextMenu = driver.findElement(By.id("hot-spot"));
		actions.contextClick(contextMenu).perform();
		
		//Get the text of the alert, close it and do and Assertion.
		Assert.assertEquals(driver.switchTo().alert().getText(),"You selected a context menu");
		driver.switchTo().alert().accept();
		driver.close();
		
	}

}
