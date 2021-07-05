package Testcases.Railway;

import Common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegisterTest extends TestBase {

    @Test(description = "TC07 - User can create new account")
    public void TC07() {
        String email = register.register();
        System.out.println(email);
        String actualMsg = register.getRegisterSuccessMsg();
        String expectedMsg = Constant.MSG_REGISTER_SUCCESSFULLY;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content is not displayed correctly");
    }
    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08() {
        generalPage.gotoRegisterPage();
        String email = register.register();
        generalPage.gotoLoginPage();
        loginPage.login(email,Constant.PASSWORD);
        boolean check = generalPage.isLoggedIn();
        Assert.assertFalse(check,"User can login success when account hasn't been activated");
        check = loginPage.verifyMsgAccountHasNotBeenActivated(check);
        Assert.assertTrue(check,"The message content is not displayed correctly");
    }
}
