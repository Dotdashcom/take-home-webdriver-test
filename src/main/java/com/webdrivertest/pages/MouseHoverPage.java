package com.webdrivertest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.webdrivertest.utils.ElementUtil;

public class MouseHoverPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public MouseHoverPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	By userAvatars = By.cssSelector(".figure");
    By userProfileNames = By.cssSelector(".figcaption h5");
    By userProfileLinks = By.cssSelector(".figcaption a");
    List<WebElement> userAvatarElements = null;
    List<WebElement> userProfileNameElements = null;
    List<WebElement> userProfileLinkElements = null;

    public static String userName_one = "name: user1";
    public static String userName_two = "name: user2";
    public static String userName_three = "name: user3";
    
    public MouseHoverPage mouseOverUser(int user_num) {
        if (userAvatarElements == null) userAvatarElements = driver.findElements(userAvatars);
        Actions action = new Actions(driver);
        action.moveToElement(userAvatarElements.get(user_num - 1)).perform();
        return this;
    }

    public String verifyGeneralInfoUserr(int user_num) {
        if (userProfileNameElements == null) userProfileNameElements = driver.findElements(userProfileNames);
        if (userProfileLinkElements == null) userProfileLinkElements = driver.findElements(userProfileLinks);
        String actual_user_name_displayed = userProfileNameElements.get(user_num - 1).getText();
		return actual_user_name_displayed;
		
        }

}
