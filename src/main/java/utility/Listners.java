package utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners extends SwagLabsPageElement implements ITestListener {
 
public void onTestStart(ITestResult result) {
	System.out.println("Test is Start"+result.getName());
}
public void onTestFailure(ITestResult result) {
	try {
		Screenshot.takesScreenShot(driver, "dd");
	} catch (Exception e) {
	  e.printStackTrace();
	}
}
public void onTestSuccess(ITestResult result) {
	System.out.println("Test is Pass"+result.getName());
}
public void onTestSkipped(ITestResult result) {
	System.out.println("Test is Skip"+result.getName());
}
}

