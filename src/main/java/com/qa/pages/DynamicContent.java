package com.qa.pages;

import org.openqa.selenium.By;
public class DynamicContent extends BasePage{
    By listOfText= By.xpath("(//*[@class='example']//div[@id='content'])/div/div[2");
    By clickHereBtn=By.xpath("//a[contains(text(), 'click here')]");


    public boolean clickDynamicContent()
    {
        boolean isSuccessful=false;
        Utility.wait(driver.findElement(listOfText));
        String previousText=driver.findElements(listOfText).toString();
        Utility.wait(driver.findElement(clickHereBtn));
        driver.findElement(clickHereBtn).click();
       String afterClickingText=driver.findElements(listOfText).toString();
       if(previousText.contentEquals(afterClickingText))
       {
           isSuccessful=true;
       }
       return isSuccessful;
    }


}
