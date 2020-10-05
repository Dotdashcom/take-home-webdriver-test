package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.DynamicContentPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//Testcase Description:Dynamic Content: http://localhost:7080/dynamic_content Test content changes with page reload.
public class TC07_DynamicContent extends baseClass {

    @Test
    public void dynamicContent() {
        //Launch url
        driver.get(baseURL + "/dynamic_content");

        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
        //Getting the content and storing it in String variable s1
        String s1 = dynamicContentPage.gettxtcontent();
        System.out.println(s1);
        //Refreshing the page
        driver.navigate().refresh();
        //Getting the content and storing it in String variable s2
        String s2 = dynamicContentPage.gettxtcontent();
        System.out.println(s2);

        SoftAssert assertion = new SoftAssert();
        //Validate whether the content has changed after refreshing the page
        if(s1.equals(s2))
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!! Content Didnot change!! It is not Dynamic!!!");
        }
        else
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!! Dynamic content change successful!!!!");
        }
        //Refreshing the page
        driver.navigate().refresh();
        //Getting the content and storing it in String variable s2
        String s3 = dynamicContentPage.gettxtcontent();
        System.out.println(s3);

                //Validate whether the content has changed after refreshing the page
        if(s2.equals(s3))
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!! Content Didnot change!! It is not Dynamic!!!");
        }
        else
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!! Dynamic content change successful!!!!");
        }

        assertion.assertAll();

    }
}
