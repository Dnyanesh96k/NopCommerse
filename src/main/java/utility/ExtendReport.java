package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReport {
public static ExtentReports getReport() {
	ExtentSparkReporter sparkReport= new ExtentSparkReporter("MyReport.html");
	ExtentReports report=new ExtentReports();
	report.attachReporter(sparkReport);
	report.setSystemInfo("reported By","Dnyaneshwar");
	report.setSystemInfo("TestType","Regression");
	return report;
}
}
