package com.project.pom.page;

import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDownList extends Base {

    By content = By.id("content");
    By option = By.id("dropdown");

    public DropDownList(WebDriver driver) {
        super(driver);
    }

    //if the number is 2 select the option number 1 and if the number is 3 select the option number 2
    public void selectOption(String number){
        if (isDisplayed(content)) {
            click(option);
            By option1or2 = By.xpath("//*[@id=\"dropdown\"]//option[contains(@value, '')]["+ number +"]");
            click(option1or2);
        }else {
            System.out.println("DropDown pages was no found");
        }
    }

    public Boolean validateOption(String number){
        By option1or2 = By.xpath("//*[@id=\"dropdown\"]//option[contains(@value, '')]["+ number +"]");
        return isSelect(option1or2);
    }
}
