package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

import java.util.ArrayList;
import java.util.List;

public class DynamicContentTests extends TestBase {


    /**
     * 7. Dynamic Content
     *
     * Test refreshes the page a couple of times.
     * Test asserts that the content changes on each refresh.
     */
    @Test
    @DisplayName("Verify Dynamic Content")
    public void dynamicContentTest() {
        Driver.getDriver().findElement(By.linkText("Dynamic Content")).click();

        List<WebElement> imagesBeforeRefresh = Driver.getDriver().findElements(By.xpath("//div[@id='content']//img"));
        List<WebElement> textBlocksBeforeRefresh = Driver.getDriver().findElements(By.xpath("//div[@class='large-10 columns']"));

        List<String> imagesBeforeRefreshTextList = new ArrayList<>();
        List<String> textBlocksBeforeRefreshTextList = new ArrayList<>();

        imagesBeforeRefresh.forEach(p -> imagesBeforeRefreshTextList.add(p.getAttribute("src")));
        textBlocksBeforeRefresh.forEach(p -> textBlocksBeforeRefreshTextList.add(p.getText()));

        Driver.getDriver().navigate().refresh();

        List<WebElement> imagesAfterRefresh = Driver.getDriver().findElements(By.xpath("//div[@id='content']//img"));
        List<WebElement> textBlocksAfterRefresh = Driver.getDriver().findElements(By.xpath("//div[@class='large-10 columns']"));

        for (int index = 0; index < imagesBeforeRefresh.size(); index++) {
            String imgBefore = imagesBeforeRefreshTextList.get(index);
            WebElement imgAfter = imagesAfterRefresh.get(index);
            String textBefore = textBlocksBeforeRefreshTextList.get(index);
            WebElement textAfter = textBlocksAfterRefresh.get(index);

            Assertions.assertNotEquals(imgBefore, imgAfter.getAttribute("src"), "Image is the same!");
            Assertions.assertNotEquals(textBefore, textAfter.getText(), "Text is the same!");
        }
    }
}
