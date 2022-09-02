package Tests;

import Pages.CheckBoxPage;
import org.junit.jupiter.api.Test;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckBox {
    String baseURL="http://localhost:7080";

    @Test
    public void checkBoxTest(){
        CheckBoxPage checkBoxPage=new CheckBoxPage();


        Driver.getDriver().get(baseURL+"/checkboxes");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        checkBoxPage.checkBox.click();
        assertTrue(checkBoxPage.checkBox.isSelected());


    }
}
