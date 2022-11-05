package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginPage {
	
	WebDriver driver;

    By username = By.name("username");

    By password = By.name("password");

    By titleText =By.xpath("//*[@id=\"content\"]/div/h2");

    By login = By.xpath("//*[@id=\"login\"]/button/i");

    public LoginPage(WebDriver driver){

        this.driver = driver;

    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        driver.findElement(username).sendKeys(strUserName);

    }

    //Set password in password textbox

    public void setPassword(String strPassword){

         driver.findElement(password).sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(){

            driver.findElement(login).click();

    }

    //Get the title of Login Page

    public String getLoginTitle(){

     return  driver.findElement(titleText).getText();

    }

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void loginHome(String strUserName,String strPasword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickLogin();        
    }

}


