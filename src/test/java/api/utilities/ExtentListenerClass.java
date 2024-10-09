package api.utilities;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
 
public class ExtentListenerClass implements ITestListener {
    private ExtentSparkReporter htmlReporter;
    private ExtentReports reports;
    private ExtentTest test;
 
    public void configureReport() {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String reportName = "petStoreAutomationTestReport-" + timestamp + ".html";
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports//" + reportName);
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
 
      
        reports.setSystemInfo("Machine", "testpc1");
        reports.setSystemInfo("OS", "Windows 11");
        reports.setSystemInfo("User Name", "vaishnavi");
 
  
        htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
        htmlReporter.config().setReportName("This is my First Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }
 
    public void onStart(ITestContext context) {
        configureReport();
        System.out.println("On Start method invoked....");
    }
 
    public void onFinish(ITestContext context) {
        System.out.println("On Finish Method invoked....");
        reports.flush(); 
    }
 
    public void onTestStart(ITestResult result) {
        System.out.println("Name of test method started: " + result.getName());
        test = reports.createTest(result.getName()); 
    }
 
    public void onTestSuccess(ITestResult result) {
        System.out.println("Name of test method successfully executed: " + result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Name of the pass test case is: " + result.getName(), ExtentColor.GREEN));
    }
 
    public void onTestFailure(ITestResult result) {
        System.out.println("Name of test method failed: " + result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + result.getName(), ExtentColor.RED));
    }
 
    public void onTestSkipped(ITestResult result) {
        System.out.println("Name of test method skipped: " + result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped test case is: " + result.getName(), ExtentColor.YELLOW));
    }
 
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }
}