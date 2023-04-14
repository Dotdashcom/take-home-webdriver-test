package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Utility {

    //static WebDriver driver;

    public static boolean visibilityOfElementWait(WebDriver driver, By webElement) {
        if (webElement != null) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
                return true;
            } catch (Exception e) {
                return false;
            }
        } else
            System.out.println("webElement not exist");
        return false;
    }

    public static boolean clickableOfElementWait(WebDriver driver, By webElement) {
        if (webElement != null) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 20);
                wait.until(ExpectedConditions.elementToBeClickable(webElement));
                return true;
            } catch (Exception e) {
                return false;
            }
        } else
            System.out.println("webElement not exist");
        return false;
    }

    public static void esperar(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean fileExist(){
        File file = new File(System.getProperty("user.dir").concat("/src/test/resources/some-file.txt"));
        if(file.exists()){
            return true;
        }else {
            return false;
        }
    }
    public static void deleteFile(){
        File file = new File(System.getProperty("user.dir").concat("/src/test/resources/some-file.txt"));
        if(file.exists()){
            file.delete();
        }
    }

}
