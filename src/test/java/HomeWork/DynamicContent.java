package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class DynamicContent extends Base{
    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/dynamic_content";
    private static List<WebElement> oldText;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(baseUrl);
        oldText = driver.findElements(By.xpath("//div[@class='large-10 columns']"));
    }

    @Test
    public void dynamicContent(){

        String textbefore = oldText.get(0).getText();

        for(int i=0; i<3; i++){
            driver.navigate().refresh();
        }

        List<WebElement> newtext = driver.findElements(By.xpath("//div[@class='large-10 columns']"));

        String textAfter = newtext.get(0).getText();

        Assert.assertNotEquals(textbefore,textAfter);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }









}
