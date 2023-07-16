package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.DynamicContentPage;
import testComponents.BaseTest;

public class DynamicContentTest extends BaseTest {

    @Test
    public void dynamicContent(){
        DynamicContentPage dymCont=new DynamicContentPage(driver);
        dymCont.goTo();
        String firsttext=dymCont.getThirdText1();
        dymCont.refrshThePage();
        String Scondtext=dymCont.getThirdText2();
        Assert.assertNotEquals(firsttext,Scondtext);

    }
}
