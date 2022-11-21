package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Hovers extends BasePage {

    By employee1= By.xpath("(//*[@class='example']//div[@class='figure'])[1]");
    By name1= By.xpath("(//*[@class='figcaption'])[1]/h5");
    By employee2= By.xpath("(//*[@class='example']//div[@class='figure'])[2]");
    By name2= By.xpath("(//*[@class='figcaption'])[2]/h5");
    By employee3= By.xpath("(//*[@class='example']//div[@class='figure'])[3]");
    By name3= By.xpath("(//*[@class='figcaption'])[3]/h5");

    public boolean hoverElement()
    {
        boolean hoverSuccessful = false;
        Actions ac=new Actions(driver);
        Utility.wait(driver.findElement(employee1));
        ac.moveToElement(driver.findElement(employee1)).build().perform();
        boolean isUserOneDisplayed=driver.findElement(name1).isDisplayed();

        Utility.wait(driver.findElement(employee2));
        ac.moveToElement(driver.findElement(employee2)).build().perform();
        boolean isUserSecondDisplayed=driver.findElement(name2).isDisplayed();

        Utility.wait(driver.findElement(employee3));
        ac.moveToElement(driver.findElement(employee3)).build().perform();
        boolean isUserThirdDisplayed=driver.findElement(name3).isDisplayed();
        if(isUserOneDisplayed && isUserSecondDisplayed && isUserThirdDisplayed){
            hoverSuccessful=true;
        }
        return hoverSuccessful;
    }




}
