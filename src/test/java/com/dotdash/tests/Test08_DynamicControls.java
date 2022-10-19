package com.dotdash.tests;

import com.dotdash.pages.DropdownPage;
import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test08_DynamicControls {

    /**
     * Test clicks on the Remove Button and uses explicit wait.
     * Test asserts that the checkbox is gone.
     * Test clicks on Add Button and uses explicit wait.
     * Test asserts that the checkbox is present.
     * Test clicks on the Enable Button and uses explicit wait.
     * Test asserts that the text box is enabled.
     * Test clicks on the Disable Button and uses explicit wait.
     * Test asserts that the text box is disabled.
     */

    @Test
    public void dynamicControlsTest() {

        String url = ConfigurationReader.getProperty("base.url") + "";
        Driver.getDriver().get(url);



        Driver.closeDriver();
    }

}
