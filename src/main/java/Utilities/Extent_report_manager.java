package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_report_manager {

    public static ExtentSparkReporter report;
    public static ExtentReports extent;

    public static ExtentReports get_extent_report() {

        // Create a timestamp in format dd_MM_yyyy_HH_mm_ss
        String timeStamp = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date());

        // Create dynamic file path
        String filepath = System.getProperty("user.dir") + "\\Reports\\API_report_" + timeStamp + ".html";

        // Initialize Spark Reporter
        report = new ExtentSparkReporter(filepath);
        report.config().setDocumentTitle("Test Automation Using Rest Assured");
        report.config().setReportName("Get all Details");
        report.config().setTheme(Theme.DARK);

        // Initialize ExtentReports and attach the reporter
        extent = new ExtentReports();
        extent.attachReporter(report);

        // Add system information
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Browser", "Edge");
        extent.setSystemInfo("Tester", "Nikhil");
        extent.setSystemInfo("Environment", "QA");

        return extent;
    }
}
