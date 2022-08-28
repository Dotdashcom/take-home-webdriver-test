package com.project.pom.page;

import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FloatingMenu extends Base {

    By content = By.id("content");
    By menu = By.xpath("//div[@class='example']/div[@id='menu']");

    public FloatingMenu(WebDriver driver) {
        super(driver);
    }

    public void scrollDown(){
        if (isDisplayed(content)) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,2000)");
        }else {
            System.out.println("Floating menu page was no found");
        }
    }

    public Boolean mainMenu(){
        return isDisplayed(menu);
    }

}
