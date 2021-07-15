package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.GeneralPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.TicketPricePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TicketPriceTest extends TestBase {
    GeneralPage generalPage = new GeneralPage();
    HomePage homePage = new HomePage();
    TicketPricePage ticketPricePage = new TicketPricePage();

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        homePage.open();
        generalPage.goToTicketPricePage();
    }
    @Test
    public void TC_test(){
        ticketPricePage.checkPriceFromTicketPricePage(Constant.DEPART_FROM, Constant.ARRIVE_AT);
    }
}
