package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class DropdownPages {

    private SelenideElement dropdown = $("#dropdown");

    @Step("Select element: {text} from dropdown")
    public void selectElementFromDropdown(String text){
        this.dropdown.selectOption(text);
    }

    @Step("Get selected option")
    public String getSelectedOption(){
        return this.dropdown.getSelectedOptionText();
    }
}
