package com.takehome.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class Loginpage 
{
	WebDriver driver;
	//***************Page Elements*****************//
@FindBy(id = "username")WebElement username;
@FindBy(id = "password")WebElement password;
@FindBy(xpath = "//*[@id=\"login\"]/button")WebElement login;
@FindBy(xpath="//*[@id=\"flash\"]")WebElement invalidurltext;



//**************Page Initilzaiton***************//

public Loginpage(WebDriver driver,String baseurl) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	String url = baseurl + "/" + "login";
	driver.get(url);
	PageFactory.initElements(driver,this);
}


public void login(String name,String pwd)
{
	username.sendKeys(name);
	password.sendKeys(pwd);
	login.click();
}

public WebElement getinvalidurltext()
{
	return invalidurltext;
}



}


