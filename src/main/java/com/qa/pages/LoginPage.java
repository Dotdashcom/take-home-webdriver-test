package com.qa.pages;

import org.openqa.selenium.By;


public class LoginPage extends BasePage{
By userName= By.id("username");
By password= By.name("password");
By loginBtn= By.xpath("//*[@type='submit']");


public LandingPage login(String user, String psd){
    Utility.wait(driver.findElement(userName ));
    driver.findElement(userName).sendKeys(user);

    Utility.wait(driver.findElement(password ));
    driver.findElement(password).sendKeys(psd);

    Utility.wait(driver.findElement(loginBtn ));
    driver.findElement(loginBtn).click();
    return new LandingPage();

}

    public boolean loginFail(String user, String psd){
        Utility.wait(driver.findElement(userName ));
        driver.findElement(userName).sendKeys(user);

        Utility.wait(driver.findElement(password ));
        driver.findElement(password).sendKeys(psd);

        Utility.wait(driver.findElement(loginBtn ));
        driver.findElement(loginBtn).click();
        // if login Btn displayed, it means not logged in
        return driver.findElement(loginBtn).isDisplayed();

    }


}
