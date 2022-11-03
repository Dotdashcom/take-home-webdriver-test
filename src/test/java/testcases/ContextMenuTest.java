package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.ContextMenuPage;
import org.junit.Test;

public class ContextMenuTest extends BaseTest {

    public ContextMenuTest(){
        super();
    }

    @Test
    public void RightClickOnBoxAndAssertTheAlert(){

        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);

        contextMenuPage.rightClickBoxContext();
        contextMenuPage.assertionOfAlert();
    }

}
