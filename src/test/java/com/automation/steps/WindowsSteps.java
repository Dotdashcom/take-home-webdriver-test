package com.automation.steps;

import com.automation.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Set;

public class WindowsSteps {

    @Then("assert that a new tab is opened with title {string}")
    public void assertThatANewTabIsOpenedWithTitle(String title) {
        String oldWindow = Driver.get().getWindowHandle();
        Set<String> windowHandles= Driver.get().getWindowHandles();

        for(String each : windowHandles){
            //if it's not old windowHandle
            if(!each.equals(oldWindow)){
                //switch to new window handle
                Driver.get().switchTo().window(each);
            }
        }

        //let's verify we are on new Fresh tab

        String newFreshTabTitle = Driver.get().getTitle();
        System.out.println(newFreshTabTitle);
        Assert.assertEquals(newFreshTabTitle, title);
    }
}
