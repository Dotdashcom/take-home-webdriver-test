package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Base_Page;

public class floating_menu_page extends Base_Page {

    WebDriver driver;

    public floating_menu_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"menu\"]")
    WebElement Floating_Menu;

    public void right_click_meth() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0,8000)");

        check_boolean(Floating_Menu.isDisplayed(), true, "is not scrollable");



}
}