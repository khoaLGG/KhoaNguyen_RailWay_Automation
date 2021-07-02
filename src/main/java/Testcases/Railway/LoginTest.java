package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/Executables/chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
        // E:\JavaCoBan\SeleniumLevel-1\src\main
    }

    @AfterClass
    public void afterClass() {
        //Constant.WEBDRIVER.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        homePage.open();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        if (homePage.isLoggedIn()) {
            homePage.logout();
        }
    }

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        /*if (actualMsg.contentEquals(expectedMsg)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }*/
    }

    @Test
    public void TC02() {
        System.out.println("TC02_User can't login with blank Username textbox");
        homePage.gotoLoginPage();
        loginPage.login("", Constant.PASSWORD);
        String actualMsg = homePage.getErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not displayed as expected");
        //String errorMsg = loginPage1.getErrorMsg();
        //System.out.println(errorMsg);
        /*if (loginPage1.isMsgDisplayed()){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }*/
        /*if (Constant.WEBDRIVER.findElements(By.xpath("//p[contains(.,'There " +
                "was a problem with your login and/or errors exist in your form.')]")).size() != 0) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }*/
        /*Assert.assertTrue(loginPage.isusernametbblank(), "Test Failed");*/
    }

    @Test
    public void TC03() {
        System.out.println("TC03_User cannot log into Railway with invalid password ");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, "1");
        String actualMsg = homePage.getErrorMsg();
        System.out.println(actualMsg);
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message not displayed as expected");
    }

    @Test
    public void TC05() {
        System.out.println("TC05_System shows message when user enters wrong password several times");
        homePage.gotoLoginPage();
        loginPage.numberOfLogins(4);
        String actualMsg = homePage.getErrorMsg();
        String expectedMsg = "You have used 4 out of 5 login attempts. " +
                "After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "error message not displayed as expected");
    }

}
