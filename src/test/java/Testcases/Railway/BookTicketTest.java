package Testcases.Railway;

import Common.Common.GetDateToday;
import Common.Constant.Constant;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.annotations.*;

public class BookTicketTest extends TestBase {

    GetDateToday getDateToday = new GetDateToday();


    @Test(description = "TC04 - Login page displays when un-logged User clicks on Book ticket tab")
    public void TC04() {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("MyReport");
        spark.config().setReportName("Extent Report");
        extent.attachReporter(spark);
        ExtentTest test = extent.createTest("Login page displays when un-logged User clicks on Book ticket tab");
        generalPage.goToBookTicket();
        Assert.assertTrue(loginPage.isAtLoginPage(),"Login page don't displayed");
        test.pass("Login page displayed");
        extent.flush();
    }
    @Test(description = "TC14 - User can book 1 ticket at a time")
    public void TC14(){
        generalPage.goToLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
        loginPage.goToBookTicket();
        bookTicketPage.chooseDepartDate();
    }
}

