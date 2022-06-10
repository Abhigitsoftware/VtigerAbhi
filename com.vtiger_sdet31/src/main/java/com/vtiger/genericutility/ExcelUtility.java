package com.vtiger.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache POi libraries , which used to handle Microsoft Excel sheet
 * @author Abhishek
 *
 */

public class ExcelUtility {
 /**
  *  its used read the data from excel based on below arguments 
  * @param sheetName
  * @param rowNum
  * @param celNum
  * @return Data
 * @throws Throwable 
  * @throws Throwable
  */
	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable {
		FileInputStream fin = new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}
 /**
  * used to get the last used row number on specified Sheet
  * @param sheetName
  * @return
 * @throws Throwable 
  * @throws Throwable
  */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fin = new FileInputStream(".\\src\\main\\resources\\TestData\\testData.xlsx");
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	
	
	public void setDataExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {
		FileInputStream fin = new FileInputStream(".\\src\\main\\resources\\TestData\\testData.xlsx");
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(".\\src\\main\\resources\\TestData\\testData.xlsx");
		wb.write(fos);
		wb.close();
	}
}
