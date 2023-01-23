package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Base_Page;

import java.util.ArrayList;
import java.util.List;

public class context_menu_page extends Base_Page {

    WebDriver driver;

    public context_menu_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"hot-spot\"]")
    WebElement context_box;

    public void right_click_meth() {

        Actions context = new Actions(driver);
        context.contextClick(context_box).build().perform();
        String Actual_Alert_text = driver.switchTo().alert().getText();
        String Expected_Alert_text = "You selected a context menu";
        if (Actual_Alert_text.contains(Expected_Alert_text)) {
            driver.switchTo().alert().accept();
            Assert.assertTrue(true);
        }else

            Assert.assertTrue(false);
    }

}