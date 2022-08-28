package com.project.pom.page;

import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicContent extends Base {

    By content = By.id("content");
    By columns = By.xpath("//*[1][@class=\"row\"]//div[@class=\"large-10 columns\"]");

    public DynamicContent(WebDriver driver) {
        super(driver);
    }

    public String getTextDinamic(){
        if (isDisplayed(content)) {
            String text = getText(columns);
            driver.navigate().refresh();
            return text;
        }else {
            System.out.println("Dynamic pages was no found");
        }
        return "Same error";
    }
}
