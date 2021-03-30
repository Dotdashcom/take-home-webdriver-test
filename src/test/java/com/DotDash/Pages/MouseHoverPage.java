package com.DotDash.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MouseHoverPage {

    public WebDriver ldriver;

    public MouseHoverPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/div/img")
    public List<WebElement> imgs;

    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/img[1]")
    public WebElement img1;

    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[2]/img[1]")
    public WebElement img2;

    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[3]/img[1]")
    public WebElement img3;

    @FindBy(xpath = "//h5[contains(text(),'name: user1')]")
    public WebElement caption1;

    @FindBy(xpath = "//h5[contains(text(),'name: user2')]")
    public WebElement caption2;

    @FindBy(xpath = "//h5[contains(text(),'name: user3')]")
    public WebElement caption3;

    @FindBy(xpath = "//div[@class='figcaption']/h5")
    public WebElement captions;




}
