package Testcases.Railway;

import Common.Constant.Constant;
import DataObject.BookTicket.BookTicket;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.GeneralPage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class BookTicketTest extends TestBase {


    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();
    GeneralPage generalPage = new GeneralPage();
    BookTicket bookTicket = new BookTicket();

    @Test(description = "TC04 - Login page displays when un-logged User clicks on Book ticket tab")
    public void TC04() {
      generalPage.goToBookTicket();
      Assert.assertTrue(loginPage.isAtLoginPage(),"Login page don't displayed");
    }
    @Test(description = "TC14 - User can book 1 ticket at a time")
    public void TC14()  {
        generalPage.goToLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
        loginPage.goToBookTicket();
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
}

