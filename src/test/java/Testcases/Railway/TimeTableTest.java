package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.GeneralPage;
import PageObjects.Railway.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TimeTableTest extends TestBase{

    GeneralPage generalPage = new GeneralPage();
    LoginPage loginPage = new LoginPage();
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        homePage.open();
        generalPage.goToLoginPage();

    }
    @Test(description = "TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC15(){
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        generalPage.goToTimeTableTab();
        
    }
}
