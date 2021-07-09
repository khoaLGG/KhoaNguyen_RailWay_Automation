package Testcases.Railway;

import Common.Constant.Constant;
import DataObject.BookTicket.BookTicket;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyTicketTest extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    BookTicket bookTicket = new BookTicket();
    MyTicketPage myTicketPage = new MyTicketPage();

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        homePage.open();
        homePage.goToLoginPage();
    }


    @Test(description = "TC16 - User can cancel a ticket")
    public void TC16() throws InterruptedException {
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.goToBookTicket();
        bookTicketPage.bookTicket(bookTicket);
        loginPage.gotoMyTicketPage();
        String countItemBeforeDelete = myTicketPage.getPositionText();
        myTicketPage.deleteTicket(bookTicket.getDepartFrom()
                                                  ,bookTicket.getArriveAt()
                                                  ,bookTicket.getSeatType()
                                                  ,bookTicket.getDepartDate());
        String countItemAfterDelete = myTicketPage.getPositionText();
        Assert.assertFalse(myTicketPage.verifyTicketWasDeleted(countItemBeforeDelete, countItemAfterDelete), "Ticket cannot be deleted");

    }
}
