package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MouseHoverPage extends BasePage {

    public MouseHoverPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='figure']//img")
    public List<WebElement> images;

    @FindBy(xpath = "//h5[starts-with(text() , 'name: ')]")
    public WebElement caption;
}
