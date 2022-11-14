package CheckBox;
import Main.Package.CheckBoxPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.*;
import org.junit.Test;
import Main.Package.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxTest {
    private WebDriver driver;
    private CheckBoxPage checkBoxPage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/checkboxes");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
    }

        @Test
        public void selecting1Box() {
            driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[1]")).click();
           //CheckBox 2 is clicked on BY DEFAULT
            System.out.println(driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[1]")).isSelected());
            driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[1]")).click();
            System.out.println(driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[1]")).isEnabled());
        }
            @Test
            public void Unchecking2Box() {
                driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]")).click();
                System.out.println(driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]")).isEnabled());
                driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]")).click();
                System.out.println(driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]")).isSelected());
            }

    @After
    public void TearDown() {
        driver.quit();
    }
}
