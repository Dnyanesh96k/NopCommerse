package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
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
import pom.SwaglabAddToCart;
import utility.ExtendReport;
import utility.SwagLabsPageElement;
@Listeners(utility.Listners.class)
public class SwaglabAddToTest extends SwagLabsPageElement {
	ExtentReports report;
	ExtentTest test;
@BeforeTest
public void createReport() {
report=ExtendReport.getReport();
}
@BeforeMethod
public void openBrowser() throws EncryptedDocumentException, IOException {
	driver=Browser.OpenBrowser();
   SwagLabLoginPage log=new SwagLabLoginPage(driver);
   log.EnterUsername(0, 0);
   log.EnterPass(1, 0);
   log.ClickOnLogin();
}
@Test
public void AddToCart() {
	test=report.createTest("AddToCart");
	SwaglabAddToCart cart=new SwaglabAddToCart(driver);
	cart.ClickOnAddToCart();
	cart.ClickOnCart();
	cart.VerifyQuantity();
	}
@Test
public void RemoveFromCart() throws InterruptedException {
	test=report.createTest("RemoveFromCart");
	SwaglabAddToCart cart=new SwaglabAddToCart(driver);
	cart.ClickOnAddToCart();
	cart.ClickOnCart();
	Thread.sleep(2000);
	cart.ClickOnRemove();
	cart.VerifyRemove();
}
@Test
public void VerifyCheckout() {
	test=report.createTest("VerifyCheckout");
	SwaglabAddToCart cart=new SwaglabAddToCart(driver);
	cart.ClickOnAddToCart();
	cart.ClickOnCart();
	cart.ClickOnCheckout();
	cart.firstname("Dnyaneshwar");
	cart.lastname("Patil");
	cart.zipcode("422002");
	cart.ClickOnContinue();
	cart.ClickOnFinish();
	cart.thanksMessage();
}
@Test
public void VerifyContinueShopping() {
	test=report.createTest("VerifyContinueShopping");
	SwaglabAddToCart cart=new SwaglabAddToCart(driver);
	cart.ClickOnAddToCart();
	cart.ClickOnCart();	
	cart.ContinueShipping();
	String ActualResult=driver.getTitle();
	String ExpectedResult="Swag Labs";
	Assert.assertEquals(ActualResult, ExpectedResult);
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

