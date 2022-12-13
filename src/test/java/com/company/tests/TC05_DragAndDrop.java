package com.company.tests;

import com.company.base.TestBase;
import com.company.utilities.ConfigurationReader;
import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC05_DragAndDrop extends TestBase {


    @Test
    public void guru99_dragAndDrop_test(){

        //    1- Open a chrome browser
//    2- Go to: https://demo.guru99.com/test/drag_drop.html
        Driver.getDriver().get(ConfigurationReader.getProperty("guru99.dropdown.url"));

//    3- Drag “BANK” and drop into Account area under Debit Side
        WebElement bank = Driver.getDriver().findElement(By.partialLinkText("BANK"));
        WebElement debitAccount = Driver.getDriver().findElement(By.id("bank"));

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(bank,debitAccount).perform();

//    4- Drag “5000” and drop into Amount area under Debit Side
        WebElement fiveK = Driver.getDriver().findElement(By.linkText("5000"));
        WebElement debitAmount = Driver.getDriver().findElement(By.id("amt7"));

        actions.dragAndDrop(fiveK,debitAmount).perform();



//    5- Drag “SALES” and drop into Account area under Credit Side


//    6- Drag “5000” and drop into Amount area under Credit Side


//    7- Verify “Perfect!” text displayed.
    }
}
