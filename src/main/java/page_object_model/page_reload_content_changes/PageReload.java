package page_object_model.page_reload_content_changes;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PageReload extends Base {

public PageReload(){
    PageFactory.initElements(driver,this);
}

@FindBy(xpath = "//div[@id='content']/div/div[2]")
private List<WebElement> allElements;

@FindBy(xpath = "//a[text()='click here']")
private WebElement staticLinkButton;

// loop through all element and get the displayed text of each element
public ArrayList<String> getContentTextOfEachElement(){
    ArrayList<String> result = new ArrayList<>();
    for (WebElement element:
         allElements) {
        result.add(element.getText());
    }
    return  result;
}
public void makeSomeElementsStatic(){
    clickOnElement(staticLinkButton);
}

}
