import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class PageControlsTest {

    TestUtils testUtils = new TestUtils();
    WebDriver driver;
    Actions actions;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Training\\Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        actions = new Actions(driver);
    }

    @Test
    public void testRemoveCheckBox(){

    }

    @Test
    public void testAddCheckBox(){

    }

    @Test
    public void testEnableTextBox(){

    }

    @Test
    public void testDisableTextBox(){

    }

    @Test
    public void testMouseHover(){
        driver.get(UrlConstants.Mouse_Hover);
        List<WebElement> element = driver.findElements(By.className("figure"));
        actions.moveToElement(element.get(0)).perform();
        //assert here
        actions.moveToElement(element.get(1)).perform();
        //assert here
        actions.moveToElement(element.get(2)).perform();
        //assert here
    }

    @Test
    public void floatingMenu(){
        driver.get(UrlConstants.Floating_Menu);
    }

    @AfterTest
    public void close(){
        //driver.close();
    }
}
