package com.project.pom.page;

import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxes extends Base {

    By content = By.id("content");
    By checkBoxOne = By.xpath("//*[@class='example']//input[@type=\"checkbox\"][1]");
    By checkBoxTwo = By.xpath("//*[@class='example']//input[@type=\"checkbox\"][2]");

    public CheckBoxes(WebDriver driver) {
        super(driver);
    }

    public void clickOnCheckBoxes(){
        if (isDisplayed(content)) {
            click(checkBoxOne);
            click(checkBoxTwo);
        }else{
            System.out.println("Check boxes page was no found");
        }
    }

    public Boolean checkBoxOne(){
        return isSelect(checkBoxOne);
    }

    public Boolean checkBoxTwo(){
        return isSelect(checkBoxTwo);
    }
}
