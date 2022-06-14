package Utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporting {

	private ExtentReports reports;
	private ExtentTest test;

	public ExtentReporting(String filePath, String reportName) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(false); // Disable Dash board view
		htmlReporter.config().setDocumentTitle("Assignment - ExtentReports");
		htmlReporter.config().setReportName(reportName);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("dd/MMM/yyyy hh:mm:ss a");
		htmlReporter.config().setEncoding("UTF-8");

		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
	}

	public void initializeExtentTest(String testName, String description, String author, String category) {
		test = reports.createTest(testName, description);
		test.assignAuthor(author);
		test.assignCategory(category);
	}

	public void log(Status status, String details) {
		test.log(status, details);
	}

	public void createImageForLog(Status status, String details, String path) {
		try {
			test.log(status, details, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void finish() {
		reports.flush();
	}

	// Basic sample example
	public static void main(String[] args) {
		ExtentReporting er = new ExtentReporting("results/extent.html", "Test Report 1");
		er.initializeExtentTest("Test Name", "Test Description", "Gauri Narula", "");
		er.log(Status.PASS, "This step is passed");
		er.log(Status.INFO, "This step is an info");
		er.log(Status.FAIL, "This step is failed");
		er.createImageForLog(Status.FAIL, "details", "../images/Registration.png");
		er.finish();
	}
}