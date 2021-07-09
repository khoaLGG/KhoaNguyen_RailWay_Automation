package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.GeneralPage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.TimeTablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TimeTableTest extends TestBase{

    GeneralPage generalPage = new GeneralPage();
    TimeTablePage timeTablePage = new TimeTablePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    
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
        timeTablePage.bookTicketFromTimeTablePage(Constant.DEPART_FROM, Constant.ARRIVE_AT);
        String actualMsg = bookTicketPage.getContentBookTicketPage();
        String expectedMsg = Constant.MSG_CONTENT_OF_BOOK_TICKET_PAGE;
        Assert.assertEquals(actualMsg, expectedMsg, "you are is not at book ticket page");
        actualMsg = bookTicketPage.valueSelectedOfDepartStation();
        expectedMsg = Constant.DEPART_FROM;
        Assert.assertEquals(actualMsg, expectedMsg, "value of depart from not correctly");
        actualMsg = bookTicketPage.valueSelectedOfArriveAt();
        expectedMsg = Constant.ARRIVE_AT;
        Assert.assertEquals(actualMsg, expectedMsg, "value of arrive at not correctly");
    }
}
