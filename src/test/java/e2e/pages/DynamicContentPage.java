package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicContentPage extends BasePage {

    @FindBy(css=".example .row #content")
    WebElement content;

    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }

    public String getContentValue(){
        return content.getAttribute("innerHTML");
    }

}
