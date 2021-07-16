package com.dotdash;

import org.junit.Test;
import org.openqa.selenium.By;

public class Test16JavaScriptErrors extends BaseMethod{

    @Test
    public void JavaScriptErrors(){
        driver.get("http://localhost:7080/javascript_error");
        driver.findElement(By.xpath("//body[@onload=\"loadError()\"]"));





    }

}
