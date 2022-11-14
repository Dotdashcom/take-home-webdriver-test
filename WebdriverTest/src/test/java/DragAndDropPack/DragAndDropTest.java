package DragAndDropPack;
import Main.Package.DragAndDropPage;
import dev.failsafe.internal.util.Durations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DragAndDropTest {
    private WebDriver driver;
    private DragAndDropPage dragAndDropPage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/drag_and_drop");
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);

    }

    @Test
    public void DragAndDropFirst() {

        WebElement dragBox1 = driver.findElement(By.xpath("//header"));
        WebElement dragBox2 = driver.findElement(By.xpath("//div[@id='column-b']"));
        //HTML 5
        final String java_script =
                "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                        "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                        "ction(format,data){this.items[format]=data;this.types.append(for" +
                        "mat);},getData:function(format){return this.items[format];},clea" +
                        "rData:function(format){}};var emit=function(event,target){var ev" +
                        "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                        "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                        "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                        "'drop',tgt);emit('dragend',src);";
        ((JavascriptExecutor) driver).executeScript(java_script, dragBox1, dragBox2);
        Actions actions = new Actions(driver);
        Action dragAndDrop = actions.clickAndHold(dragBox1).moveToElement(dragBox2).release().build();
        actions.perform();

    }

    @Test
    public void AssertSwitch() {

        WebElement dragBox1 = driver.findElement(By.xpath("//header"));
        WebElement dragBox2 = driver.findElement(By.xpath("//div[@id='column-b']"));
        //HTML 5
        final String java_script =
                "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                        "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                        "ction(format,data){this.items[format]=data;this.types.append(for" +
                        "mat);},getData:function(format){return this.items[format];},clea" +
                        "rData:function(format){}};var emit=function(event,target){var ev" +
                        "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                        "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                        "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                        "'drop',tgt);emit('dragend',src);";
        ((JavascriptExecutor) driver).executeScript(java_script, dragBox1, dragBox2);
        Actions actions = new Actions(driver);
        Action dragAndDrop = actions.clickAndHold(dragBox1).moveToElement(dragBox2).release().build();
        actions.perform();
        String boxText1 = dragBox2.getText();

        if (boxText1.equals("A")) {
            System.out.println("PASS: File is dropped as expected");
        } else {
            System.out.println("Fail, sorry!");
        }

    }

    @After
    public void TearDown() {
        driver.quit();
    }
}





