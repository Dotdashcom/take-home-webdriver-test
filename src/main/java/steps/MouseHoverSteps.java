package steps;

import io.qameta.allure.Step;
import pages.MouseHoverPage;

public class MouseHoverSteps {

    MouseHoverPage mouseHoverPage = new MouseHoverPage();

    @Step("Check additional information for image {user}")
    public void getUserInfo(int user){
        mouseHoverPage.mouseHoverOnUser(user);
        mouseHoverPage.userInfoShouldBeVisible(user);
    }
}
