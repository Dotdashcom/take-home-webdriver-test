package pages;

import base.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.MouseHoverPageSteps;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MouseHoverPage extends Functions {

    @FindBy(xpath = "//img[@alt='User Avatar']")
    public List<WebElement> avatarsList;

    @FindBy(xpath = "//div[@class='figcaption']/h5")
    public List<WebElement> names;

    @FindBy(xpath = "//a[@href='/users/1']")
    public WebElement firstProfileLink;

    @FindBy(xpath = "//body/h2")
    public WebElement actualMessage;

    @FindBy(css = "div:nth-child(3) > img")
    public WebElement firstAvatar;


    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public MouseHoverPage() {

        PageFactory.initElements(driver, this);

    }

}


