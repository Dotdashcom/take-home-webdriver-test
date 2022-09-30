package e2e.tests;

import e2e.pages.DynamicLoadingPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamicLoadingTest extends BaseSpec {
    DynamicLoadingPage dynamicLoadingPage;
    public final String dynamicLoadingEndpoint = configReader.getDynamicLoadingEndpoint();

    @BeforeEach
    public void open(){
        dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.visit(dynamicLoadingEndpoint);
    }

    @Test
    public void verifyMessageDisplayed(){
        dynamicLoadingPage.clickStart();
        Assertions.assertEquals("Hello World!", dynamicLoadingPage.getMessage());
    }

}
