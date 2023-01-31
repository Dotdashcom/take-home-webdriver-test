package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage {
    @FindBy(tagName = "h3")
    private WebElement contextMenuPageTitle;

    @FindBy(id = "hot-spot")
    private WebElement hotSpotBox;

    public ContextMenuPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getHotSpotBox() {
        return hotSpotBox;
    }

    public void assertPageTitle(String expectedTitle) {
        Assertions.assertEquals(expectedTitle, contextMenuPageTitle.getText());
    }

    @Override
    public void assertElementsAreDisplayed() {
        Assertions.assertTrue(contextMenuPageTitle.isDisplayed());
        Assertions.assertTrue(hotSpotBox.isDisplayed());
    }
}
