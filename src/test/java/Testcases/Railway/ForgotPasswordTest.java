package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends TestBase{

    protected String email;
    ServerError serverError = new ServerError();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    LoginPage loginPage = new LoginPage();
    GeneralPage generalPage = new GeneralPage();
    RegisterPage registerPage = new RegisterPage();

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        homePage.open();
        generalPage.gotoRegisterPage();
        email = registerPage.register(
                registerPage.GenerateEmail(),
                Constant.PASSWORD,
                Constant.PASSWORD,
                Constant.PID);
        generalPage.goToLoginPage();
    }
    @Test(description = "TC12 - Errors display when password reset token is blank")
    public void TC12(){
        loginPage.goToForgotPasswordPage();
        forgotPasswordPage.sendInstructions(email);
        Assert.assertFalse(serverError.verifyMailBoxDisplayed()
                ,"this testcase was blocked by open mailbox step");
    }
    @Test(description = "TC13 - Errors display if password and confirm password don't match when resetting password ")
    public void TC13(){
        loginPage.goToForgotPasswordPage();
        forgotPasswordPage.sendInstructions(email);
        Assert.assertFalse(serverError.verifyMailBoxDisplayed()
                ,"this testcase was blocked by open mailbox step");
    }
}
