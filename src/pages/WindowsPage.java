import org.openqa.selenium.*;

import java.util.ArrayList;

public class WindowsPage extends BasePage {
    private String path = "/windows";
    private String linkPath = "/new";

    private By newWindowLinkBy = By.xpath("//a[contains(text(), \"Click Here\")]");

    WindowsPage(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        String url = getBaseUrl() + path;
        return url;
    }

    public String getLinkUrl() {
        String url = getBaseUrl() + path + linkPath;
        return url;
    }

    public void clickNewWindowLink() {
        driver.findElement(newWindowLinkBy).click();
    }

    public int numOfTabs() {
        ArrayList<String> tabs = new ArrayList<String>( driver.getWindowHandles() );
        return tabs.size();
    }

    public void switchTabs(int index) {
        ArrayList<String> tabs = new ArrayList<String>( driver.getWindowHandles() );

        driver.switchTo().window(tabs.get(index));
    }

    public void closeTab(int index) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        driver.close();
    }
}
