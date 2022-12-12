package com.company.pages;

import com.company.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTableOrderPage extends BasePage{

    public WebTableOrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name="product")
    public WebElement product;

    @FindBy(name="quantity")
    public WebElement quantity;

    @FindBy(name="name")
    public WebElement customerName;

    @FindBy(name="street")
    public WebElement street;

    @FindBy(name="city")
    public WebElement city;

    @FindBy(name="state")
    public WebElement state;

    @FindBy(name="zip")
    public WebElement zipCode;

    @FindBy(name="card")
    public List<WebElement> creditCardType;

    @FindBy(name="cardNo")
    public WebElement creditCardNumber;

    @FindBy(name="cardExp")
    public WebElement expiryDate;

    @FindBy(xpath="//button[.='Process Order']")
    public WebElement processOrderBtn;





}
