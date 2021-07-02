package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.GeneralPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BookTicketTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    GeneralPage generalPage = new GeneralPage();

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Webdriver/Executables/chromedriver.exe");
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
        homePage.gotoLoginPage();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        homePage.logout();
    }

    @Test(description = "TC04 - Login page displays when un-logged User clicks on Book ticket tab")
    public void TC04() {
        //System.out.println("TC04 - Login page displays when un-logged User clicks on Book ticket tab");
        generalPage.gotoBookTicket();
        Assert.assertTrue(loginPage.isAt(),"Login page don't displayed");
        /*LoginPage loginPage = new LoginPage();
        String actualMsg = loginPage.getNameLoginPage();
        String expectedMsg = "Login Page";
        Assert.assertTrue(loginPage.verifyLoginPagedIsDisplayed(), "Login page don't displayed");*/
        /*Assert.assertEquals(actualMsg,expectedMsg,"Login page don't displayed");*/
    }
}

