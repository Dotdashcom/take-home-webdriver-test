package com.interview.pages;

import com.interview.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage {
   public DynamicContentPage(){
       PageFactory.initElements(Driver.getDriver(),this);
   }

   @FindBy(xpath = "(//div[@class='large-10 columns'])[3]")
    public WebElement dynamicContent;
   @FindBy(xpath = "(//a)[2]")
    public WebElement clickHereButton;

}
