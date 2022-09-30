package e2e.tests;

import e2e.pages.ContextMenuPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContextMenuTest extends BaseSpec {
    ContextMenuPage contextMenuPage;
    public final String contextMenuEndpoint = configReader.getContextMenuEndpoint();
    public final String contextAlertMessage = configReader.getContextAlertMessage();

    @BeforeEach
    public void open(){
        contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.visit(contextMenuEndpoint);
    }

    @Test
    public void validateContextMenuMessage(){
        contextMenuPage.rightClick();
        Assertions.assertEquals(contextMenuPage.getAlertText(), contextAlertMessage);
    }
}
