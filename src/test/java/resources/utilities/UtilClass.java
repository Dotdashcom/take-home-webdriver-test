package resources.utilities;

import org.openqa.selenium.WebElement;

public class UtilClass {

    public static boolean verifyCheckIfCheckBoxIsChecked(WebElement element) {
        Boolean status=element.isSelected();
        return status;
    }
    public static void clicksCheckBox(WebElement element) {
        element.click();
    }

}
