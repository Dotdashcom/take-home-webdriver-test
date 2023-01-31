package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class DynamicContentPage extends BasePage {
    @FindBy(tagName = "h3")
    private WebElement dynamicContentPageTitle;

    @FindBy(id = "content")
    private WebElement content;

    @FindBy(xpath = "//div[@class='large-2 columns']/img")
    private List<WebElement> images;

    @FindBy(xpath = "//div[@class='large-10 columns']")
    private List<WebElement> descriptions;


    public DynamicContentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getDescriptions() {
        return descriptions
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getImageRefs() {
        return images
                .stream()
                .map(image -> image.getAttribute("src"))
                .collect(Collectors.toList());
    }

    public void assertDescriptions(List<String> expectedDescriptions) {
        Assertions.assertNotEquals(expectedDescriptions, getDescriptions());
    }

    public void assertImageRefs(List<String> imageRefs) {
        Assertions.assertNotEquals(imageRefs, getImageRefs());
    }

    public void assertContentCount(int expectedCount) {
        Assertions.assertEquals(expectedCount, images.size());
        Assertions.assertEquals(expectedCount, descriptions.size());
    }

    public void assertPageTitle(String expectedTitle) {
        Assertions.assertEquals(expectedTitle, dynamicContentPageTitle.getText());
    }

    @Override
    public void assertElementsAreDisplayed() {
        Assertions.assertTrue(content.isDisplayed());
        Assertions.assertTrue(dynamicContentPageTitle.isDisplayed());
        Assertions.assertFalse(images.isEmpty());
        Assertions.assertFalse(descriptions.isEmpty());
    }
}
