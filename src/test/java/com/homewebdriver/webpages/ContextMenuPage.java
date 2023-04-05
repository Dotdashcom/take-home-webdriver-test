package com.homewebdriver.webpages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofMillis;

public class ContextMenuPage {

    WebDriver driver;
    private static String CHECKBOX_URL="http://localhost:7080/context_menu";

    // Locator for Context Box
    By ContextBox= By.xpath("//div[@id='hot-spot']");

//    // Locator for Alert
//    By alert= By.xpath("//div[@id='hot-spot']");
    public ContextMenuPage(WebDriver driver){

        this.driver=driver;
        driver.get(CHECKBOX_URL);
        driver.manage().window().maximize();
        //Initialise Elements
        PageFactory.initElements(driver, this);

    }
    public void rightClickBox(){
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(ContextBox);
        actions.contextClick(elementLocator).perform();
    }

    public String verifyAlert(){
        WebDriverWait wait = new WebDriverWait(driver,ofMillis(1000));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        System.out.println(text);
        alert.accept();
        return text;
    }
}
