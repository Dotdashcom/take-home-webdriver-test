package newTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import TestBase.BaseClass;

public class MouseHover extends BaseClass{
	public static void main(String[] args) throws InterruptedException {
		setUp("hovers");
		
		driver.manage().window().maximize();
		
		Actions action= new Actions(driver);
		
		Thread.sleep(2000);
		
		WebElement target1 = driver.findElement(By.xpath("//img[@alt='User Avatar'] [1]"));
		action.moveToElement(target1).build().perform();
		
		WebElement target2 = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[2]"));
		action.moveToElement(target2).perform();
		
		WebElement target3 = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[3]"));
		action.moveToElement(target3).perform();
		
		driver.quit();


	}

}
