package com.project.tests;

import com.project.pages.CheckBoxesPage;
import com.project.utility.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkboxes {

 CheckBoxesPage checkboxes =new CheckBoxesPage();

  @Test
    public void checkBoxesCheck() throws InterruptedException {

      Driver.getDriver().get("http://localhost:7080/checkboxes");

      Thread.sleep(3000);
      checkboxes.checkBox1.click();
      Assert.assertTrue(checkboxes.checkBox1.isSelected());

      Thread.sleep(3000);
      checkboxes.checkBox1.click();
      Assert.assertFalse(checkboxes.checkBox1.isSelected());

      Driver.closeDriver();

//

  }

    @Test
    public void checkBoxesCheck2() throws InterruptedException {

        Driver.getDriver().get("http://localhost:7080/checkboxes");

        Driver.getDriver().manage().window().maximize();

        Thread.sleep(3000);
        checkboxes.checkBox2.click();
        Assert.assertFalse(checkboxes.checkBox2.isSelected());
        Thread.sleep(3000);

        checkboxes.checkBox2.click();
        Assert.assertTrue(checkboxes.checkBox2.isSelected());

        Thread.sleep(2);

        Driver.closeDriver();


    }


}
