package pages;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.BrowserUtils;

import java.util.List;

public class DropdownPage extends PageBase {
    @FindBy(xpath = "//*[@id='dropdown']")
    protected WebElement selectOptions;

    public void setSelectOptions(){
        Select select = new Select(selectOptions);
        List<WebElement> list = select.getOptions();

        for (int i=0;i<list.size();i++){
            list.get(i).click();
            BrowserUtils.wait(1);
            Assert.assertTrue(list.get(i).isSelected());
            BrowserUtils.wait(1);
        }
    }
}