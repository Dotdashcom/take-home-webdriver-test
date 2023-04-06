package com.homewebdriver.webpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FloatingMenuPage {
    static WebDriver driver;

    private static String FLOATING_MENU_URL="http://localhost:7080/floating_menu";

    @FindBy(xpath = "//div[@id='menu']/ul/li")
    public List<WebElement> menus;


    public FloatingMenuPage(WebDriver driver){
        this.driver=driver;
        driver.get(FLOATING_MENU_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public List<String> getMenusInPage() {
        List<String> menuText = new ArrayList<>();
        for(WebElement menu : menus) {
            menuText.add(menu.getText());
        }
        return menuText;
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    public void scrollUp(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(document.body.scrollHeight,0)");
    }
}
