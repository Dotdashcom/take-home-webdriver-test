package com.qa.pages;

import org.openqa.selenium.By;

public class CheckBoxPage extends BasePage{

    By checkBox1= By.xpath("(//*[@type='checkbox'])[1]");
    By checkBox2= By.xpath("(//*[@type='checkbox'])[2]");

    public void clickCheckBoxes()
    {
        Utility.wait(driver.findElement(checkBox1));
        driver.findElement(checkBox1).click();

        Utility.wait(driver.findElement(checkBox2));
        driver.findElement(checkBox2).click();
    }

    public boolean checkBoxSelected()
    {

        return driver.findElement(checkBox1).toString().contains("checked");
    }





}
