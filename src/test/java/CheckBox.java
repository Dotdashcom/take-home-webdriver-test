import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBox {
    WebDriver driver;
    @BeforeMethod
    public void SetUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/checkboxes");
        driver.manage().window().maximize();
    }
       @Test
       public void checkbox1Click() throws InterruptedException {
           //check box1
           WebElement cb1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
           cb1.click();
           Assert.assertTrue(cb1.isSelected());
           Thread.sleep(2000);
       }
       @Test
       public void checkbox1unClick() throws InterruptedException {
        //check box1
           WebElement boxuncheck =driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
           boxuncheck.click();
           //uncheck box1
           WebElement boxuncheck1 =driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
           boxuncheck1.click();
           //Assert
          Assert.assertFalse(boxuncheck.isSelected());
           Thread.sleep(2000);

       }
       @Test
       public void checkbox2unClick() throws InterruptedException {
           //check box2
           WebElement box2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
           box2.click();
           //Assert
           Assert.assertFalse(box2.isSelected());
           Thread.sleep(2000);

       }
       @Test
       public void checkbox2Click() throws InterruptedException {
           //uncheck box2
           WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
           checkbox2.click();
           WebElement checkb2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
           checkb2.click();
           Assert.assertTrue(checkb2.isSelected());
           Thread.sleep(2000);

       }
       @AfterMethod
       public void tearDown(){
        driver.quit();

    }
}
