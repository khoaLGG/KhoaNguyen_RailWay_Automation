package Testcases.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    static ExtentReports extent;
    public static ExtentReports extentReportGenerator(){
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/Spark.html");
        reporter.config().setReportName("Railway Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Khoa Nguyen");
        return extent;
    }
}
