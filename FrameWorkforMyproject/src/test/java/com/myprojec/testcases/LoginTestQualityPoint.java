package com.myprojec.testcases;


import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.myprojec.pages.BaseClass;
import com.myprojec.pages.LoginPage;
import com.myprojec.utility.Helper;



public class LoginTestQualityPoint extends BaseClass {
	
	
	
 
	@Test
	public void LoginApplication() throws IOException {
		logger=report.createTest("Loginto application");
		LoginPage myloginpage=PageFactory.initElements(driver, LoginPage.class);
		logger.addScreenCaptureFromPath(Helper.capturescreenshot(driver),"first");
		logger.assignAuthor("Sharshini");
		logger.assignDevice("Online Time sheet");
		logger.info("Test Description:Login to application");
		logger.info("Step1: Entering UserName and Password");
		myloginpage.loginintoapp(excel.getStringData("LoginForAdmin", 0, 0),excel.getStringData("LoginForAdmin", 0, 1));
		//Helper.capturescreenshot(driver);
		logger.pass("Login is success");
		
		
	}
	
	
}
