package CheckBox;
import Main.Package.CheckBoxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckBoxTest {
    private WebDriver driver;
    private CheckBoxPage checkBoxPage;

    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "/Users/nr903/eclipse-workspace/take-home-webdriver-test/chromedriver");

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

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }
}
