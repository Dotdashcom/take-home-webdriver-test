package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DynamicContentPage extends BasePage{
    public DynamicContentPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h3[contains(.,'Dynamic Content')]")
    public WebElement dynamicContextPageHeader;
    @FindBy(xpath = "//img[contains(@src,'/img/avatars/Original-Facebook-Geek-Profile-Avatar')]")
    public List<WebElement> dynamicPictures;
    @FindBy(xpath = "//div[@class='large-10 columns']")
    public List<WebElement> dynamicTexts;
    public Boolean dynamicContextPageLanding(){
        dynamicContextPageHeader.isDisplayed();
        for (WebElement dynamicPictures: dynamicPictures) {
            dynamicPictures.isDisplayed();
        }
        for (WebElement dynamicText: dynamicTexts) {
            dynamicText.isDisplayed();
        }
        return true;
    }

    public String getDynamicContentText(String option){
        String dynamicText;
        switch (option){
            case "1":
                return dynamicTexts.get(0).getText();
            case "2":
                dynamicText = dynamicTexts.get(1).getText();
                break;
            case "3":
                dynamicText = dynamicTexts.get(2).getText();
                break;
            default: dynamicText = null;
        }
        return dynamicText;
    }
    public String getDynamicContentPicture(String option){
        switch (option){
            case "1":
                return dynamicPictures.get(0).getAttribute("src").toString();
            case "2":
                return dynamicPictures.get(1).getAttribute("src").toString();
            case "3":
                return dynamicPictures.get(2).getAttribute("src").toString();
        }
        return null;
    }

}
