package DropDownPack;
import Main.Package.DropDownPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DropDownPageTest {
    private WebDriver driver;
    private DropDownPage dropDownPage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/dropdown");
        DropDownPage dropDownPage = new DropDownPage(driver);
    }

    @Test

    public void SelectingOpt1AndOpt2() {
//Test selects Option 1 and Option 2 from the dropdown menu.
        driver.findElement(By.xpath("//select[@id='dropdown']")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Option 1')]")).click();

        //Test asserts Option 1 and Option 2 are selected.
        String option1 = "Option 1";
        String option2 = "Option 2";
        String dropDownBox = driver.findElement(By.xpath("//option[contains(text(),'Option 1')]")).getText();
        if (dropDownBox.equals("Option 1")) {
            System.out.println("Option 1 is selected!");
        } else {
            System.out.println("Failed, Sorry!");

        }
        driver.findElement(By.xpath("//select[@id='dropdown']")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Option 2')]")).click();
        String dropDownBox1 = driver.findElement(By.xpath("//option[contains(text(),'Option 2')]")).getText();
        if (dropDownBox1.equals("Option 2")) {
            System.out.println("Option 2 is selected!");
        } else {
            System.out.println("Failed, Sorry!");
        }

    }

    @After
    public void TearDown() {
        driver.quit();
    }
}



