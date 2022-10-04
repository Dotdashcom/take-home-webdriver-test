package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FloatingMenuPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"page-footer\"]/div/div/a")
    public WebElement pageContent;

    @FindBy(tagName = "a")
    public List<WebElement> floatingMenuList;
}
