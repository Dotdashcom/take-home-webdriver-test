package task.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.utilities.BrowserUtils;
import task.utilities.Driver;

import java.util.List;

public class MouseHoverPage {

    public MouseHoverPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    Actions actions = new Actions(Driver.getDriver());

    //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


    @FindBy(xpath = "//img[@alt='User Avatar']")
    public List<WebElement> images;

    @FindBy(xpath = "//div[@class='figcaption']/h5")
    public List<WebElement> additionalText;


    public String hoverOver(List<WebElement> listOfElements, int index){

        actions.moveToElement(listOfElements.get(index)).perform();
        BrowserUtils.waitForVisibility(additionalText.get(index), 15);

       return additionalText.get(index).getText();
    }







}











