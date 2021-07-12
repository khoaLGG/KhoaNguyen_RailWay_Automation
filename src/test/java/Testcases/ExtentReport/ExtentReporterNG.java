package Testcases.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    static ExtentReports extent;
    public static ExtentReports extentReportGenerator(){
        String path = System.getProperty("user.dir")+"\\reports\\result.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Railway Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Khoa Nguyen");
        return extent;
    }
}
