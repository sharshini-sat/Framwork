package com.myprojec.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	public ExcelDataProvider() {
		File src=new File("./TestData/Mydata.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			 wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable To Read Excel File"+e.getMessage());
		}
 }
	public String getStringData(int sheetindex,int row,int coloum) {
		return wb.getSheetAt(sheetindex).getRow(row).getCell(coloum).getStringCellValue();
		
	}
	public String getStringData(String sheetname,int row,int coloum) {
		return wb.getSheet(sheetname).getRow(row).getCell(coloum).getStringCellValue();
		
	}
	public double getNumaricalData(String sheetname,int row,int coloum) {
		return wb.getSheet(sheetname).getRow(row).getCell(coloum).getNumericCellValue(); 	
		
	}
}
