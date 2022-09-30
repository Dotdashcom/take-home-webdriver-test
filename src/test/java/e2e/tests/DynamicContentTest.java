package e2e.tests;

import e2e.pages.DynamicContentPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamicContentTest extends BaseSpec {
    DynamicContentPage dynamicContentPage;
    public final String dynamicContentEndpoint = configReader.getDynamicContentEndpoint();

    @BeforeEach
    public void open(){
        dynamicContentPage = new DynamicContentPage(driver);
        dynamicContentPage.visit(dynamicContentEndpoint);
    }
    @Test
    public void validateContentChanges(){
        String prevContent = dynamicContentPage.getContentValue();
        dynamicContentPage.refreshPage();

        String newContent = dynamicContentPage.getContentValue();
        Assertions.assertNotEquals(prevContent, newContent);
        prevContent = newContent;

        dynamicContentPage.refreshPage();
        newContent = dynamicContentPage.getContentValue();
        Assertions.assertNotEquals(prevContent, newContent);
    }

}
