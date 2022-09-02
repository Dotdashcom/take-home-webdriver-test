package Tests;

import Pages.DropdownPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class DropDownTest {
    String baseURL="http://localhost:7080";

    @Test
    public void dropdown(){
        DropdownPage dropdownPage=new DropdownPage();

        Driver.getDriver().get(baseURL+"/dropdown");
        Select select=new Select(dropdownPage.select);
        select.selectByValue("1");
    }
}
