package steps;

import io.qameta.allure.Step;
import pages.CheckboxesPage;

public class CheckboxesSteps {

    CheckboxesPage checkboxesPage = new CheckboxesPage();

    @Step("Checks for checkbox 1")
    public void checksCheckbox1 (){
        checkboxesPage.checkboxShouldNoBeChecked(checkboxesPage.checkbox1);
        checkboxesPage.switchCheckbox(checkboxesPage.checkbox1);
        checkboxesPage.checkboxShouldBeChecked(checkboxesPage.checkbox1);
    }

    @Step("Checks for checkbox 2")
    public void checksСheckbox2 () {
        checkboxesPage.checkboxShouldBeChecked(checkboxesPage.checkbox2);
        checkboxesPage.switchCheckbox(checkboxesPage.checkbox2);
        checkboxesPage.checkboxShouldNoBeChecked(checkboxesPage.checkbox2);
    }
}
