package com.qa.pages;

import org.openqa.selenium.By;

public class DynamicControl extends BasePage{


    By addRemoveBtn= By.xpath("//form [@id='checkbox-example']//button");
    By itGone= By.xpath("//form [@id='checkbox-example']//p");
    By CheckBoxLoadingImage=By.xpath("//*[@id='checkbox-example']//img");
    By enableDisableBtn=By.xpath("//*[@id='input-example']//button");
    By enableDisableLoadingImage=By.xpath("//*[@id='input-example']//img");
    By enabledDisabledTest= By.xpath("//*[@id='input-example']//p");

    public boolean removeAddEnableDisable()
    {
        boolean isDynamicControlsOk=false;
       Utility.wait(driver.findElement(addRemoveBtn));
       driver.findElement(addRemoveBtn).click();
       Utility.wait(driver.findElement(CheckBoxLoadingImage));
       Utility.waitUntilDisappear(driver.findElement(CheckBoxLoadingImage));
       Utility.wait(driver.findElement(itGone));
       boolean removeaddOk= driver.findElement(itGone).isDisplayed();

        Utility.wait(driver.findElement(enableDisableBtn));
        driver.findElement(enableDisableBtn).click();
        Utility.wait(driver.findElement(enableDisableLoadingImage));
        Utility.waitUntilDisappear(driver.findElement(enableDisableLoadingImage));
        Utility.wait(driver.findElement(enabledDisabledTest));
        boolean enableDisableOk= driver.findElement(enabledDisabledTest).isDisplayed();
        if(removeaddOk||enableDisableOk)
        {
            isDynamicControlsOk=true;
        }
        else {
            isDynamicControlsOk=false;
        }
       return isDynamicControlsOk;
    }

}
