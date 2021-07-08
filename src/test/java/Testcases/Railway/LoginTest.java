package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        homePage.open();
        homePage.goToLoginPage();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        homePage.logout();
    }

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = homePage.getWelcomeMessageText();
        String expectedMsg = String.format(Constant.MSG_WELCOME_USER, Constant.USERNAME);
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test(description = "TC02_User can't login with blank Username textbox")
    public void TC02() {
        loginPage.login("", Constant.PASSWORD);
        String actualMsg = loginPage.getErrorMsg();
        String expectedMsg = Constant.MSG_PROBLEM_WITH_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not displayed as expected");

    }

    @Test(description = "TC03_User cannot log into Railway with invalid password ")
    public void TC03() {
        loginPage.login(Constant.USERNAME, "1");
        String actualMsg = homePage.getErrorMsg();
        System.out.println(actualMsg);
        String expectedMsg = Constant.MSG_INVALID_USERNAME_PASSWORD;
        Assert.assertEquals(actualMsg, expectedMsg, "error message not displayed as expected");
    }

    @Test(description = "TC05_System shows message when user enters wrong password several times")
    public void TC05() {
        loginPage.numberOfLogins(Constant.NUMBER_OF_LOGIN);
        String actualMsg = homePage.getErrorMsg();
        String expectedMsg = Constant.MSG_RUN_OUT_OF_TRY_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg, "error message not displayed as expected");
    }

    @Test(description = "TC06_Additional pages display once user logged in")
    public void TC06() {
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        Assert.assertTrue(loginPage.verifyMyTicketTabDisplayed(), "\"My Ticket\" tab not showing");
        Assert.assertTrue(loginPage.verifyChangePasswordTabDisplayed(), "\"Change Password\" tab not showing");
        Assert.assertTrue(loginPage.verifyLogoutTabDisplayed(), "\"Logout\" tab not showing");
        loginPage.gotoMyTicketTab();
        Assert.assertTrue(loginPage.isAtMyTicketPage(), "user can't navigate to My ticket page");
        loginPage.gotoChangePasswordPage();
        Assert.assertTrue(loginPage.isAtChangePasswordPAge(), "user can't navigate to Change password page");
    }



}
