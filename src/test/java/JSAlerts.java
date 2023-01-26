import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSAlerts {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/javascript_alerts");
        driver.manage().window().maximize();
    }
    @Test
    public void jsAlert() {
        //Test Clicks on JS Alert Button
        driver.findElement(By.xpath("//button[contains(text(),\"Click for JS Alert\")]")).click();
        Alert a = driver.switchTo().alert();
        a.accept();
        //Test asserts alert message
        String act = driver.findElement(By.id("result")).getText();
        String exp = "You successfuly clicked an alert";
        Assert.assertEquals(act, exp);
        //Test clicks on JS confirm Button and clicks ok on alert
        driver.findElement(By.xpath("//button[contains(text(),\"Click for JS Confirm\")]")).click();
        Alert b = driver.switchTo().alert();
        b.accept();
        //Test asserts the alert message
        String act1 = driver.findElement(By.xpath("//p[contains(text(),\"You clicked: Ok\")]")).getText();
        String exp1 = "You clicked: Ok";
        Assert.assertEquals(act1, exp1);
        //Test clicks on JS Prompt Button and types a message on Prompt
        driver.findElement(By.xpath("//button[contains(text(),\"Click for JS Prompt\")]")).click();
        Alert c = driver.switchTo().alert();
        c.sendKeys("Hello");
        c.accept();
        //Test asserts that the alert message contains the typed message
        String act2 = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
        String exp2 = "You entered: Hello";
        Assert.assertEquals(act2, exp2);
    }
    @AfterMethod
            public void tearDown(){
        driver.quit();



    }
}
