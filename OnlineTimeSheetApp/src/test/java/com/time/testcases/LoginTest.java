package com.time.testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.time.pages.BaseClass;
import com.time.pages.LoginPage;
import com.time.utility.Helper;



public class LoginTest extends BaseClass {
	@Test
	public void LoginApplication() {
		
		LoginPage myloginpage=PageFactory.initElements(driver, LoginPage.class);
		myloginpage.loginintovyoma(excel.getStringData("LoginForAdmin", 0, 0),excel.getStringData("LoginForAdmin", 0, 1));
		Helper.capturescreenshot(driver);
		
		
	}
	

}
