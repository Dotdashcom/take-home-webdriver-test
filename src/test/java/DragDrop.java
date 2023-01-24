import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragDrop {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/drag_and_drop");
        driver.manage().window().maximize();

        WebElement drag = driver.findElement(By.id("column-a"));
        WebElement drop = driver.findElement(By.xpath("//div[@class=\"column\" and @id = \"column-b\"]"));
        Actions act = new Actions(driver);
        act.clickAndHold(drag).moveToElement(drop).release().build().perform();

//        Action dragAndDrop = act.clickAndHold(fromA).moveToElement(toB).release(toB).build();
//        dragAndDrop.perform();
        Assert.assertEquals(drop.getText(), "A", "FAIL: File couldn't be dropped to target as expected");
        Assert.assertEquals(drag.getText(), "B", "FAIL: File couldn't be dropped to target as expected");

        Thread.sleep(2000);



    }
}
