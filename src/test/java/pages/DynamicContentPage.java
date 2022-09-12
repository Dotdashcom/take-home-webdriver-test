package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestSetUp.getDriver;

public class DynamicContentPage extends BasePage {
    public DynamicContentPage() {
        url = "http://localhost:7080/dynamic_content";
    }

    @FindBy(id = "content")
    private WebElement content;

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public String getContent() {
        String currentContent = content.getText();
        return currentContent;
    }

}
