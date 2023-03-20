package com.dotdash;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.awt.event.InputEvent;


public class DragAndDropPage extends Util {

    protected WebDriver driver;
    
    // selectors
 	private By dragAndDropPage = By.cssSelector("[href='/drag_and_drop']");
 	private By elementA = By.cssSelector("div#column-a");
 	private By elementB = By.cssSelector("div#column-b");

 	
 	 /**
     * initiate driver
     * @param driver
     */
    public DragAndDropPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickDragandDropPage(){
         driver.findElement(dragAndDropPage).click();
    }

    public WebElement getElementA(){
        return driver.findElement(elementA);
    }

    public WebElement getElementB(){
        return driver.findElement(elementB);
    }

   
	@SuppressWarnings("deprecation")
	public void dragAndDrop() throws AWTException, InterruptedException {
    	clickDragandDropPage();

        Robot robot = new Robot();
        robot.setAutoDelay(2000);

        org.openqa.selenium.Dimension fromSize = getElementA().getSize();
        org.openqa.selenium.Dimension toSize = getElementB().getSize();
        Point toLocation = getElementB().getLocation();
        Point fromLocation = getElementA().getLocation();
        System.out.println("Screen Size: " + driver.manage().window().getSize());

        toLocation.x += toSize.width / 2;
        toLocation.y += toSize.height / 2 + toSize.height * 2 / 3;
        fromLocation.x += fromSize.width / 2;
        fromLocation.y += fromSize.height / 2 + fromSize.height * 2 / 3;
        
        
        System.out.println(toLocation.x);
        System.out.println(toLocation.y);
        
        robot.mouseMove(fromLocation.x,fromLocation.y);
        robot.mousePress(InputEvent.BUTTON1_MASK);

        robot.mouseMove(fromLocation.x, fromLocation.y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(toLocation.x, toLocation.y);

        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }

}