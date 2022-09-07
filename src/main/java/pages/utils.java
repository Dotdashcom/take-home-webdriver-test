package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestBase;

import java.time.Duration;

public class utils extends TestBase {

    public static String browser = "chrome";
    public static String url = "http://localhost:7080";

    public utils() {
        PageFactory.initElements(TestBase.getInstance().getDriver(), this);
    }


    public static void visibleElementWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(TestBase.getInstance().getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void invisibleElementWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(TestBase.getInstance().getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void enableElementWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(TestBase.getInstance().getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}



