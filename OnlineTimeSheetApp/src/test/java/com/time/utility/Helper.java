package com.time.utility;

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
	public static void capturescreenshot(WebDriver driver) {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(src,new File("./Screenshots/Login_"+getcurrentDataTime()+".png"));
			System.out.println("Screenshot Capture");
		}
		catch(IOException e) {
			System.out.println("Unable to take screenshot"+e.getMessage());
		}
		
	}
	public static String getcurrentDataTime() {
		DateFormat df=new SimpleDateFormat("dd_MM_yyy_HH_mm_ss");
		Date currentdate=new Date();
		return df.format(currentdate);
	}
}
