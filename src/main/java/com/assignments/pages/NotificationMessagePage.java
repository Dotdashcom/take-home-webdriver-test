package com.assignments.pages;

import org.openqa.selenium.By;
import java.util.ArrayList;
import static com.assignments.enums.WaitStrategy.CLICKABLE;
import static com.assignments.enums.WaitStrategy.VISIBLE;

public final class NotificationMessagePage extends BasePage {
    private final By clickHereButton = By.xpath("//a[text()='Click here']");
    private final By flashMessage = By.cssSelector("#flash");
    public boolean clickMultipleTimesAndValidateIfFlashMessagesAreAsExpected() {
        ArrayList<String> al = new ArrayList();
        boolean flag = true;
        for (int i = 0; i<10;i++){
            click(clickHereButton, CLICKABLE,"Click Here");
            al.add(getText(flashMessage, VISIBLE, "Flash Message"));
        }

        for (int i=0; i<al.size();i++){
            if (!(al.get(i).contains("Action successful") ||
                    al.get(i).contains("Action unsuccesful, please try again"))){
                flag = false;
            }
        }
        return flag;
    }
}
