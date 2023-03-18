package dot.dash.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor {

 private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    public static void invisibilityOf(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
       public static void visibilityOf(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
       public static void clickableOf(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
