import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBoxes {

        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();


        @BeforeTest
        public void setUp() throws Exception {
            System.setProperty("webdriver.chrome.driver","BrowserWebDrivers\\chromedriver.exe");

            driver = new ChromeDriver();
            baseUrl = "http://localhost:7080/";
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        }

        @Test
        public void TestChecked() throws Exception {
            driver.get(baseUrl + "checkboxes");
            //Select checkbox elemts
            List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type=checkbox]"));
            // Uncheck 2nd selected checkbox
            checkboxes.get(1).click();
            // Check each check box
            for(int i = 0; i< ((List<?>) checkboxes).size(); i++) {
                Thread.sleep(2000);
                checkboxes.get(i).click();
                System.out.println("selected:::"+checkboxes.get(i).isSelected());
            }
            Boolean expectedValueChecked = true;
            // Assert each check box is checked
            for(int i = 0; i< ((List<?>) checkboxes).size(); i++) {
                Thread.sleep(1000);
                Boolean actualValueChecked = checkboxes.get(i).isSelected();
                Assert.assertTrue(expectedValueChecked.equals(actualValueChecked), "Checkbox " + i + " is checked\n");
                System.out.println("Assert true:::"+checkboxes.get(i).isSelected());
            }
        }

        @Test
        public void UncheckedTest() throws Exception {
            driver.get(baseUrl + "checkboxes");
            //Select checkbox elemts
            List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type=checkbox]"));
            // Check 1st checkbox
            checkboxes.get(0).click();

            // Repeat the process, This time uncheck each checkbox
            for(int i = 0; i< ((List<?>) checkboxes).size(); i++) {
                Thread.sleep(2000);
                checkboxes.get(i).click();
                System.out.println("selected:::"+i+"---"+checkboxes.get(i).isSelected());
            }
            Boolean expectedValueUnchecked = false;
            // Assert each check box is unchecked
            for(int i = 0; i< ((List<?>) checkboxes).size(); i++) {
                Thread.sleep(1000);
                Boolean actualValueUnchecked = checkboxes.get(i).isSelected();
                Assert.assertTrue(expectedValueUnchecked.equals(actualValueUnchecked), "Checkbox " + i + " is not checked\n");
                System.out.println("Assert false:::"+checkboxes.get(i).isSelected());
            }
        }

        @AfterTest
        public void tearDown() throws Exception {
           // driver.close();
            driver.quit();
        }

}