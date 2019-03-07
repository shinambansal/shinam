package testUtils;
import java.util.Date;
import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentManager {
	
	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;
	private static String filePath=System.getProperty("user.dir")+"\\testResults\\extentReports\\extentReport.html";
	
	public static ExtentReports getExtent() {
		Date d = new Date();
		if(extent!=null) {
			return extent;
		}else {
			extent=new ExtentReports();
			extent.attachReporter(getHtmlReporter());
			extent.setSystemInfo("Owner", "DemoProject");
			extent.setSystemInfo("Environment",BaseClass.property.getProperty("environment"));
			extent.setSystemInfo("Platform",BaseClass.property.getProperty("platform"));
			extent.setSystemInfo("Run_Date",d.toString());
			
			extent.setAnalysisStrategy(AnalysisStrategy.TEST);
			return extent;
		}
	}
	
	
	public static ExtentHtmlReporter getHtmlReporter() {
		System.out.println(filePath);

		htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Demo Automation Report");
		htmlReporter.config().setReportName("Automation");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		
		htmlReporter.setAppendExisting(false);
//		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/resources/extentConfig/ReportsConfig.xml");

		return htmlReporter;
	}

}