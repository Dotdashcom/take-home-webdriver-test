package LocalHost.Tests;

import LocalHost.Pages.HoverPage;
import org.testng.annotations.Test;

public class Hover extends TestingBase{

    @Test(groups = "Hover")
    public void Hover1(){
        HoverPage page = new HoverPage();
        page.hoverUser1();
    }

    @Test(groups = "Hover")
    public void Hover2(){
        HoverPage page = new HoverPage();
        page.hoverUser2();
    }

    @Test(groups = "Hover")
    public void Hover3(){
        HoverPage page = new HoverPage();
        page.hoverUser3();
    }


}
