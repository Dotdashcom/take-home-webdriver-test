package com.dotdash.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class OpenNewWindowPage extends BasePageObject{
    private By hyperlink = By.linkText("Click Here");

    public OpenNewWindowPage(WebDriver driver){
        this.driver = driver;
        open_page("windows");
    }

    public NewWinDowPage click_on_hyperlink_to_open_new_tab(){
        driver.findElement(hyperlink).click();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver = driver.switchTo().window(tabs2.get(1));
        return new NewWinDowPage(driver);
    }
}
