package Testcases.Railway;

import Common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends TestBase{

    protected String email;

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
        generalPage.gotoLoginPage();
    }
    @Test(description = "TC12 - Errors display when password reset token is blank")
    public void TC12(){
        loginPage.goToForgotPasswordPage();
        forgotPasswordPage.sendInstructions(email);
        Assert.assertFalse(serverError.verifyMailBoxDisplayed()
                ,"this testcase was blocked by open mailbox step ");
    }
}
