package com.company.tests;

import com.company.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC06_Dropdown extends TestBase {



    @Test
    public void simpleDropdownTest(){

        driver.get("https://practice.cydeo.com/dropdown");

//        3. Verify “Simple dropdown” default selected value is correct
//        Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.id("dropdown")));

        // getFirstSelectedOption() method will return to default selected option. Return type is webElement
        String actualDefaultSimpleDropdown = simpleDropdown.getFirstSelectedOption().getText();
        String expectedDefaultSimpleDropdown = "Please select an option";

        Assert.assertEquals(actualDefaultSimpleDropdown,expectedDefaultSimpleDropdown);

        // This line will not run because of hard assertion we used fail
        System.out.println("After hard assertion!");

    }

    @Test
    public void stateDropdownTest(){
        driver.get("https://practice.cydeo.com/dropdown");
        //        4. Verify “State selection” default selected value is correct
//        Expected: “Select a State”

        Select stateDropdown =new Select(driver.findElement(By.xpath("//*[@id='state']")));
                //By.id("state")));
        ////*[@id='state']

        String actualStateDefaultText = stateDropdown.getFirstSelectedOption().getText();
        String expectedStateDefaultText = "Select a State";

        Assert.assertEquals(actualStateDefaultText,expectedStateDefaultText);

    }
    @Test
    public void stateDropdownTest2() throws InterruptedException {
        driver.get("https://practice.cydeo.com/dropdown");
        Select stateDropdown = new Select(driver.findElement(By.id("state")));
        System.out.println("stateDropdown.isMultiple() = " + stateDropdown.isMultiple());

        //        3. Select Illinois with selectByValue()
        Thread.sleep(3000);
        stateDropdown.selectByValue("IL");


//        4. Select Virginia with selectByVisibleText()
        Thread.sleep(3000);
        stateDropdown.selectByVisibleText("Virginia");


//        5. Select California with selectByIndex()
        Thread.sleep(3000);
        stateDropdown.selectByIndex(5);


//        6. Verify final selected option is California.
//        Use all Select options. (visible text, value, index)
        // getFirstSelectedOption() method will return to current selected option
        String actualStateOption = stateDropdown.getFirstSelectedOption().getText();
        String expectedStateOption = "California";

        Assert.assertEquals(actualStateOption,expectedStateOption,"Selected option verification is failed!");

        //Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(), "California","Selected option verification is failed!");

    }

    @Test
    public void multiSelectDropdowntest() throws InterruptedException {
        driver.get("https://practice.cydeo.com/dropdown");
//        3. Select all the options from multiple select dropdown.
        Select languages = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        // isMultiple() will return true, if dropdown has multiselect option
        System.out.println("languages.isMultiple() = " + languages.isMultiple());

        //        4. Print out all selected values.
        // getOptions() method will return to all options in dropdown
        List<WebElement> allOptions = languages.getOptions();

        for(WebElement each: languages.getOptions()){
            each.click();
            Thread.sleep(3000);
            System.out.println("each.getText() = " + each.getText());
        }

//        5. Deselect all values.
        Thread.sleep(3000);
        languages.deselectAll();



    }

    @Test
    public void dateDropdownTest(){
        driver.get("https://practice.cydeo.com/dropdown");
//        3. Select “December 1, 1923” and verify it is selected.
        Select yearDropdown = new Select(driver.findElement(By.id("year")));
        Select monthDropdown = new Select(driver.findElement(By.id("month")));
        Select dayDropdown = new Select(driver.findElement(By.id("day")));

        for (WebElement eachYearOption : yearDropdown.getOptions()) {
            System.out.println(eachYearOption.getText());
        }



//                Select year using   : visible text
        yearDropdown.selectByVisibleText("1923");

//        Select month using    : value attribute Select
        monthDropdown.selectByValue("11");

//        day using : index number
        dayDropdown.selectByIndex(0);

        // Verify(Assertion) each year, month and day selected correctly
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        Assert.assertTrue(actualYear.equals(expectedYear),"Year selection did not pass!");
        Assert.assertTrue(actualMonth.equals(expectedMonth),"Month selection did not pass!");
        Assert.assertTrue(actualDay.equals(expectedDay),"Day selection did not pass!");

//        Assert.assertEquals(actualYear,expectedYear,"Year selection did not pass!");
//        Assert.assertEquals(actualMonth,expectedMonth,"Month selection did not pass!");
//        Assert.assertEquals(actualDay,expectedDay,"Day selection did not pass!");


    }


}
