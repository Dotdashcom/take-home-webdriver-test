package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage {

  WebDriver driver;

  @FindBy(xpath = "/html/body/div[2]/div/div/form/input[1]" )
  WebElement checkBox1;

  @FindBy(xpath = "/html/body/div[2]/div/div/form/input[2]" )
  WebElement checkBox2;

  public CheckBoxPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver,this);
  }

  public CheckBoxPage() {

  }

  public void check(){
    driver.get("http://localhost:7080/checkboxes");
    checkBox1.click();
    checkBox2.click();
  }
}
