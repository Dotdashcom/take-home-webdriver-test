package com.dashDot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class JsError extends Main {

    public void jsError(){
        driver.get("http://localhost:7080/javascript_error");
        driver.findElement(By.xpath("/html/body"));
    }
}
