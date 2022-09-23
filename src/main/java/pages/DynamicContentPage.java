package pages;

import core.AbstractWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DynamicContentPage extends AbstractWebPage {

    @FindBy(css = "#content > div > p > a")
    protected WebElement clickHereElm;

    @FindBy(css = "#content > div > div:nth-child(2)")
    protected List<WebElement> dynamicContentParagraphs;

    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }

    public void generateDynamicContent() {
        clickHereElm.click();
    }

    public String getParagraphText(int paraNumber) {
        return dynamicContentParagraphs.get(paraNumber).getText();
    }
}

