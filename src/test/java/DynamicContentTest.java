import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Constants;

import java.util.List;
import java.util.stream.Collectors;

class DynamicContentTest {

    WebDriver driver;

    static String url = "/dynamic_content";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.baseUrl+ url);
    }

    @Test
    void dynamicContentTest() {

        String textsXpathExpression = "//div[@class='large-10 columns']";
        String imagesXpathExpression = "//div[@class='large-2 columns']";

        List<String> texts = getTexts(textsXpathExpression);

        List<String> images = getImages(imagesXpathExpression);

        for (int j=0; j<5; j++) {

            driver.navigate().refresh();

            List<String> textsAfterRefresh = getTexts(textsXpathExpression);

            List<String> imagesAfterRefresh = getImages(imagesXpathExpression);

            for (int i = 0; i < texts.size(); i++) {
                if (texts.get(i).equals(textsAfterRefresh.get(i)) &&
                        images.get(i).equals(imagesAfterRefresh.get(i))
                ) {
                    assert false;
                }
            }

            texts = textsAfterRefresh;
            images = imagesAfterRefresh;
        }

        assert true;
    }

    private List<String> getTexts (String textsXpathExpression) {
        return
            driver
            .findElements(By.xpath(textsXpathExpression))
            .stream()
            .map(x -> x.getText())
            .collect(Collectors.toList()
        );
    }

    private List<String> getImages (String imagesXpathExpression) {
        return
            driver
                .findElements(By.xpath(imagesXpathExpression))
                .stream()
                .map(x -> x.findElement(By.tagName("img")).getAttribute("src"))
                .collect(Collectors.toList());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}