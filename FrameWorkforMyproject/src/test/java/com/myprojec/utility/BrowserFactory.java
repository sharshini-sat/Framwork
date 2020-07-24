package com.myprojec.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	public static WebDriver startapplication(WebDriver driver,String browsername,String applicationurl) {
		 if(browsername.equals("Chrome")) {
			 System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				driver = new ChromeDriver(); 	
		 }
		 else if (browsername.equals("Firefox")) {
			 System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
				driver = new FirefoxDriver(); 	
		 }
		 else {
			 System.out.println("We do not support this browser");
		 }
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get(applicationurl);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 return driver;
	 }
	 
	 public  static void quitbrowser(WebDriver driver) {
		 driver.quit();
	 }
}
