package testUtils;

import java.lang.reflect.Method;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class BaseClass {
	public static WebDriver driver;

	public static Properties property;
	public static Logger logger;
	
	//Exten Report
	private static String className;
	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> classLevelReport = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testLevelReport = new ThreadLocal<ExtentTest>();
	private static String testRunId;
	//
	
	@BeforeSuite
	public void setUpResources() {
		// Load Config Files
		property = TestUtilities.loadConfigProperties();
		//Instantiate Extent Reports for reporting the execution status
		extent = ExtentManager.getExtent();

	}

	@BeforeClass
	public void startClass() {
		//Creates a test Node at class level in the extent report
		ExtentTest parent = extent.createTest(getClass().getSimpleName());
		parent.assignCategory("Epic_Level_Report");
		classLevelReport.set(parent);

		//Creates a test Node at class level in the extent report
		className = this.getClass().getSimpleName().toString();
		logger = Logger.getLogger(className);
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/resources/propertyFiles/log4j.properties");
	}

	@BeforeMethod
	public void startMethod(Method m) {
		//Creates a test Node at class level in the extent report
		ExtentTest test = classLevelReport.get().createNode(m.getName());
		test.assignCategory("Test_Level_Report");
		testLevelReport.set(test);

		//Instantiates loggers at test level
		logger = Logger.getLogger(className + "---" + m.getName());
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/resources/propertyFiles/log4j.properties");

		//Invokes browser
		driver = DriverManager.getDriverInstance(property.getProperty("browser"), 20);

		//Embed WebDriver listeners into the driver		
		driver.get(property.getProperty("url"));

	}

	@AfterMethod
	public void killMethod(Method m, ITestResult result) {
		DriverManager.killDriverInstance();
		extent.flush();
	}



	@AfterClass
	public void killClass() {

	}

	@AfterSuite
	public void killResources() {

	}

	//Gets the newly created test run id
	public static String getTestRunId() {
		return testRunId;
	}

}
