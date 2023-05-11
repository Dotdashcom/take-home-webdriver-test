package task.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.pages.CheckBoxesPage;
import task.utilities.Driver;

public class CheckBoxes extends CheckBoxesPage{



    CheckBoxesPage checkBoxesPage = new CheckBoxesPage();


    @BeforeEach
    public void setUp(){
        Driver.getDriver().get("http://localhost:7080/checkboxes");
    }


    @Test
    public void testCheckBox1() {
        checkBoxesPage.clickCheckBox1();
        Assertions.assertTrue(checkBoxesPage.isCheckBox1Selected());


        checkBoxesPage.clickCheckBox1();
        Assertions.assertFalse(checkBoxesPage.isCheckBox1Selected());



    }

    @Test
    public void testCheckBox2() {

        checkBoxesPage.clickCheckBox2();
        Assertions.assertTrue(!checkBoxesPage.isCheckBox2Selected());

        checkBoxesPage.clickCheckBox2();
        Assertions.assertTrue(checkBoxesPage.isCheckBox2Selected());
    }



    @AfterEach
    public void tearDown(){
        Driver.closeDriver();
    }



}
