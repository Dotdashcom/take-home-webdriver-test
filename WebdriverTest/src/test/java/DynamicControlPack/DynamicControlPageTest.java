package DynamicControlPack;
import Main.Package.DynamicControlPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.StaleElementReferenceException;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DynamicControlPageTest {
    static WebDriver driver;
    private DynamicControlPage dynamicControlPage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/dynamic_controls");
        DynamicControlPage dynamicControlPage = new DynamicControlPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test

    public void ButtonCheckBoxTest() {
        WebElement DeleteButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
        WebElement CheckBox = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]"));
        WebElement EnableButton = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
        WebElement CheckBoxField = driver.findElement(By.xpath("//div[@id='checkbox']"));
        String BeforeTitleCheckBoxTitle = CheckBoxField.getText();

        driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")));


        try {
            if (driver.findElement(By.xpath("//div[@id='checkbox']")).isDisplayed()) {
                System.out.println("Checkbox is Displayed");
                {

                }

            }

        } catch (Exception e) {
            System.out.println("Checkbox is Deleted");
        }

    }

    @Test

    public void CheckAddButton() {

        driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")));


        WebElement AddButton = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
        driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='checkbox']")));


        try {
            if (driver.findElement(By.xpath("//div[@id='checkbox']")).isDisplayed()) {
                System.out.println("Checkbox is Displayed");
                {

                }

            }

        } catch (Exception e) {
            System.out.println("Checkbox is Added. Add Button successfully works!!!");
        }

    }

    @Test
    public void EnableButtonTest() {
        WebElement EnableButton = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));


        driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBe(By.xpath("//p[@id='message']"), "It's enabled!"));

        System.out.println(driver.findElement(By.xpath("//p[@id='message']")).getText());
        String EnableMessage = driver.findElement(By.xpath("//p[@id='message']")).getText();

        if (EnableMessage.equals("It's enabled!")) {
            System.out.println("Function is Enabled");
            {

            }

        } else {

            System.out.println("It's still Disabled");
        }

    }
    @Test
    public void DisAbleButtonTest() {
        WebElement EnableButton = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));


        driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBe(By.xpath("//p[@id='message']"), "It's enabled!"));

        driver.findElement(By.xpath("//button[contains(text(),'Disable')]")).click();
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBe(By.xpath("//p[@id='message']"), "It's disabled!"));

        System.out.println(driver.findElement(By.xpath("//p[@id='message']")).getText());
        String DisableMessage = driver.findElement(By.xpath("//p[@id='message']")).getText();

        if (DisableMessage.equals("It's disabled!")) {
            System.out.println("Function is Disabled");
            {

            }

        } else {

            System.out.println("It's still Enabled");
        }

    }

    @After
    public void TearDown() {
        driver.quit();
    }
}

