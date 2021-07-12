package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import WebDriver.*;

public class TestBase {
    HomePage homePage = new HomePage();
    webDriver webDriver = new webDriver();

    @BeforeClass
    public void beforeClass()   {
        webDriver.initializeDriver();
        webDriver.maximize();
    }

    @BeforeMethod
    public void beforeMethod()   {
        System.out.println("Pre-condition");
        homePage.open();
    }

    @AfterMethod
    public void afterMethod()  {
        System.out.println("Post-condition");
        homePage.logout();
    }
    @AfterClass
    public void afterClass() {
        Constant.WEBDRIVER.quit();
    }
}
