package com.assesment.tests.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenNewTabPage {

     WebDriver driver;

     public OpenNewTabPage(WebDriver driver){
         this.driver = driver;
     }
     public enum Using {

         NEW_WINDOW_LINK(By.xpath("//a[@href='/windows/new']"));
         private final By selector;
         Using(By selector) {
             this.selector = selector;
         }
         public By selector(){
             return this.selector;
         }
     }
    /**
     * clicks Click Here link to open a new tab
     */
    public void clickNewTabLink(){
        driver.findElement(Using.NEW_WINDOW_LINK.selector()).click();
    }
}
