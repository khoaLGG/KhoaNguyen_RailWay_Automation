package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    GeneralPage generalPage = new GeneralPage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

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
        generalPage.gotoRegisterPage();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
       // homePage.logout();
    }
}
