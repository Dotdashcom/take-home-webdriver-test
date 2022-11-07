package PageObjects;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DragDropPage {

    public WebDriver driver;

    public DragDropPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "column")
    private List<WebElement> columns;

    @FindBy(id = "column-a")
    private WebElement columnA;
    @FindBy(id = "column-b")
    private WebElement columnB;


public boolean dropColumnAToB(int indexA, int indexB) throws InterruptedException {
    String text =columns.get(indexB).getText();
    Helpers.DragElementToElement(columnA,columnB);
  return text.equalsIgnoreCase(columns.get(indexA).getText());
}


    public boolean ValidateChange(String text){

        return driver.switchTo().alert().getText().contains(text);

    }


}
