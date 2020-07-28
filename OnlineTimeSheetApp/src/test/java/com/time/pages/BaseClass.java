package com.time.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.time.utility.BrowserFactory;
import com.time.utility.ConfigDataProvider;
import com.time.utility.ExcelDataProvider;
import com.time.utility.Helper;


public class BaseClass {
	 public WebDriver driver;
	 public ExcelDataProvider excel;
	 public ConfigDataProvider config;
	 
	 @BeforeSuite
	 public void setUpSuite() {
		  excel=new ExcelDataProvider();
		  config=new ConfigDataProvider();
	 }
	@BeforeClass
	public void setup() {
		driver=BrowserFactory.startapplication(driver, config.getBrowser(),config.getStagingURL());
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void teardownmethod(ITestResult result)  {
		if(result.getStatus()==ITestResult.FAILURE) {
			Helper.capturescreenshot(driver);
		}
	}
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitbrowser(driver);
	}
}
