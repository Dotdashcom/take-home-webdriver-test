package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class DynamicContentPage {
    public WebDriver driver;
    public Helpers helpers;

    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    public By image_1_img = By.xpath("(//div[@id='content'])[2]//div[1]/div[1]/img");
    public By image_2_img = By.xpath("(//div[@id='content'])[2]//div[2]/div[1]/img");
    public By image_3_img = By.xpath("(//div[@id='content'])[2]//div[3]/div[1]/img");
    public By text_1_div = By.xpath("(//div[@id='content'])[2]//div[1]/div[2]");
    public By text_2_div = By.xpath("(//div[@id='content'])[2]//div[2]/div[2]");
    public By text_3_div = By.xpath("(//div[@id='content'])[2]//div[3]/div[2]");


    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    public void GoToDynamicPage() {
        driver.navigate().to(driver.getCurrentUrl() + "dynamic_content");
    }

    public void refreshPage() {

        helpers.refreshPage();
        helpers.refreshPage();
        helpers.refreshPage();

    }

    public void Validation_changes_upon_refresh() {

        String image_1_before_refresh = helpers.getAttribute(image_1_img, "src");
        String image_2_before_refresh = helpers.getAttribute(image_2_img, "src");
        String image_3_before_refresh = helpers.getAttribute(image_3_img, "src");
        String text_1_before_refresh = helpers.getText(text_1_div);
        String text_2_before_refresh = helpers.getText(text_2_div);
        String text_3_before_refresh = helpers.getText(text_3_div);

        helpers.refreshPage();

        Assert.assertNotEquals(image_1_before_refresh, helpers.getAttribute(image_1_img, "src"));
        Assert.assertNotEquals(image_2_before_refresh, helpers.getAttribute(image_2_img, "src"));
        Assert.assertNotEquals(image_3_before_refresh, helpers.getAttribute(image_3_img, "src"));
        Assert.assertNotEquals(text_1_before_refresh, helpers.getText(text_1_div));
        Assert.assertNotEquals(text_2_before_refresh, helpers.getText(text_2_div));
        Assert.assertNotEquals(text_3_before_refresh, helpers.getText(text_3_div));



    }
}
