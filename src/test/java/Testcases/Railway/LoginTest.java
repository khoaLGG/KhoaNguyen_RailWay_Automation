package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.GeneralPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    GeneralPage generalPage = new GeneralPage();

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Webdriver/Executables/chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        //Constant.WEBDRIVER.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        homePage.open();
        homePage.gotoLoginPage();
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
        loginPage.numberOfLogins(4);
        String actualMsg = homePage.getErrorMsg();
        String expectedMsg = Constant.MSG_RUN_OUT_OF_TRY_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg, "error message not displayed as expected");
    }

    @Test(description = "TC06_Additional pages display once user logged in")
    public void TC06() {
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        boolean check = loginPage.verifyMyTicketTabDisplayed();
        Assert.assertTrue(check, "\"My Ticket\" tab not showing");
        check = loginPage.verifyChangePasswordTabDisplayed();
        Assert.assertTrue(check, "\"Change Password\" tab not showing");
        check = loginPage.verifyLogoutTabDisplayed();
        Assert.assertTrue(check, "\"Logout\" tab not showing");
        loginPage.gotoMyTicketTab();
        check = loginPage.isAtMyTicketPage();
        Assert.assertTrue(check, "user can't navigate to My ticket page");
        loginPage.gotoChangePasswordPage();
        check = loginPage.isAtChangePasswordPAge();
        Assert.assertTrue(check, "user can't navigate to Change password page");
    }



}
