import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class DynamicPage extends BasePage {
    private String path = "/dynamic_content";

    private String rowXpath = "//div[@id='content']/div[@class='row']";
    private String colXpath = "/div";
    private String imgXpath = "/img";

    DynamicPage(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        String url = getBaseUrl() + path;
        return url;
    }

    public String getRowText(int rowNum) {
        return driver.findElement(By.xpath(rowXpath + "[" + rowNum + "]" +
                colXpath + "[2]")).getText();
    }

    public String getRowImgSrc(int rowNum) {
        return driver.findElement(By.xpath(rowXpath + "[" + rowNum + "]" +
                colXpath + "[1]" + imgXpath)).getAttribute("src");
    }
}
