package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonMethods;
@Test
public class DropdownTest extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        setUp("http://localhost:7080/dropdown");

        WebElement dd = driver.findElement(By.id("dropdown"));
        dd.click();

        Select select = new Select(dd);


        select.selectByValue("1");

        //Checking if dropdown is selected by its text
        String actualTextOfFirstOption = select.getFirstSelectedOption().getText();
        String expectedTextOfFirstOption = "Option 1";
        Assert.assertEquals(actualTextOfFirstOption,expectedTextOfFirstOption);
        System.out.println("Option 1 is selected");

        Thread.sleep(2000);

        select.selectByVisibleText("Option 2");
        String actualTextOfSecondOption = select.getFirstSelectedOption().getText();
        String expectedTextOfSecondOption = "Option 2";
        Assert.assertEquals(actualTextOfSecondOption, expectedTextOfSecondOption);
        System.out.println("Option 2 is selected");

        tearDown();
    }
}
