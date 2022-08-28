package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Base {

    public WebDriver driver;
    String urlBase = "http://localhost:7080";

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Cristian\\Downloads\\Proyectos\\DotDashTest\\take-home-webdriver-test\\dotDash\\src\\main\\resources\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void clear(By locator){
        driver.findElement(locator).clear();
    }

    public void sendKeys(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public Boolean isSelect(By locator){
        try {
            return driver.findElement(locator).isSelected();
        }catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void visit(String url){
        driver.get(urlBase + url);
        driver.manage().window().maximize();
    }


}
