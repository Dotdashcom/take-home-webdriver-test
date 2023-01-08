package model;

import model.base.DynamicStaticContentPage;
import org.openqa.selenium.WebDriver;

public class DynamicContentPage extends DynamicStaticContentPage {

    private static final String DYNAMIC_CONTENT_ENDPOINT = "dynamic_content";

    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }

    public DynamicContentPage getDynamicContentPage() {
        getDriver(DYNAMIC_CONTENT_ENDPOINT);

        return new DynamicContentPage(getDriver());
    }
}