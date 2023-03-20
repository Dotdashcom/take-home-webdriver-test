package com.dotdash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage extends Util {
	protected WebDriver driver;
	
	// selectors
	private By checkboxlink = By.cssSelector("li:nth-of-type(6) > a");
    private By checkbox1 = By.xpath("//*[@id=\"checkboxes\"]/input[1]");
    private By checkbox2 = By.xpath("//*[@id=\"checkboxes\"]/input[2]");
    
    /**
     * initiate driver
     * @param driver
     */
    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void openPage() {
        driver.findElement(checkboxlink).click();
    }
	public WebElement checkbox1() {
        return driver.findElement(checkbox1);
    }

    public WebElement checkbox2() {
    	return driver.findElement(checkbox2);
    }
    
    public void clickCheckbox(String checkbox) {
    	if(checkbox == "first") {
    		checkbox1().click();
    	} else {
    		checkbox2().click();
    	}
    }

}
