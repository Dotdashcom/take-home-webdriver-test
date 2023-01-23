package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Base_Page;

import java.time.Duration;

public class dynamic_controls_page extends Base_Page {
    WebDriver driver;

    public dynamic_controls_page(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(how = How.XPATH, using = "//*[@id=\"checkbox-example\"]/button")
    WebElement Remov_add_Button;
    @FindBy(how = How.XPATH, using = "//*[@id=\"checkbox\"]")
    WebElement check_box;
    @FindBy(how = How.XPATH, using = "//*[@id=\"message\"]")
    WebElement msg;
    @FindBy(how = How.XPATH, using = "//*[@id=\"input-example\"]/button")
    WebElement Enable_disablee_Button;

    public void Dynamic_Controls_meth() {
//		Test clicks on the Remove Button and uses explicit wait.
//		Test asserts that the checkbox is gone.
        Remov_add_Button.click();
        WaitFor_state(driver, Duration.ofSeconds(2), check_box, false);
        check_String(msg.getText(),"It's gone!","wrong");

//		Test clicks on Add Button and uses explicit wait.
//		Test asserts that the checkbox is present.
        Remov_add_Button.click();
        WaitFor_visibility(driver, Duration.ofSeconds(2), check_box);
        check_String(msg.getText(),"It's back!","wrong");

//		Test clicks on the Enable Button and uses explicit wait.
//		Test asserts that the text box is enabled.
        Enable_disablee_Button.click();
        WaitFor_state(driver, Duration.ofSeconds(2), Enable_disablee_Button,false );
        check_String(msg.getText(),"It's enabled!","wrong");

//		Test clicks on the Disable Button and uses explicit wait.
//		Test asserts that the text box is disabled.
        Enable_disablee_Button.click();
        WaitFor_attribute_To_Be_Not_Empty(driver, Duration.ofSeconds(2), Enable_disablee_Button, "disabled");
        check_String(msg.getText(),"It's disabled!","wrong");

    }
}
