package model;

import model.base.DynamicStaticContentPage;
import org.openqa.selenium.WebDriver;

public class StaticContentPage extends DynamicStaticContentPage {

    private static final String STATIC_CONTENT_ENDPOINT = "dynamic_content?with_content=static";

    public StaticContentPage(WebDriver driver) {
        super(driver);
    }

    public StaticContentPage getStaticContentPage(){
        getDriver(STATIC_CONTENT_ENDPOINT);

        return new StaticContentPage(getDriver());
    }
}
