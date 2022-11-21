package com.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu extends BasePage{

By contextMenuBox= By.id("hot-spot");


public boolean clickContectMenuAndSwitchToAlert()
{
    Utility.wait(driver.findElement(contextMenuBox));
    Actions ac =new Actions(driver);
    ac.contextClick(driver.findElement(contextMenuBox)).build().perform();
    Alert alert=driver.switchTo().alert();
    String alertText=alert.getText();
    System.out.println(alertText);
    return alertText.contains("You selected");

}

}
