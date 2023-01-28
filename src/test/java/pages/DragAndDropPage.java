package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {
    @FindBy(tagName = "h3")
    private WebElement dragAndDropPageTitle;

    @FindBy(id = "column-a")
    private WebElement columnA;

    @FindBy(id = "column-b")
    private WebElement columnB;

    public DragAndDropPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getColumnA() {
        return columnA;
    }

    public WebElement getColumnB() {
        return columnB;
    }

    public void assertColumnsDrag() {
        Assertions.assertEquals(columnA.getText(), "B");
        Assertions.assertEquals(columnB.getText(), "A");
    }

    public void assertPageTitle(String expectedTitle) {
        Assertions.assertEquals(expectedTitle, dragAndDropPageTitle.getText());
    }

    @Override
    public void assertElementsAreDisplayed() {
        Assertions.assertTrue(dragAndDropPageTitle.isDisplayed());
        Assertions.assertTrue(columnA.isDisplayed());
        Assertions.assertTrue(columnB.isDisplayed());
    }
}
