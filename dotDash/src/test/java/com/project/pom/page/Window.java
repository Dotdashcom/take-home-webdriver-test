package com.project.pom.page;

import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Window extends Base {

    By clickHere = By.xpath("//div[@class='example']/a[text()='Click Here']");

    public Window(WebDriver driver) {
        super(driver);
    }

    public String newWindow(){
            click(clickHere);
            ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windows.get(1));
            String text = driver.getTitle();
            return text;
    }
}
