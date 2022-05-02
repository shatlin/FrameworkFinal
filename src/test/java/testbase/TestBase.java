package testbase;
import com.google.common.io.Files;

import drivers.DriverSingleton;
import io.cucumber.plugin.event.TestCaseStarted;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import utils.Constants;
import utils.FrameworkProperties;


public class TestBase {
    public static WebDriver driver;
    public static String url;

    public static String testSuccessMsg;
    public static String  testFailedMsg;

    public static boolean isFinalTestStep=false;
    private static TestBase testBaseSingleton;

    public static File testReportFolder =null;

    public static Logger logger =null;

    public static FrameworkProperties frameworkProperties;
    public static ExtentSparkReporter spark;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    public static boolean isTestSuccessful = false;

    public static TestBase GetTestBase() throws IOException {

        if (testBaseSingleton ==null)
        {
            testBaseSingleton = new TestBase();
            setExecutionProperties();
        }
        return testBaseSingleton;
    }

    protected TestBase() {
    }

    public static void setExecutionProperties() throws IOException {

        frameworkProperties = new FrameworkProperties();

        url =frameworkProperties.getProperty(Constants.WEBSITE_TO_TEST);
        File logConfigFile = new File(System.getProperty(Constants.USER_DIR) + frameworkProperties.getProperty(Constants.LOG_FILE));
        System.setProperty(Constants.LOG4J2_CONFIG_FILE_NAME, logConfigFile.toURI().toString());
        logger = LogManager.getLogger(TestBase.class);
        testReportFolder= new File(Constants.TEST_REPORT_FOLDER);

        if(!(testReportFolder.isDirectory()))
            testReportFolder.mkdir();

        spark = new ExtentSparkReporter(Constants.EXTENT_START_REPORTER);
        extentReports = new ExtentReports();
        extentReports.attachReporter(spark);
    }

    public void beforeScenario(String ScenarioName)
    {

        DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
        driver = DriverSingleton.getDriver();
        extentTest = extentReports.createTest(ScenarioName);
        extentTest.log(Status.INFO,ScenarioName+Constants.STARTED);
        logger.info(ScenarioName+Constants.STARTED);
        driver.get(url);
    }
    public void afterScenario(String ScenarioName)
    {
        extentTest.log(Status.INFO,ScenarioName+Constants.COMPLETED);
        logger.info(ScenarioName+ Constants.COMPLETED);

        if(isFinalTestStep) {
            logger.info(Constants.ALL_COMPLETED);
            extentReports.flush();
        }
        DriverSingleton.closeObjectInstance();
    }

    public static String takeScreenShot() throws IOException {
        String dateName = Constants.DATE_NAME;
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        var imageName=Constants.IMAGE_NAME;
        String destination = testReportFolder.getAbsolutePath()+"\\"+imageName;
        Files.copy(source, new File(destination));
        return imageName;
    }

    public void afterTestStep() {

        if( testFailedMsg.length()==0 && testSuccessMsg.length()==0) return;
        try {
            if (isTestSuccessful)
            {
                 extentTest.log(Status.PASS, testSuccessMsg);
             }
             else
             {
                 extentTest.log(Status.FAIL, testFailedMsg);
                 extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
             }
        } catch (IOException e) {
            logger.error("Error at after Test Step"+ e.getMessage());
            throw new RuntimeException(e);
        }
        testSuccessMsg="";
        testFailedMsg="";
        isTestSuccessful =false;
    }
}
