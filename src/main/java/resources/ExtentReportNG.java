package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReport() {
		
		String path = System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter  reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Ecommerce Test Results");
		reporter.config().setDocumentTitle("Test results - 2024");
		extent  = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nabeel Andoroathodi");
		return extent;
	}

}
