package Testcases.Railway;

import Common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.*;

public class BookTicketTest extends TestBase {

    @Test(description = "TC04 - Login page displays when un-logged User clicks on Book ticket tab")
    public void TC04() {
        generalPage.goToBookTicket();
        Assert.assertTrue(loginPage.isAtLoginPage(),"Login page don't displayed");
    }
    @Test(description = "TC14 - User can book 1 ticket at a time")
    public void TC14(){
        generalPage.goToLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
        loginPage.goToBookTicket();
    }
}

