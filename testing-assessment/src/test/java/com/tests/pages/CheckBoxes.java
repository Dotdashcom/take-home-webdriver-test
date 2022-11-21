package com.tests.pages;

import com.tests.util.DriverTest;
import com.tests.util.ScreenShotTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxes extends BasePage {


     @FindBy(xpath = "(//input[@type='checkbox'])[1]")
     private WebElement checkBox1Input;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    private WebElement checkBox2Input;



    @BeforeClass
    public static void setUp(){
        DriverTest.getDriver().get("http://localhost:7080/checkboxes ");
    }

    //Check the checkbox1 and takes screenshot after the checkbox1 is checked
    @Test
    public void checkTheCheckBox1()throws Exception{
     waitForVisibilityOf(checkBox1Input);
     if (!checkBox1Input.isSelected()){
         checkBox1Input.click();
         ScreenShotTest.takeScreenShot("checkbox1");
     }else {
         System.out.println("-> Checkbox 1 is already clicked");
     }

    }

    //Uncheck the checkbox2 and takes screenshot after the checkbox2 is unchecked
    @Test
    public void unCheckTheCheckBox2()throws Exception{
        waitForVisibilityOf(checkBox2Input);
        if (checkBox2Input.isSelected()){
            checkBox2Input.click();
            ScreenShotTest.takeScreenShot("checkbox2");
        }else {
            System.out.println("-> Checkbox 2 is not selected");
        }
    }


    @AfterClass
    public static void tearDown() {
        DriverTest.getDriver().close();
    }

}
