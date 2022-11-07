package Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Reporter;

import java.lang.reflect.Method;
import java.util.Collection;

public class Listeners implements WebDriverListener {

    public void beforeAnyNavigationCall(WebDriver.Navigation navigation, Method method, Object[] args) {
        if(args!=null) {
            System.out.println("Navigate to " + args[0].toString());
            Reporter.log("Navigate to " + args[0].toString());
        }
    }
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("Writing ** "+keysToSend+" ** into "+element.getAccessibleName());
        Reporter.log("Writing ** "+keysToSend+" ** into "+element.getAccessibleName());
    }

    public void beforeClick(WebElement element) {

        System.out.println("Clicking "+element.getAccessibleName());
        Reporter.log("Clicking "+element.getAccessibleName());
    }

    public void beforeAnyTimeoutsCall(WebDriver.Timeouts timeouts, Method method, Object[] args) {
        System.out.println("Waiting for element "+ method.getName());
        Reporter.log("Waiting for element "+ method.getName());
    }

    public void beforeIsDisplayed(WebElement element) {
        System.out.println("Validating next element is present "+element.getAccessibleName());
        Reporter.log("Validating next element is present "+element.getAccessibleName());
    }
    public void beforePerform(WebDriver driver, Collection<Sequence> actions) {

        System.out.println("Scroll to element ");
        Reporter.log("Scroll to element ");
    }
}
