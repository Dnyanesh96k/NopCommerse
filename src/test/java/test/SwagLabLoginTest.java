package test;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabLoginPage;
import utility.SwagLabsPageElement;
import utility.ExtendReport;
@Listeners(utility.Listners.class)
public class SwagLabLoginTest extends SwagLabsPageElement {
	ExtentReports report;
	ExtentTest test;
	
@BeforeTest
public void createReport() {
	report=ExtendReport.getReport();
}
@BeforeMethod
public void openBrowser() {
	driver=Browser.OpenBrowser();
}
@Test
public void LoginWithValidCredentials() throws EncryptedDocumentException, IOException {
	test=report.createTest("LoginWithValidCredentials");
	SwagLabLoginPage page=new SwagLabLoginPage(driver);
	page.EnterUsername(0,0);
	page.EnterPass(1, 0);
	page.ClickOnLogin();
}
@AfterMethod
public void addResult(ITestResult result) {
	if(result.getStatus()==ITestResult.SUCCESS) {
		test.log(Status.PASS, result.getName());
	}
	else if(result.getStatus()==ITestResult.FAILURE) {
		test.log(Status.FAIL, result.getName());
	}
	else {
		test.log(Status.SKIP, result.getName());
	}
	
}
@AfterTest
public void  flushReport() {
	report.flush();
}
}
