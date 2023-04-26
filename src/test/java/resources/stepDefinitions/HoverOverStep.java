package resources.stepDefinitions;

import resources.utilities.BaseClass;
import resources.pages.MouseHoverOverPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class HoverOverStep extends BaseClass {

    @Given("User launches the mousehover page")
    public void user_launches_the_mousehover() {
        BaseClass tb= new BaseClass();
        String addPath="hovers";
        tb.setupDownload(addPath);
    }
    @When("User switches to first image")
    public void movetoFirstImage() {
        MouseHoverOverPages mh= new MouseHoverOverPages();
        mh.hoverOnFirstImage();
    }

    @And("User verifies the first text")
    public void userVerifyFirstText() {
        MouseHoverOverPages mh= new MouseHoverOverPages();
        String text=mh.checkfirstText();
        Assert.assertEquals(text, prop.getProperty("FirstImgText"));
        System.out.println(text);
    }
    @When("User switches to second image")
    public void movetoSecondImage() {
        MouseHoverOverPages mh= new MouseHoverOverPages();
        mh.hoverOnSecondImage();

    }

    @And("User verifies the second text")
    public void userVerifySecondText() {
        MouseHoverOverPages mh= new MouseHoverOverPages();
        String text=mh.checkSecondText();
        Assert.assertEquals(text, prop.getProperty("SecImgText"));
        System.out.println(text);
    }

    @When("User switches to third image")
    public void movetoThirdImage() {
        MouseHoverOverPages mh= new MouseHoverOverPages();
        mh.hoverOnThirdImage();

    }

    @And("User reads the third text")
    public void userVerifyThirdText() {
        MouseHoverOverPages mh= new MouseHoverOverPages();
        String text=mh.checkThirdText();
        Assert.assertEquals(text, prop.getProperty("ThirdIngText"));
        System.out.println(text);
    }
}
