package DynamicContentPack;
import Main.Package.DynamicContentPage;
import dev.failsafe.internal.util.Durations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class StaticButtonTest {
    private WebDriver driver;
    private DynamicContentPage dynamicContentPage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/dynamic_content");
        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);

    }
//First Click on the staticButton always calls change of all content But second works properly changing the 3rd Box
    @Test

    public void refreshPageChangeText() {
        driver.findElement(By.xpath("//a[contains(text(),'click here')]")).click();
        WebElement TextField1 = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]"));
        WebElement TextField2 = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]"));
        WebElement TextField3 = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]"));
        WebElement ClickStatic = driver.findElement(By.xpath("//a[contains(text(),'click here')]"));


        //locators by exact content

        System.out.println(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]")).getText());
        System.out.println(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]")).getText());
        System.out.println(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]")).getText());

        String Text1 = TextField1.getText();
        String Text2 = TextField2.getText();
        String Text3 = TextField3.getText();
        driver.findElement(By.xpath("//a[contains(text(),'click here')]")).click();


        System.out.println(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]")).getText());
        System.out.println(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]")).getText());
        System.out.println(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]")).getText());
        String RefreshedText1 = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]")).getText();
        String RefreshedText2 = driver.findElement((By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]"))).getText();
        String RefreshedText3 = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]")).getText();
        if (Text1.equals(RefreshedText1)) {
            System.out.println("Text is static");
        } else {
            System.out.println("Text1 has been changed");
        }
        if (Text2.equals(RefreshedText2)) {
            System.out.println("Text is static");
        } else {
            System.out.println("Text2 has been changed");
        }
        if (Text3.equals(RefreshedText3)) {
            System.out.println("Text is static");
        } else {
            System.out.println("Text3 has been changed");
        }

    }

    @After
    public void TearDown() {
        driver.quit();
    }
}
