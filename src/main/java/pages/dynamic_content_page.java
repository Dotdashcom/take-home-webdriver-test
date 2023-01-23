package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Base_Page;

public class dynamic_content_page extends Base_Page {

    WebDriver driver;

    public dynamic_content_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[3]/div[2]")
    WebElement content;

    public void Dynamic_Content_meth() {

        for (int i = 0; i <= 5; i++) {
            String content_text_before = content.getText();
            driver.navigate().refresh();
            String content_text_after = content.getText();
            Assert.assertNotEquals(content_text_before, content_text_after);
        }

    }
}
