package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Base_Page;

import java.time.Duration;

public class dynamic_loading_page extends Base_Page {
    WebDriver driver;

    public dynamic_loading_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"start\"]/button")
    WebElement start_button;
    @FindBy(how = How.XPATH, using = "//*[@id=\"finish\"]/h4")
    WebElement text;

    public void Dynamic_loading_meth() {
        start_button.click();
        WaitFor_present(driver, Duration.ofSeconds(5), text, "Hello World!");
        check_String(text.getText(), "Hello World!", "wrong");
    }
}