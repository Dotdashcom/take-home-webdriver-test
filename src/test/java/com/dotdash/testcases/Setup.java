package com.dotdash.testcases;

import com.framework.libraries.BrowserBucket;
import com.framework.libraries.I;
import com.framework.libraries.MyTestClasses;
import org.testng.annotations.AfterMethod;

public class Setup {

    @AfterMethod
    public void close(){
        MyTestClasses.closeAllClasses();
    }

    public void navigateTo(String endpoint){
            I.amPerforming().navigate().to(BrowserBucket.environment+"/"+endpoint);
    }
}
