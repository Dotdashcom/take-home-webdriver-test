package testsJunit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.util.List;

public class Checkboxes extends BaseClass {


    //I am on the checkbox page"
    //I varify checks and unchecks checkboxes
    @Test
    public void i_varify_checks_and_unchecks_checkboxes() {
        Driver.getDriver().get("http://localhost:7080/checkboxes");
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//*[@id=\"checkboxes\"]/input"));
        boolean flag = false;
        String checkbox = "not Selected";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected()) {
                checkbox = "selected";

            }
            System.out.println(checkbox);

            checkbox = "not Selected";
        }
    }
}
