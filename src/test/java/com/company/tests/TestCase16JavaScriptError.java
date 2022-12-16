package com.company.tests;

import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 Test finds the JavaScript error on the page.
 Test asserts that the page contains error: Cannot read property 'xyz' of undefined.
 */
public class TestCase16JavaScriptError {

    @Test
    public void javaScriptError() {

        Driver.getDriver().get("http://localhost:7080/javascript_error");


//javascript_error:7 Uncaught TypeError: Cannot read properties of undefined (reading 'xyz')
//    at loadError (javascript_error:7:52)
//    at onload (javascript_error:11:30)
//
//        let displayValue = (value) => {
//            if (value === undefined) {
//                console.log(value.xyz);
//            }
//            return value;
//        };
//
//        try {
//            let test_value;
//            console.log(displayValue(test_value));
//        } catch (error) {
//            console.log(error.message);
//        }

        Driver.closeDriver();
    }
}
