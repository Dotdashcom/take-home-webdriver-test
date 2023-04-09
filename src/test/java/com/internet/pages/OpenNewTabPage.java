package com.internet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class OpenNewTabPage extends BasePage{

    @FindBy(linkText = "Click Here")
    private WebElement clickHere;


    public void setClickHere(){
        waitforVisibilityandClickable(clickHere);
        clickHere.click();
    }

    public String returnTitle(){
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        return driver.getTitle();
    }


}
