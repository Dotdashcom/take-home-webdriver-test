package com.test.localhost.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class BrowserUtils {

    public static void selectBy(WebElement location,String value,String methodName){
        Select select=new Select(location);
        switch (methodName){
            case"text":
                select.selectByVisibleText(value);
                break;
            case"value":
                select.selectByValue(value);
                break;
            case"index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available,Use text,value,or index");
        }
    }
    public static String getText(WebElement element){
        return element.getText().trim();
    }
    public static String getTitleWithJs(WebDriver driver){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString();
    }
    public static void clickWithJs(WebDriver driver,WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);
    }
    public static void scrollWithJs(WebDriver driver,WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }

    public static void scrollWithPoint(WebDriver driver,WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        Point point = element.getLocation();
        int xCord = point.getX();
        int yCord = point.getY();
        js.executeScript("window.scrollTo(" + xCord + "," + yCord + ")");
    }
    public static void switchById(WebDriver driver,String mainId){
        Set<String> allPageIds=driver.getWindowHandles();
        for (String id:allPageIds){
            if(!id.equals(mainId)){
                driver.switchTo().window(id);
            }
        }


    }
    public static String switchByTitle(WebDriver driver, String title){
        Set<String> allPagesId = driver.getWindowHandles();
        for (String id : allPagesId) {
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)) {
                break;
            }
        }
        return title;
    }
    public static void getScreenShot(WebDriver driver,String packageName){
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location=System.getProperty("user.dir")+"/src/java/screenshot"+packageName;

            try {
                FileUtils.copyFile(file,new File(location+System.currentTimeMillis()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    public static void waitForVisibility(WebDriver driver,WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    }

