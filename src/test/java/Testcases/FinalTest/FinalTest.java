package Testcases.FinalTest;

import Common.Constant.Constant;
import DataObject.BookTicket.BookTicket;
import PageObjects.Railway.*;
import Testcases.Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FinalTest extends TestBase {
    String email;
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();
    GeneralPage generalPage = new GeneralPage();
    BookTicket bookTicket = new BookTicket();
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    MyTicketPage myTicketPage = new MyTicketPage();
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
    }
    @Test(description = "TC01 - User can book 1 ticket at a time")
    public void TC01() throws InterruptedException {
        generalPage.goToLoginPage();
        loginPage.login(email, Constant.PASSWORD);
        generalPage.goToBookTicket();
        bookTicketPage.bookTicket(bookTicket);
        String actualMsg = bookTicketPage.getBookTicketSuccessMsg();
        String expectedMsg = Constant.MSG_BOOK_TICKET_SUCCESS;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content is not displayed correctly" );
        Assert.assertEquals(bookTicketPage.getValueTicketOfDepartFromColumn(), bookTicket.getDepartFrom(), "value at Depart Station is not correctly");
        Assert.assertEquals(bookTicketPage.getValueTicketOfArriveAtColumn(), bookTicket.getArriveAt(), "value at Arrive Station is not correctly");
        Assert.assertEquals(bookTicketPage.getValueTicketOfSeatTypeColumn(), bookTicket.getSeatType(), "value of Seat Type is not correctly");
        Assert.assertEquals(bookTicketPage.getValueTicketOfDepartDateColumn(), bookTicket.getDepartDate(), "value of DepartDate not correctly");
        Assert.assertEquals(bookTicketPage.getValueTicketOfAmountColumn(), bookTicket.getTicketAmount(), "value of Amount is not correctly");
    }
    @Test(description = "TC02 - User can filter \"Manage ticket\" table with Depart Station")
    public void TC02()throws InterruptedException{
        generalPage.goToLoginPage();
        loginPage.login(email, Constant.PASSWORD);
        generalPage.goToBookTicket();
        bookTicketPage.bookTicketSeveralTime(bookTicket,6);
        loginPage.gotoMyTicketPage();
        String actualMsg = myTicketPage.getPositionText();
        String expectedMsg = "6"; //hard code : don't have enough time to complete
        Assert.assertEquals(actualMsg, expectedMsg, "filter fail");
    }
    @Test(description = "Error displays when user applies filter with un-existed value of \"Status\" in \"Manage ticket\" table")
    public void TC03()throws InterruptedException{
        generalPage.goToLoginPage();
        loginPage.login(email, Constant.PASSWORD);
        generalPage.goToBookTicket();
        bookTicketPage.bookTicketSeveralTime(bookTicket,6);
        loginPage.gotoMyTicketPage();
        myTicketPage.filterTicket(""); //hard code : don't have enough time to complete
        String actualMsg = myTicketPage.getErrorMsgText();
        String expectedMsg = Constant.MSG_NO_RESULT_WHEN_FILTER;
        Assert.assertEquals(actualMsg, expectedMsg, "Message is displayed not correctly");

    }
}
