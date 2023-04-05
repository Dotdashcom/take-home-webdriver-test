package com.homewebdriver.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {
    WebDriver driver;
    private static String DRAG_DROP_URL="http://localhost:7080/drag_and_drop";
    public DragAndDropPage(WebDriver driver){
        this.driver=driver;
        driver.get(DRAG_DROP_URL);
        driver.manage().window().maximize();
        //Initialise Elements
        PageFactory.initElements(driver, this);

    }
    public void dragAndDrop(){
        WebElement fromElement = driver.findElement(By.xpath("//div[@id='column-a']"));
        WebElement toElement = driver.findElement(By.xpath("//div[@id='column-b']"));
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(fromElement)
                .moveToElement(toElement)
                .release(toElement)
                .build();
        dragAndDrop.perform();
    }
}
