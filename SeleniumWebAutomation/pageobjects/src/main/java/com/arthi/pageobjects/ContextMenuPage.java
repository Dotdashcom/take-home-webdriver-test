package com.arthi.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.arthi.automation.common.PageBase;

/**
 * 
 * @author Arthina
 *
 */
public class ContextMenuPage extends PageBase {
	
	private static final String Base_URL = " http://localhost:7080/context_menu";

   
	@FindBy (id="hot-spot")
	private WebElement element;
	

	public ContextMenuPage(WebDriver driver) {
		super(driver);
		
	}
	
	public ContextMenuPage navigateToCheckBoxPage() {
		driver.get(Base_URL);
		return this;		
	}
	
	public ContextMenuPage verifyContextMenuEvent() throws InterruptedException{
		Actions actions =  new Actions(driver);
		actions.contextClick(element).build().perform();

		Alert alert= driver.switchTo().alert();
		String alertMessage= driver.switchTo().alert().getText();

		System.out.println(alertMessage);
		Thread.sleep(2000);
		alert.accept();
		
		return this;


		
	}
	
	

}
