package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.DynamicLoadingPage;
import org.junit.Test;

public class DynamicLoadingTest extends BaseTest {

    public DynamicLoadingTest(){
        super();
    }

    @Test
    public void ClickStartAndCheckTheTextAfterLoading() throws InterruptedException{
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);

        dynamicLoadingPage.clickStartButton();
        dynamicLoadingPage.assertLoadingFinished();
    }
}
