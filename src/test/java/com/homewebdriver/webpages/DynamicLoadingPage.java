package com.homewebdriver.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofMillis;

public class DynamicLoadingPage {
    static WebDriver driver;

    private static String DYNAMIC_CONTROL_URL="http://localhost:7080/dynamic_loading/2";

    @FindBy(xpath = "//button[contains(text(),'Start')]")
    public WebElement startButton;

    @FindBy(xpath = "//div[@id='loading']")
    public WebElement loadingText;

    @FindBy(xpath = "//div[@id='finish']")
    public WebElement helloWorldText;




    public DynamicLoadingPage(WebDriver driver){
        this.driver=driver;
        driver.get(DYNAMIC_CONTROL_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public void clickStartButton(){
        startButton.click();
    }

    public String getHelloWorldTextAfterLoading(){
        if(loadingText.getText().equals("Loading... ")){
            WebDriverWait wait = new WebDriverWait(driver,ofMillis(10000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='loading'][contains(@style,'display: none;')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) helloWorldText));
        }
        return helloWorldText.getText().trim();
    }

}
