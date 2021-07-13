package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DynamicContentPage extends PageObject {

    @FindBy(how = How.ID, using = "content")
    private WebElement content;

    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }

    public String getDynamicContent() {
        return content.getText();
    }
}
