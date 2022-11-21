package com.qa.pages;

import org.openqa.selenium.By;

public class NewTab extends BasePage{

    By clickHere= By.xpath("//*[@class='example']//a");
    By newWindow=By.xpath("//h3");

    public boolean isNewWindow()
    {
        Utility.wait(driver.findElement(clickHere));
        String parent=driver.getWindowHandle();
        driver.findElement(clickHere).click();
        for(String a : driver.getWindowHandles())
        {
            if(!a.contains(parent)){
                driver.switchTo().window(a);
            }
        }
        Utility.wait(driver.findElement(newWindow));
        return driver.findElement(newWindow).isDisplayed();
    }

}
