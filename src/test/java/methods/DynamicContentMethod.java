package methods;

import model.DynamicContentPage;
import org.openqa.selenium.WebElement;

public class DynamicContentMethod extends GeneralTestMethod{
    private final String dynamicContentURL = "http://localhost:7080/dynamic_content";
    protected String originalContent;
    protected String refreshedContent;
    DynamicContentPage dynamicContentPage;


    public void startDynamicContentTest(int numOfRefresh) {
        driver.get(dynamicContentURL);
        dynamicContentPage = new DynamicContentPage(driver);
        originalContent = getContent(dynamicContentPage.contentComponent());
        refresh(numOfRefresh);
        refreshedContent = getContent(dynamicContentPage.contentComponent());
    }

    public boolean isContentEqual() {
        return originalContent.equals(refreshedContent);
    }

    public void refresh(int numOfRefresh) {
        if(numOfRefresh < 0) numOfRefresh = 0;
        while(numOfRefresh > 0) {
            driver.navigate().refresh();
            numOfRefresh--;
        }
    }

    public String getContent(WebElement webElement) {
        return webElement.getText();
    }

}
