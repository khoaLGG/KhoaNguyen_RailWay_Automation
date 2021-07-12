package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.GeneralPage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegisterPageTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    GeneralPage generalPage = new GeneralPage();
    RegisterPage registerPage = new RegisterPage();

    @BeforeMethod
    public void bm() {
        generalPage.gotoRegisterPage();
    }
    @Test(description = "TC07 - User can create new account")
    public void TC07()   {
        String email = registerPage.register(
                registerPage.GenerateEmail(),
                Constant.PASSWORD,
                Constant.PASSWORD,
                Constant.PID);
        System.out.println(email);
        String actualMsg = registerPage.getRegisterSuccessMsg();
        String expectedMsg = Constant.MSG_REGISTER_SUCCESSFULLY;
        Assert.assertEquals(
                actualMsg,
                expectedMsg,
                "The message content is not displayed correctly");
    }

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08()   {
        String email = registerPage.register(
                registerPage.GenerateEmail(),
                Constant.PASSWORD,
                Constant.PASSWORD,
                Constant.PID);
        generalPage.goToLoginPage();
        loginPage.login(email, Constant.PASSWORD);
        Assert.assertFalse(generalPage.isLoggedIn(),
                "User can login success when account hasn't been activated");
        Assert.assertTrue(loginPage.verifyMsgAccountHasNotBeenActivated(generalPage.isLoggedIn()),
                "The message content is not displayed correctly");
    }

    @Test(description = "TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"")
    public void TC10()   {
        registerPage.register(
                registerPage.GenerateEmail(),
                Constant.PASSWORD,
                Constant.CONFIRM_INVALID_PASSWORD,
                Constant.PID);
        String actualMsg = registerPage.getRegisterFailedMsg();
        String expectedMsg = Constant.MSG_REGISTER_FAILED;
        Assert.assertEquals(
                 actualMsg
                ,expectedMsg
                ,"The message content is not displayed correctly");
    }

    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11()   {
        registerPage.register(
                registerPage.GenerateEmail(),
                Constant.EMPTY_PASSWORD,
                Constant.EMPTY_CONFIRM_PASSWORD,
                Constant.EMPTY_PID);
        String actualMsg = registerPage.getRegisterFailedMsg();
        String expectedMsg = Constant.MSG_REGISTER_FAILED;
        Assert.assertEquals(
                 actualMsg
                ,expectedMsg
                ,"The main message content is not displayed correctly");
        actualMsg = registerPage.getPassWordFieldMsg();
        expectedMsg = Constant.MSG_PASSWORD_FIELD;
        Assert.assertEquals(
                 actualMsg
                ,expectedMsg
                ,"The message content of password fields is not displayed correctly");
        actualMsg = registerPage.getPIDFieldMsg();
        expectedMsg = Constant.MSG_PID_FIELD;
        Assert.assertEquals(
                actualMsg
                ,expectedMsg
                ,"The message content of PID fields is not displayed correctly");
    }
}
