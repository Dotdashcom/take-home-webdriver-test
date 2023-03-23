package steps;

import pages.FloatingMenuPage;

public class FloatingMenuSteps {

    FloatingMenuPage floatingMenuPage = new FloatingMenuPage();

    public void checkMenuAfterScroll(){
        floatingMenuPage.scrollPage();
        floatingMenuPage.isMenuDisplayed();
    }
}
