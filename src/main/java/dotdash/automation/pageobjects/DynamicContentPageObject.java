package dotdash.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DynamicContentPageObject {
    WebDriver driver;
    By text = By.cssSelector("div[class='large-10 columns']");

    public DynamicContentPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getDynamicText() {
        List<String> textList = new ArrayList<>();
        for (WebElement element : driver.findElements(text)) {
            textList.add(element.getText());
        }
        return textList;
    }

    public int listSize() {
        return driver.findElements(text).size();
    }

    public DynamicContentPageObject refreshPage() {
        this.driver.navigate().refresh();
        return this;
    }
}
