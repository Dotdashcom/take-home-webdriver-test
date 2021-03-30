package com.DotDash.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FloatingMenuPage {

    public WebDriver ldriver;

    public FloatingMenuPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//div[@id=\"menu\"]/ul/li")
    List<WebElement> btnfloatingmenu;

    public boolean chkfloatingmenu() {
        boolean temp = false;
        for (WebElement e : btnfloatingmenu) {
            if (e.isDisplayed()) {
                temp = true;
                System.out.println(e.getText());
            } else {
                temp = false;
            }
        }
        if (temp == true) {
            return true;
        }
        return false;
    }

}
