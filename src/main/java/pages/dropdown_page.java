package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Base_Page;

public class dropdown_page extends Base_Page {

    WebDriver driver;

    public dropdown_page(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(how = How.XPATH, using = "//*[@id=\"dropdown\"]")
    WebElement select;
    @FindBy(how = How.XPATH, using = "//*[@id=\"dropdown\"]/option[2]")
    WebElement option_1;
    @FindBy(how = How.XPATH, using = "//*[@id=\"dropdown\"]/option[3]")
    WebElement option_2;

    public void Drop_Down_meth() throws InterruptedException {

        SELECT(select, "Option 1");
        boolean option_1_status = option_1.isSelected();
//       System.out.println("option_1_status: "+option_1_status);
        check_boolean(option_1_status, true, "option 1 is not selected");
        Thread.sleep(2000);
        SELECT(select, "Option 2");
        boolean option_2_status = option_2.isSelected();
//        System.out.println("option_2_status : "+option_2_status);
        check_boolean(option_2_status, true, "option 2 is not selected");

    }

}
