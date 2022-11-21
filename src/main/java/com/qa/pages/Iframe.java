package com.qa.pages;

import org.openqa.selenium.By;

public class Iframe extends BasePage{
    By iframe= By.xpath("ifarme");
    By typingContent=By.xpath("//body[@id='tinymce']//p");


    public boolean switchToFrameAndTyping(String test)
    {
        driver.switchTo().frame(driver.findElement(iframe));
        driver.findElement(typingContent).clear();
        driver.findElement(typingContent).sendKeys(test);
        return driver.findElement(typingContent).getText().contentEquals(test);
    }
}
