package faridun.utils;

import faridun.Pages.LoginPage;
import faridun.Pages.OtherPages;

public class Pages {

    public static LoginPage loginPage;
    public static OtherPages pages;

    public static LoginPage loginPage() {
        if (loginPage == null)
            loginPage = new LoginPage();

        return loginPage;
    }

    public static OtherPages pages() {
        if (pages == null)
            pages = new OtherPages();

        return pages;
    }

}
