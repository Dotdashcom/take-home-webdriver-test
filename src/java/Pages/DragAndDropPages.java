package java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPages {
	
	WebDriver driver;
	
	public DragAndDropPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='column-a']")
	WebElement dragField;
	
	@FindBy(xpath = "//div[@id='column-b']")
	WebElement dropField;
	
	
	
	public void dragAndDropFunctionality() throws InterruptedException
	{
		
		Actions act=new Actions(driver);
		
		Action dragAndDrop = act.clickAndHold(dragField)
				.moveToElement(dropField)
				.release(dropField)
				.build();
		
		dragAndDrop.perform();
		Thread.sleep(5000);
//		act.dragAndDrop(dragField, dropField).build().perform();
		
				
	}
	
	

}
