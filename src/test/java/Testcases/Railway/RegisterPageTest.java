package Testcases.Railway;

import Common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegisterPageTest extends TestBase {

    @Test(description = "TC07 - User can create new account")
    public void TC07() {
        String email = registerPage.register(
                registerPage.GenerateEmail(),
                Constant.PASSWORD,
                Constant.PASSWORD,
                Constant.PID);
        System.out.println(email);
        String actualMsg = registerPage.getRegisterSuccessMsg();
        String expectedMsg = Constant.MSG_REGISTER_SUCCESSFULLY;
        Assert.assertEquals(actualMsg, expectedMsg, "The message content is not displayed correctly");
    }

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08() {
        generalPage.gotoRegisterPage();
        String email = registerPage.register(
                registerPage.GenerateEmail(),
                Constant.PASSWORD,
                Constant.PASSWORD,
                Constant.PID);
        generalPage.gotoLoginPage();
        loginPage.login(email, Constant.PASSWORD);
        Assert.assertFalse(generalPage.isLoggedIn(),
                "User can login success when account hasn't been activated");
        Assert.assertTrue(loginPage.verifyMsgAccountHasNotBeenActivated(generalPage.isLoggedIn()),
                "The message content is not displayed correctly");
    }

    @Test(description = "TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"")
    public void TC10() {

    }
}
