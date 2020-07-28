package com.time.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	 public void Loginpage(WebDriver ldriver) {
		  this.driver=ldriver; 	
	 }
	 @FindBy(id="username")WebElement uname;
	 @FindBy(name="password")WebElement upass;
	 @FindBy(name="login")WebElement login;
	 
	 //****Methods**************************
	 public void loginintovyoma(String usernamevyoma,String userpasswordvyoma) {
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
	 	uname.sendKeys(usernamevyoma);
	 	upass.sendKeys(userpasswordvyoma);
	 	login.click();
	 }
}
