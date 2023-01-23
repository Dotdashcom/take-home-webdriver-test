package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Base_Page;

import java.time.Duration;
import java.util.Set;

public class windows_page extends Base_Page {
    WebDriver driver;

    public windows_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/a")
    WebElement current_window;
    @FindBy(how = How.XPATH, using = "/html/body/div/h3")
    WebElement text;


    public void Open_in_New_Tab_meth() {
        String wh1 = driver.getWindowHandle();
        current_window.click();

        Set<String> nwh = driver.getWindowHandles();
        for (String wh : nwh) {
            driver.switchTo().window(wh);
        }
        String wh2 = driver.getWindowHandle();
        String expected_title_or_message = "New Window";
        String actual_title = driver.getTitle();
        String actual_message = text.getText();
        check_String(actual_title, expected_title_or_message, "wrong page");
        check_String(actual_message, expected_title_or_message, "wrong message");

    }
}