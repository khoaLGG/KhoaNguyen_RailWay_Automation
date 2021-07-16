package Testcases.example;

import Common.Constant.Constant;
import DataObject.BookTicket.BookTicket;
import PageObjects.Railway.*;
import Testcases.Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test1 extends TestBase {
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
    @Test(description = "TC04 - Login page displays when un-logged User clicks on Book ticket tab")
    public void TC0a() throws InterruptedException {
        generalPage.goToLoginPage();
        loginPage.login(email, Constant.PASSWORD);
        generalPage.goToBookTicket();
        bookTicketPage.bookTicketSeveralTime(bookTicket,6);
        loginPage.gotoMyTicketPage();
        myTicketPage.filterTicket(""); //hard code : don't have enough time to complete

    }

}
