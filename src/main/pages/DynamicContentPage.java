package src.main.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DynamicContentPage  extends BasePage{
    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#content.large-10.columns.large-centered > div > div:last-child")
    private List<WebElement> list;

    public String get(int index) {
        return list.get(index).getText();
    }
}
