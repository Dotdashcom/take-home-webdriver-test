package com.qa.pages;

import org.openqa.selenium.By;

public class DynamicLoading extends BasePage{

    By startBtn= By.xpath("//div[@id='start']//button");
    By loadingImage=By.xpath("//div[@id='loading']//img");
    By text=By.xpath("//div[@id='finish']//h4");


    public boolean loadedPageDynamically()
    {
        Utility.wait(driver.findElement(startBtn));
        driver.findElement(startBtn).click();
        Utility.wait(driver.findElement(loadingImage));
        Utility.waitUntilDisappear(driver.findElement(loadingImage));
        return driver.findElement(text).getText().contains("Hello World!");
    }




}
