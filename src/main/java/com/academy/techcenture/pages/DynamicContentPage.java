package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class DynamicContentPage extends BasePage{
    public DynamicContentPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(xpath = "//div[@id='content']//div[@class='row']//div[@class='row']//div//img")
    private List<WebElement> images;

    @FindBy (xpath = "//div[@id='content']//div[@class='row']//div[@class='row']//div[2]")
    private List<WebElement> text;


    public void verifyDynamicContent(){
        String[] imagesArr = new String[images.size()];
        String[] textArr = new String[text.size()];
        int count = 0;

        for (int i = 0; i < images.size(); i++) imagesArr[i] = images.get(i).getAttribute("src");
        for (int i = 0; i < text.size(); i++) textArr[i] = text.get(i).getText();
        driver.navigate().refresh();

        for (int i = 0; i < imagesArr.length; i++) if (!imagesArr[i].equals(images.get(i).getAttribute("src"))) count++;
        for (int i = 0; i < textArr.length; i++) if (!textArr[i].equals(text.get(i).getText())) count++;
        softAssert.assertTrue(count>0, "Content is not dynamic");
    }

}
