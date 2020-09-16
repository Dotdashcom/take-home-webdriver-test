package com.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;

public class DynamicControlsPage  {

	public WebDriver driver;

	public DynamicControlsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // paageObjectModel using selenium pagefactor
	}

	public void dynamic(){

		WebElement element;
		element = driver.findElement(By.xpath("//div[@id='checkbox']//input"));
		element.click();


		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Remove')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();


		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enable')]")));


		driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();
	}

}


