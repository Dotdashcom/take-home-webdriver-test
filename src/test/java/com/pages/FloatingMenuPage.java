package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage extends BaseClass {

    public FloatingMenuPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using =  "//a[text()='Home']")
    public WebElement _homeButton;

    @FindBy(how = How.XPATH, using =  "//a[text()='News']")
    public WebElement _newsButton;

    @FindBy(how = How.XPATH, using =  "//a[text()='Contact']")
    public WebElement _contactButton;

    @FindBy(how = How.XPATH, using =  "//a[text()='About']")
    public WebElement _aboutButton;






}
