package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.OpenNewTabPage;
import org.junit.Test;

public class OpenNewTabTest extends BaseTest {

    public OpenNewTabTest(){
        super();
    }

    @Test
    public void OpenNewTabAndValidateTheText(){

        OpenNewTabPage openNewTabPage = new OpenNewTabPage(driver);

        openNewTabPage.clickClickHereBtn();
        openNewTabPage.assertTextInNewTab("New Window");
    }

}
