package com.dotdash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends Util {
	
	protected WebDriver driver;
	
	// selectors
	private By contextMenu = By.xpath("//*[@id=\"content\"]/ul/li[7]/a");
    private By contextBox = By.id("hot-spot");
    
    /**
     * initiate driver
     * @param driver
     */
    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }
    
    public void openContextMenu() {
        driver.findElement(contextMenu).click();
    }
    public WebElement clickContextBox(){
        return driver.findElement(contextBox);
    }
    
    public void rightClickOnContextMenuBox(){
    	openContextMenu();
        Actions rightclick = new Actions(driver);
        rightclick.contextClick(clickContextBox()).perform();
    }
    public String alertMenuText(){
        String alerttext = driver.switchTo().alert().getText();
        return alerttext;
    }
    
}
