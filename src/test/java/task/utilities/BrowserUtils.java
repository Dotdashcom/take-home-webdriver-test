package task.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class BrowserUtils {



    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static WebElement waitForVisibility(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void switchWindow(String expectedText){

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {

            Driver.getDriver().switchTo().window(each);

            if (each.equals(expectedText)){
                break;
            }
        }
    }


    public static void switchWindow(int index){

        ArrayList<String> allWindowHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());

        Driver.getDriver().switchTo().window(allWindowHandles.get(index));
        }




    }

