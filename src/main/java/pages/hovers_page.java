package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Base_Page;

import java.util.List;

public class hovers_page extends Base_Page {
    WebDriver driver;

    public hovers_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//div[@class='figure']")
    List <WebElement> image;
    @FindBy(how = How.CLASS_NAME, using = "figcaption")
    List <WebElement> each_image;

    public void hovers_page_meth() {

        for(int i = 0; i<=image.size()-1;i++) {
            Actions act = new Actions(driver);
            act.moveToElement(image.get(i)).build().perform();
            check_boolean(each_image.get(i).isDisplayed(), true, "no additional informations displayed");
        }

    }
}
