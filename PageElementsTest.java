import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.*;

public class PageElementsTest {
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
    public void check_checkBoxTest(){
        driver.get(UrlConstants.CheckBoxes);
        List<WebElement> elementList = driver.findElements(By.tagName("input"));
        elementList.get(0).click();
        assertEquals("true", elementList.get(0).getAttribute("checked"));
    }

    @Test
    public void uncheck_checkBoxTest(){
        driver.get(UrlConstants.CheckBoxes);
        List<WebElement> elementList = driver.findElements(By.tagName("input"));
        elementList.get(1).click();
        assertEquals(null, elementList.get(1).getAttribute("checked"));


    }

    @Test
    public void dropDown_OptionOne_Test(){
        driver.get(UrlConstants.Dropdown);
        testUtils.dropDownSelection(driver, UrlConstants.Drop_Down_Id, UrlConstants.Drop_Down_Value_1, actions);
        List<WebElement> ele = driver.findElement(By.id("dropdown")).findElements(By.tagName("option"));
        assertEquals(ele.get(1).getAttribute("selected"), "true");

    }

    @Test
    public void dropDown_OptionTwo_Test(){
        driver.get(UrlConstants.Dropdown);
        testUtils.dropDownSelection(driver, UrlConstants.Drop_Down_Id, UrlConstants.Drop_Down_Value_2, actions);
        List<WebElement> ele = driver.findElement(By.id("dropdown")).findElements(By.tagName("option"));
        assertEquals(ele.get(2).getAttribute("selected"), "true");
    }

    @Test
    public void dragAndDropTest(){
        driver.get(UrlConstants.Drag_and_Drop);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        testUtils.dragAndDrop(driver,UrlConstants.Drag_And_Drop_Id_A, UrlConstants.Drag_And_Drop_Id_B, actions);
        assertEquals("B", driver.findElement(By.xpath("//*[@id=\"column-b\"]/header")).getText());
        assertEquals("A", driver.findElement(By.xpath("//*[@id=\"column-a\"]/header")).getText());
    }

    @Test
    public void dynamicContentTest(){
        driver.get(UrlConstants.Dynamic_Content);
        String content = driver.getPageSource();
        testUtils.refresh(driver);
        assertNotSame(content,driver.getPageSource());
    }

    @Test
    public void contextMenuTest(){
        driver.get(UrlConstants.ContextMenu);
        testUtils.rightClick(driver, UrlConstants.Context_Menu_Id, actions);
        Alert alert = driver.switchTo().alert();
        assertNotNull(ExpectedConditions.alertIsPresent());
        alert.accept();
    }



    @AfterTest
    public void close(){
        driver.close();
    }
}
