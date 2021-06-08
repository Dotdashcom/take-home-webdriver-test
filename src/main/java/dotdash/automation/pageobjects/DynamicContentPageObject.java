package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DynamicContentPageObject extends BasePageObject {
    @FindBy(css = "div[class='large-10 columns']")
    private List<WebElement> textElements;

    public DynamicContentPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public List<String> getDynamicText() {
        List<String> textList = new ArrayList<>();
        for (WebElement element : textElements) {
            textList.add(element.getText());
        }
        return textList;
    }

    public int listSize() {
        return textElements.size();
    }

    public DynamicContentPageObject refreshPage() {
        this.driver.navigate().refresh();
        return this;
    }
}
