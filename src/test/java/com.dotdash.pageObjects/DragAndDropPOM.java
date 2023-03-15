package com.dotdash.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.testUtils.TestBase;

public class DragAndDropPOM extends TestBase {

//	@FindBy(css="div#columns>div:nth-of-type(1)")
//	WebElement columnA;
//	
//	@FindBy(css="div#columns>div:nth-of-type(2)")
//	WebElement columnB;
//	
	public DragAndDropPOM() {
		PageFactory.initElements(driver,this);
	}
	
	public void drgAndrop() throws InterruptedException, AWTException {
		//Actions act= new Actions(driver);
		WebElement columnA= driver.findElement(By.cssSelector("div#column-a"));
		WebElement columnB= driver.findElement(By.cssSelector("div#column-b"));
		
		/*Point coordinates1 = columnA.getLocation();
		Point coordinates2 = columnB.getLocation();  
		Robot robot = new Robot();           
		robot.mouseMove(coordinates1.getX(), coordinates1.getY());
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseMove(coordinates2.getX(), coordinates2.getY());
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(2000);

*/
		
		Robot robot = new Robot(); 
        robot.setAutoDelay(3000);

        org.openqa.selenium.Dimension sizeA = columnA.getSize();
        org.openqa.selenium.Dimension sizeB = columnB.getSize();

        Point LocationA = columnA.getLocation();
        Point LocationB = columnB.getLocation();


        LocationB.x += sizeB.width / 2;
        LocationB.y += sizeB.height / 2 + sizeB.height * 2 / 3;
        LocationA.x += sizeA.width / 2;
        LocationA.y += sizeA.height / 2 + sizeA.height * 2 / 3;
        robot.mouseMove(LocationA.x, LocationA.y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(LocationB.x, LocationB.y);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
	}
	
}
