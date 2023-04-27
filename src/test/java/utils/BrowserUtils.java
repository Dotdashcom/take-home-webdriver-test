//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;

public class BrowserUtils {
    public BrowserUtils() {
    }

    public static void selectBy(WebElement locationBox, String value, String methodName) {
        Select select = new Select(locationBox);
        switch (methodName) {
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available, Use text, value or index");
        }

    }

    public static String getText(WebElement element) {
        return element.getText().trim();
    }

    public static String getTitleWithJs(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return js.executeScript("return document.title", new Object[0]).toString();
    }

    public static void clickWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", new Object[]{element});
    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)", new Object[]{element});
    }

    public static void switchById(WebDriver driver) {
        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesId = driver.getWindowHandles();
        Iterator var3 = allPagesId.iterator();

        while(var3.hasNext()) {
            String id = (String)var3.next();
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
            }
        }

    }

    public static void switchByTitle(WebDriver driver, String title) {
        Set<String> allPagesId = driver.getWindowHandles();
        Iterator var3 = allPagesId.iterator();

        while(var3.hasNext()) {
            String id = (String)var3.next();
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)) {
                break;
            }
        }

    }

    public static void dragAndDropUsingJavaScript(WebDriver driver, WebElement source, WebElement target) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("function createEvent(typeOfEvent) {\nvar event =document.createEvent(\"CustomEvent\");\nevent.initCustomEvent(typeOfEvent,true, true, null);\nevent.dataTransfer = {\ndata: {},\nsetData: function (key, value) {\nthis.data[key] = value;\n},\ngetData: function (key) {\nreturn this.data[key];\n}\n};\nreturn event;\n}\n\nfunction dispatchEvent(element, event,transferData) {\nif (transferData !== undefined) {\nevent.dataTransfer = transferData;\n}\nif (element.dispatchEvent) {\nelement.dispatchEvent(event);\n} else if (element.fireEvent) {\nelement.fireEvent(\"on\" + event.type, event);\n}\n}\n\nfunction simulateHTML5DragAndDrop(element, destination) {\nvar dragStartEvent =createEvent('dragstart');\ndispatchEvent(element, dragStartEvent);\nvar dropEvent = createEvent('drop');\ndispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\nvar dragEndEvent = createEvent('dragend');\ndispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n}\n\nvar source = arguments[0];\nvar destination = arguments[1];\nsimulateHTML5DragAndDrop(source,destination);", new Object[]{source, target});
    }
}
