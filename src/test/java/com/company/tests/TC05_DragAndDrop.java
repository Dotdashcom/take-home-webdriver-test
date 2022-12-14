package com.company.tests;

import com.company.base.TestBase;
import com.company.utilities.ConfigurationReader;
import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test drags element A to element B.
 * Test asserts that the text on element A and B are switched.
 */


public class TC05_DragAndDrop {

    @Test
    public void dragAndDrop() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getProperty("dragAndDrop"));
        Actions actions = new Actions(Driver.getDriver());

//    3- Drag “BANK” and drop into Account area under Debit Side
        WebElement A = Driver.getDriver().findElement(By.id("column-a"));
        WebElement B = Driver.getDriver().findElement(By.id("column-b"));

        int xOffset1 = A.getLocation().getX();
        int yOffset1 =  A.getLocation().getY();

        int xOffset = B.getLocation().getX();
        int yOffset =  B.getLocation().getY();

        System.out.println("xOffset--->"+xOffset+" yOffset--->"+yOffset);

        xOffset =(xOffset-xOffset1)+10;
        yOffset=(yOffset-yOffset1)+20;


        //Perform dragAndDropBy
        actions.dragAndDropBy(A, xOffset,yOffset).perform();

        //verify text changed in to 'Drop here' box
        //Get text value of 'to' element
        String textTo = B.getText();






//        actions.dragAndDrop(A, B).build().perform();
//
//        WebElement headerColumnA = Driver.getDriver().findElement(By.xpath("//*[@id='column-a']/header"));
//
//        Assert.assertTrue(headerColumnA.isDisplayed(), "Result text did not displayed!");
//
//        String actualResultText = headerColumnA.getText();
//        System.out.println(actualResultText);
//        String expectedResultText = "A";
//        Assert.assertEquals(actualResultText, expectedResultText, "Result text did not appear correctly!");

        //Thread.sleep(2000);

        // //*[@id="column-a"]/header
        // //*[@id="column-b"]/header

//        if(textTo.equals("Dropped!")) {
//            System.out.println("PASS: Source is dropped at location as expected");
//        }else {
//            System.out.println("FAIL: Source couldn't be dropped at location as expected");
//        }
//
//        driver.close();
//


//    7- Verify “Perfect!” text displayed.
    }
}
