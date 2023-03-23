package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class DragAndDropPage {

    public SelenideElement elementA = $("#column-a");
    public SelenideElement elementB = $("#column-b");

    public void dragElements (SelenideElement elementFrom, SelenideElement elementTo){
        elementFrom.dragAndDropTo(elementTo);
    }

    @Step("Get element text")
    public String getElementText(SelenideElement element){
        return element.getText();
    }

}
