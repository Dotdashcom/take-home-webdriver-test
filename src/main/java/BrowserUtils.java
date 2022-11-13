import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {

    public static void selectBy(WebElement element, String value, String methodName){

        Select select = new Select(element);
        switch (methodName){
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
                System.out.println("Method name is not available. Use text,value or index for method name");
        }

    }

    public static String getText(WebElement element){
        return element.getText().trim();
    }


    public static String getTitleWithJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return  js.executeScript("return document.title").toString();

    }


    public static void clickWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);
    }


    public static void scrollWithJS(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }
    public static void switchByID(WebDriver driver, String mainId){

        Set<String> allPageId = driver.getWindowHandles();
        for (String id : allPageId){
            if(!id.equals(mainId)){
                driver.switchTo().window(id);
            }
        }

    }


    public static void switchByTitle(WebDriver driver, String title){
        Set<String> allIds = driver.getWindowHandles(); //4
        for (String id: allIds){
            driver.switchTo().window(id);
            if(driver.getTitle().contains(title)){
                break;
            }
        }
    }

    public static void getScreenShot(WebDriver driver, String packageName){
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location=System.getProperty("user.dir")+"/src/java/screenshot"+packageName;
        try {
            FileUtils.copyFile(file,new File(location+ System.currentTimeMillis()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.currentTimeMillis will make the data unique all the time
    }



}
