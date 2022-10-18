package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.IframePage;
import org.junit.Test;

public class IframeTest extends BaseTest {

    public IframeTest(){
        super();
    }

    @Test
    public void TypeInTheIframeAndAssertTheText(){
        IframePage iframePage = new IframePage(driver);

        iframePage.typeInTheIframe("Dotdash Automation Exam");

    }
}
