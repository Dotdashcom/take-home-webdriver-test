package task.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.pages.DropdownPage;
import task.utilities.Driver;

public class Dropdown extends DropdownPage{




        @BeforeEach
        public void setUp(){
            Driver.getDriver().get("http://localhost:7080/dropdown");
        }




    @Test
    public void testDropdown(){

            dropDown.click();

           Assertions.assertTrue(isSelected("Option 1"));
           Assertions.assertTrue(isSelected("Option 2"));
        }



    @AfterEach
    public void tearDown(){
        Driver.closeDriver();
    }



}
