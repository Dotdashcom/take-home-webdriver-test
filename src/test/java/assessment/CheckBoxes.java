package assessment;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;
import util.Driver;

import java.util.List;

public class CheckBoxes extends Driver{

    CheckboxesPage page = new CheckboxesPage(Driver.getDriver());
    @Test
    public void checkboxes_test() {
        Driver.getDriver().get("http://localhost:7080/checkboxes");

        List<WebElement> allCheckBoxes = page.checkboxes;

        try {
            for (WebElement element : allCheckBoxes) {
                if (!element.isSelected()) {
                    element.click();
                } else {
                    element.click();
                    element.click();
                }
                Assert.assertTrue(element.isSelected() , "checkbox is not selected");
            }
        } catch (IndexOutOfBoundsException e) {
            Assert.fail("no web elements in the list");
        }
    }
}
