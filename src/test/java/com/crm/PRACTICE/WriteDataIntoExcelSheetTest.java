package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataIntoExcelSheetTest {
	
	@Test
	public void writeDataIntoExcel() throws Throwable{
		
		//open file in read mode
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Data.xlsx"); 
		
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row ro = sh.getRow(4);
		
		//Create a cell to write a new data
		Cell ce= ro.createCell(1);
		
		//Set a cell value
		ce.setCellValue("ASD");
		
		//open a file in write mode
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Data.xlsx");
		wb.write(fos);
	}
}
