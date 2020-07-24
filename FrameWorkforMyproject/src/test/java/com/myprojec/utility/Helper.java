package com.myprojec.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	public static String capturescreenshot(WebDriver driver) {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/vyoma-"+Helper.getcurrentDataTime()+".png";
		try {
			FileHandler.copy(src,new File(screenshotpath));
			System.out.println("Screenshot is Captured");
		}
		catch(IOException e) {
			System.out.println("Unable to take screenshot"+e.getMessage());
		}
		return screenshotpath;
		
	}
	public static String getcurrentDataTime() {
		DateFormat df=new SimpleDateFormat("MM_dd_yyy_HH_mm_ss");
		Date currentdate=new Date();
		return df.format(currentdate);
	}
}
