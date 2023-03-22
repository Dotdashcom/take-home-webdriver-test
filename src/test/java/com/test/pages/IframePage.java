package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.util.Config;

public class IframePage {

    private WebDriver driver;
    //private By iframe = By.tagName("iframe");
    private By textInput = By.id("tinymce");

    public IframePage(WebDriver driver) {
        this.driver = driver;
        driver.get(Config.getUrl("iframe"));
    }

    public void typeText(String text) {
        WebElement textAreaElement = driver.findElement(textInput);
        
        // Wait for the text area element to be visible and clickable before clearing it
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(textAreaElement, "Your content goes here."));
        
        textAreaElement.clear(); 
        
        // Wait for the text area element to be visible and clickable before sending keys to it
        wait.until(ExpectedConditions.elementToBeClickable(textAreaElement));
        driver.findElement(textInput).sendKeys(text);
    }

    public String getTypedText() {
        driver.switchTo().frame("mce_0_ifr");
        WebDriverWait wait = new WebDriverWait(driver, 10); // wait for 10 seconds
        WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tinymce")));
        String typedText = textElement.getText();
        System.out.println(typedText);
        driver.switchTo().defaultContent();
        return typedText;
    }

}
