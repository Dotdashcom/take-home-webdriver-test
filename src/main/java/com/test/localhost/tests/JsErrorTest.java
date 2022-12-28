package com.test.localhost.tests;
import com.test.localhost.pages.JsErrorPage;
import org.testng.annotations.Test;

public class JsErrorTest extends TestBase{

        @Test
        public void test() {
            JsErrorPage jsErrorTest=new JsErrorPage(driver);
            jsErrorTest.clickOnLink();
           jsErrorTest.verifyError();
        }
    }


