package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.JavaScriptErrorPage;
import org.junit.Assert;
import org.junit.Test;

public class JavaScriptErrorTest extends BaseTest {

    public JavaScriptErrorTest(){
        super();
    }

    @Test
    public void VerifyJavaScriptErrorMessage(){

        JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage(driver);

        Assert.assertTrue(javaScriptErrorPage.assertJSErrorMessage());

    }

}
