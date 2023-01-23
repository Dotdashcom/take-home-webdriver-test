package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Base_Page;

public class checkboxes_page extends Base_Page {

    WebDriver driver;

    public checkboxes_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"checkboxes\"]/input[1]")
    WebElement chech_box_1;
    @FindBy(how = How.XPATH, using = "//*[@id=\"checkboxes\"]/input[2]")
    WebElement chech_box_2;

    public void chech_box_meth() {

        Boolean box_1_before = chech_box_1.isSelected();
        Boolean box_2_before = chech_box_2.isSelected();
//        System.out.println("box_1_before: "+box_1_before);
//        System.out.println("box_2_before: "+box_2_before);
        chech_box_1.click();
        chech_box_2.click();
        Boolean box_1_after = chech_box_1.isSelected();
        Boolean box_2_after = chech_box_2.isSelected();
//        System.out.println("box_1_after: "+box_1_after);
//        System.out.println("box_2_after: "+box_2_after);
        if(box_1_before.equals(box_1_after)) {
            Assert.assertTrue(false);
        }else
            Assert.assertTrue(true);
        if(box_2_before.equals(box_2_after)) {
            Assert.assertTrue(false);
        }else
            Assert.assertTrue(true);






    }
}