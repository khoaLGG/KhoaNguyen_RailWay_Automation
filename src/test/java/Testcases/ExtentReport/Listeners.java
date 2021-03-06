package Testcases.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners  implements ITestListener {

    ExtentReports extent = ExtentReporterNG.extentReportGenerator();
    ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getDescription());

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.log(Status.PASS,"Successful");
        test.pass(MarkupHelper.createLabel(iTestResult.getName()+"Test case passed", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(MarkupHelper.createLabel(result.getName()+"Test case failed", ExtentColor.RED));
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.log(Status.SKIP,"Blocked");
        test.fail(MarkupHelper.createLabel(iTestResult.getName()+"Test case blocked ", ExtentColor.YELLOW));
        test.fail(iTestResult.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extent.flush();
    }


}