package API.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtenReports implements ITestListener{
	
	private static ExtentReports extent;
    private static ExtentTest test;

    // Initialize report
    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter spark = new ExtentSparkReporter("Reports/API_Test_Report.html");
        spark.config().setDocumentTitle("API Automation Report");
        spark.config().setReportName("RestAssured Test Results");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Vivekanand Deshmukh");
        extent.setSystemInfo("Environment", "QA");
    }

    // Create a test entry
    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    // On test success
    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed: " + result.getMethod().getMethodName());
    }

    // On test failure
    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test Failed: " + result.getMethod().getMethodName());
        test.fail(result.getThrowable());  // logs the exception
    }

    // On test skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped: " + result.getMethod().getMethodName());
        test.skip(result.getThrowable());
    }

    // Finalize report
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
	

}
