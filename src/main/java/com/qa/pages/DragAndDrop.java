package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop extends BasePage{
        By boxA= By.id("column-a");
        By boxB= By.id("column-b");
        By headerA=By.xpath("//*[@id='column-a']/header");



public boolean draggingElement()
{
   Utility.wait(driver.findElement(boxA));
   Utility.wait(driver.findElement(boxB));
   Actions ac =new Actions(driver);
   ac.dragAndDrop(driver.findElement(boxA), driver.findElement(boxB)).build().perform();
   return driver.findElement(headerA).getText().contains("B");
}
        }