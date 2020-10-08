package regression.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public final class WindowsPage extends WebObject {
    public WindowsPage(WebDriver driver) throws Exception {
        super(driver);
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public static WindowsPage navigateToWindowsPage(WebDriver driver, String baseUrl) throws Exception {
        String url = String.format("%s/windows", baseUrl);
        driver.get(url);
        return new WindowsPage(driver);
    }

    public String getPageTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public void clickLink() {
        driver.findElement(By.xpath(this.xpathForLink())).click();
    }

    public void switchTabs(WebDriver driver, int nthTab) throws Exception {
        int tabIndex = nthTab - 1;
        if (tabIndex < 0) {
            throw new Exception("Invalid tab selection! Note, tab selection is not 0 indexed.");
        }

        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        int handleCount = handles.size();
        if (handleCount < nthTab) {
            throw new Exception("Invalid tab selection! There are only $handleCount tabs.");
        }
        driver.switchTo().window(handles.get(tabIndex));
    }

    public void closeCurrentTab(WebDriver driver) throws Exception {
        int currentHandleIndex = -1;
        String currentHandle = driver.getWindowHandle();
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        int handleCount = handles.size();
        if (handleCount <= 1) {
            throw new Exception("There is only one tab open!");
        }
        for (int i = 0; i < handleCount; i++) {
            if (currentHandle.equals(handles.get(i))) {
                currentHandleIndex = i;
            }
        }

        driver.close();
        if (currentHandleIndex <= 0) {
            driver.switchTo().window(handles.get(currentHandleIndex + 1));
        } else {
            driver.switchTo().window(handles.get(currentHandleIndex - 1));
        }
    }

    private String xpathForPageTitle() {
        return "//h3";
    }

    private String xpathForLink() {
        return "//a[text()=\"Click Here\"]";
    }
}
