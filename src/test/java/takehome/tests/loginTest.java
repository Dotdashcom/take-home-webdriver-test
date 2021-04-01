package takehome.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import takehome.base.AbstractTestBase;

public class loginTest extends AbstractTestBase {


    @Test
    public  void verifyLogin(){
        nextVoteLogin.login("nextvote", "NextVote@777");
        nextVoteLogin.clickLogin();
        nextVoteLogin.fillFullName("James", "Bullis");
        Assert.assertEquals(nextVoteLogin.getFirstNameText().toLowerCase(), "james");
        Assert.assertEquals(nextVoteLogin.getLastNameTxt().toLowerCase(),"bullis");
    }

}
