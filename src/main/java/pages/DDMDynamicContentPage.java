package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class DDMDynamicContentPage extends DDMBasePage  {

    @FindBy(css = "#content.large-10.columns.large-centered > div > div:last-child")
    private List<WebElement> userParagraphsList;

    public DDMDynamicContentPage(WebDriver driver)  {
        super(driver);
    }

    public String getParagraphContent(int index)  {
        return userParagraphsList.get(index).getText();
    }
}