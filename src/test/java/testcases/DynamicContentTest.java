package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.DynamicContentPage;
import org.junit.Test;

public class DynamicContentTest extends BaseTest {

    public DynamicContentTest(){
        super();
    }

    @Test
    public void AssertDynamicContent(){
        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
        dynamicContentPage.assertDynamicContent(5);
    }
}
