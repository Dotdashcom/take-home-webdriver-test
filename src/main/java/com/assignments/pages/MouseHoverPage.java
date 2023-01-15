package com.assignments.pages;

import org.openqa.selenium.By;
import java.util.Collections;
import java.util.List;
import static com.assignments.enums.WaitStrategy.CLICKABLE;
import static com.assignments.enums.WaitStrategy.VISIBLE;

public final class MouseHoverPage extends BasePage {

    private final List<By> userAvatar = Collections.singletonList(By.xpath("//img[@alt='User Avatar']"));

    private final List<By> viewProfileButton = Collections.singletonList(By.className("figcaption"));

    public boolean validateMouseHover() {
        boolean flag = true;
        int s=userAvatar.size();
        for (int i=0; i<userAvatar.size(); i++) {
            mouseHover(userAvatar.get(i), CLICKABLE);
            if (!isDisplayed(viewProfileButton.get(i), VISIBLE, "Profile Button")) {
                flag = false;
            }
        }
        return flag;
    }
}
