package com.myprojec.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.myprojec.utility.BrowserFactory;
import com.myprojec.utility.ConfigDataProvider;
import com.myprojec.utility.ExcelDataProvider;
import com.myprojec.utility.Helper;

public class BaseClass {
	 public WebDriver driver;
	 public ExcelDataProvider excel;
	 public ConfigDataProvider config;
	 public ExtentReports report;
	 public ExtentTest logger;
	 
	 @BeforeSuite
	 public void setUpSuite() {
		 Reporter.log("Setting up report and Test is getting ready",true);
		  excel=new ExcelDataProvider();
		  config=new ConfigDataProvider();
		  ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/myproject_"+Helper.getcurrentDataTime()+".html"));
		  report=new ExtentReports();
		  report.attachReporter(extent);
		  Reporter.log("Setting Done-Test can be started",true);
	 }
	@BeforeClass
	public void setup() {
		Reporter.log("Trying to start Browser and Getting application ready",true);
		driver=BrowserFactory.startapplication(driver, config.getBrowser(),config.getStagingURL());
		System.out.println(driver.getTitle());
	    Reporter.log("Browser and Application is up and running",true);
	}
	
	@AfterMethod
	public void teardownmethod(ITestResult result) throws IOException  {
		Reporter.log("Test is about to end",true);
		if(result.getStatus()==ITestResult.FAILURE) {
			Helper.capturescreenshot(driver);
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			logger.skip("Test Skipped",MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		report.flush();
	}
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitbrowser(driver);
	}
}
